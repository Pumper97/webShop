package ua.com.shop.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import ua.com.shop.dto.form.SizeFOrm;
import ua.com.shop.service.SizeService;
import ua.com.shop.validator.SizeValidator;

@Controller
@RequestMapping("/admin/size")
@SessionAttributes("size")
public class SizeController {
	@Autowired
	private SizeService sizeService;

	@InitBinder("size")
	protected void bind(WebDataBinder binder) {
		binder.setValidator(new SizeValidator(sizeService));
	}

	@ModelAttribute("size")
	public SizeFOrm getForm() {
		return new SizeFOrm();
	}

	@GetMapping
	public String show(Model model) {
		model.addAttribute("sizes", sizeService.findAll());
		return "admin-size";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("size", sizeService.findForm(id));
		return show(model);
	}

	@GetMapping("delete/{id}")
	public String delete(@PathVariable int id) {
		sizeService.delete(id);
		return "redirect:/admin/size";
	}

	@PostMapping
	public String save(@ModelAttribute("size") @Valid SizeFOrm size,
			BindingResult br, Model model, SessionStatus status) {
		if (br.hasErrors()) {
			return show(model);
		}
		sizeService.save(size);
		status.setComplete();
		return "redirect:/admin/size";
	}
}
