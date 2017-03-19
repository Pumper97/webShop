package ua.com.shop.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.com.shop.service.BrandService;
import ua.com.shop.service.CategoryService;
import ua.com.shop.service.SneakerService;

@Controller
public class IndexController {
	@Autowired
	private BrandService brandService;

//	@RequestMapping("/")
//	public String index(Model model) {
//		
//
//		return "user-index";
//}
//	@RequestMapping("/admin/brand")
//	public String adminBrand() {
//		return "admin-brand";
//	}

	@RequestMapping("/admin")
	public String admin() {
		return "admin-admin";
	}
	@RequestMapping("/user/contacts")
	public String contacts() {
		return "user-contacts";
	}
	
	
}
	
