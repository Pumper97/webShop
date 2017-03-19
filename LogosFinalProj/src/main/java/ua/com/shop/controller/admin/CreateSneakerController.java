package ua.com.shop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.shop.dto.filter.SneakerFilter;
import ua.com.shop.editor.BrandEditor;
import ua.com.shop.editor.ColorEditor;
import ua.com.shop.editor.GenderEditor;
import ua.com.shop.editor.ModelEditor;
import ua.com.shop.editor.SeasonEditor;
import ua.com.shop.editor.SizeEditor;
import ua.com.shop.entity.Brand;
import ua.com.shop.entity.Color;
import ua.com.shop.entity.Gender;
import ua.com.shop.entity.Season;
import ua.com.shop.entity.Size;
import ua.com.shop.entity.Sneaker;
import ua.com.shop.service.BrandService;
import ua.com.shop.service.ColorService;
import ua.com.shop.service.GenderService;
import ua.com.shop.service.ModelService;
import ua.com.shop.service.SeasonService;
import ua.com.shop.service.SizeService;
import ua.com.shop.service.SneakerService;
import ua.com.shop.util.ParamBuilder;

@Controller
@RequestMapping("/admin/sneaker")
@SessionAttributes("sneaker")
public class CreateSneakerController {
	@Autowired
	private BrandService brandService;
	@Autowired
	private SizeService sizeService;
	@Autowired
	private ModelService modelService;
	@Autowired
	private SneakerService sneakerService;
	@Autowired
	private SeasonService seasonService;
	@Autowired
	private GenderService genderService;
	@Autowired
	private ColorService colorService;

	@InitBinder("sneaker")
	protected void bind(WebDataBinder binder) {
		binder.registerCustomEditor(Brand.class, new BrandEditor(brandService));
		binder.registerCustomEditor(Size.class, new SizeEditor(sizeService));
		binder.registerCustomEditor(ua.com.shop.entity.Model.class,
				new ModelEditor(modelService));
		binder.registerCustomEditor(Season.class, new SeasonEditor(
				seasonService));
		binder.registerCustomEditor(Gender.class, new GenderEditor(
				genderService));
		binder.registerCustomEditor(Color.class, new ColorEditor(colorService));
	}

	@ModelAttribute("sneaker")
	public Sneaker getForm() {
		return new Sneaker();
	}

	@ModelAttribute("filter")
	public SneakerFilter getFilter() {
		return new SneakerFilter();
	}

	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") SneakerFilter filter) {
		model.addAttribute("genders", genderService.findAll());
		model.addAttribute("seasons", seasonService.findAll());
		model.addAttribute("colors", colorService.findAll());
		model.addAttribute("brands", brandService.findAll());
		model.addAttribute("sizes", sizeService.findAll());
		model.addAttribute("models", modelService.findAll());
		model.addAttribute("page", sneakerService.findAll(pageable, filter));
		return "admin-sneaker";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") SneakerFilter filter) {
		sneakerService.delete(id);
		return "redirect:/admin/sneaker" + getParams(pageable, filter);
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") SneakerFilter filter) {
		model.addAttribute("sneaker", sneakerService.findOne(id));
		return show(model, pageable, filter);
	}

	@PostMapping
	public String save(@ModelAttribute("sneaker") Sneaker sneaker,
			SessionStatus status, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") SneakerFilter filter) {
		sneakerService.save(sneaker);
		status.setComplete();

		return "redirect:/admin/sneaker" + getParams(pageable, filter);
	}

	private String getParams(Pageable pageable, SneakerFilter filter) {
		String page = ParamBuilder.getParams(pageable);
		StringBuilder buffer = new StringBuilder(page);
		if (!filter.getMax().isEmpty()) {
			buffer.append("&max=");
			buffer.append(filter.getMax());
		}
		if (!filter.getMin().isEmpty()) {
			buffer.append("&min=");
			buffer.append(filter.getMin());
		}
		if (!filter.getColorId().isEmpty()) {
			for (int id : filter.getColorId()) {
				buffer.append("&colorId=");
				buffer.append(id);
			}
		}

		if (!filter.getBrandId().isEmpty()) {
			for (int id : filter.getBrandId()) {
				buffer.append("&brandId=");
				buffer.append(id);
			}
		}
		return buffer.toString();
	}
}
