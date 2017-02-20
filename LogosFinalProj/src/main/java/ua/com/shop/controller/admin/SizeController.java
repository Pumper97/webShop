package ua.com.shop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.shop.entity.Color;
import ua.com.shop.entity.Size;
import ua.com.shop.service.ColorService;
import ua.com.shop.service.SizeService;

@Controller
@RequestMapping("/admin/size")
@SessionAttributes("size")
public class SizeController {
	@Autowired
	private SizeService sizeService ;

	@ModelAttribute("size")
	public Size getForm() {
		return new Size();
	}

	@GetMapping
	public String show(Model model) {
		model.addAttribute("sizes", sizeService.findAll());
		return "admin-size";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("size", sizeService.findOne(id));
		return show(model);
	}

	@GetMapping("delete/{id}")
	public String delete(@PathVariable int id) {
		sizeService.delete(id);
		return "redirect:/admin/size";
	}

	@PostMapping
	public String save(@ModelAttribute("size") Size size,
			SessionStatus status) {
		sizeService.save(size);
		status.setComplete();
		return "redirect:/admin/size";
	}
}
