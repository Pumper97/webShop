package ua.com.shop.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.com.shop.service.BrandService;
import ua.com.shop.service.CategoryService;
import ua.com.shop.service.SneakerService;

@Controller
public class IndexController {
	@Autowired
	private BrandService brandService;

	@RequestMapping("/")
	public String index(Model model) {
model.addAttribute("brands", brandService.findAll());

		return "user-index";
	}

	@RequestMapping("/admin")
	public String admin() {
		return "admin-admin";
	}

	@RequestMapping("/user/registration")
	public String registration() {
		return "user-registration";
	}

	@RequestMapping("/user/newhome")
	public String newhome() {
		return "user-newhome";
	}

	// @RequestMapping("/user/next")
	// public String registratio1n() {
	// return "user-next";
	// }
}
