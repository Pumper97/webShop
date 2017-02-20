package ua.com.shop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.shop.entity.Model;
import ua.com.shop.entity.Size;
import ua.com.shop.service.BrandService;
import ua.com.shop.service.ModelService;

@Controller
@RequestMapping("/admin/model")
@SessionAttributes("model")
public class ModelController {
	@Autowired
	private ModelService modelService;
	@Autowired
	private BrandService brandService;
	@ModelAttribute("model")
	public Model getForm() {
		return new ua.com.shop.entity.Model();
	}

	@GetMapping
	public String show(org.springframework.ui.Model model) {
		model.addAttribute("models", modelService.findAll());
		model.addAttribute("brands" , brandService.findAll());
		return "admin-model";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, org.springframework.ui.Model model) {
		model.addAttribute("model", modelService.findOne(id));
		return show(model);
	}

	@GetMapping("delete/{id}")
	public String delete(@PathVariable int id) {
		modelService.delete(id);
		return "redirect:/admin/model";
	}

	@PostMapping
	public String save(@ModelAttribute("model") Model model,
			SessionStatus status) {
		modelService.save(model);
		status.setComplete();
		return "redirect:/admin/model";
	}
}
