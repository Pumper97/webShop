package ua.com.shop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.shop.entity.Brand;
import ua.com.shop.entity.Color;
import ua.com.shop.service.BrandService;

@Controller
@RequestMapping("/admin/brand")

@SessionAttributes("brand")
public class BrandController {
	@Autowired
	private BrandService brandService;

	@ModelAttribute("brand")
	public Brand getForm() {
		return new Brand();
	}

	@GetMapping
	public String show(Model model) {
		model.addAttribute("brands", brandService.findAll());
		return "admin-brand";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("brand", brandService.findOne(id));
		return show(model);
	}
	@GetMapping("delete/{id}")
	public String delete(@PathVariable int id){
		brandService.delete(id);
		return "redirect:/admin/brand";
	}
	
	@PostMapping
	public String save(@ModelAttribute("brand") Brand brand, SessionStatus status){
		brandService.save(brand);
		status.setComplete();
		return "redirect:/admin/brand";
	}
}