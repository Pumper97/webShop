package ua.com.shop.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.shop.dto.filter.BrandFilter;
import ua.com.shop.entity.Brand;
import ua.com.shop.service.BrandService;
import ua.com.shop.validator.BrandValidator;
import static ua.com.shop.util.ParamBuilder.*;
@Controller
@RequestMapping("/admin/brand")
@SessionAttributes("brand")
public class BrandController {
	@Autowired
	private BrandService brandService;

	@InitBinder("brand")
	protected void bind(WebDataBinder binder) {
		binder.setValidator(new BrandValidator(brandService));
	}

	@ModelAttribute("brand")
	public Brand getForm() {
		return new Brand();
	}

	@ModelAttribute("filter")
	public BrandFilter getFilter() {
		return new BrandFilter();
	}

	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") BrandFilter filter) {
		model.addAttribute("page", brandService.findAll(filter, pageable));
		return "admin-brand";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") BrandFilter filter) {
		model.addAttribute("brand", brandService.findOne(id));
		return show(model, pageable, filter);
	}

	@GetMapping("delete/{id}")
	public String delete(@PathVariable int id,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") BrandFilter filter) {
		brandService.delete(id);
		return "redirect:/admin/brand"+getParams(pageable, filter);
	}

	@PostMapping
	public String save(@ModelAttribute("brand") @Valid Brand brand,
			BindingResult br, Model model, SessionStatus status,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") BrandFilter filter) {
		if (br.hasErrors()) {
			return show(model, pageable, filter);
		}
		brandService.save(brand);
		status.setComplete();
		return "redirect:/admin/brand"+getParams(pageable, filter);
	}
}