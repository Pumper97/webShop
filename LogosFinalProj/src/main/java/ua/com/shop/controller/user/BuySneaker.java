package ua.com.shop.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.com.shop.dto.filter.BrandFilter;
import ua.com.shop.dto.filter.SneakerFilter;
import ua.com.shop.service.SneakerService;

@Controller
@RequestMapping("/user/sneakerInShop")
@SessionAttributes("sneaker")
public class BuySneaker {
	@Autowired
	private SneakerService service;
	
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") SneakerFilter filter) {
		model.addAttribute("page", service.findAll(pageable, filter));
		return "user-sneakerInShop";
	}
}
