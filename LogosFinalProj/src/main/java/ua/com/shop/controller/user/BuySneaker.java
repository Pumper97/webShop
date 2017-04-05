package ua.com.shop.controller.user;

import java.security.Principal;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.shop.dto.filter.SneakerFilter;
import ua.com.shop.entity.Item;
import ua.com.shop.entity.Sneaker;
import ua.com.shop.service.BrandService;
import ua.com.shop.service.ColorService;
import ua.com.shop.service.GenderService;
import ua.com.shop.service.ItemService;
import ua.com.shop.service.ModelService;
import ua.com.shop.service.SeasonService;
import ua.com.shop.service.SizeService;
import ua.com.shop.service.SneakerService;
import ua.com.shop.service.UsersService;

@Controller
@SessionAttributes("sneaker")
@RequestMapping("/user/sneakerInShop")
public class BuySneaker {
	@Autowired
	private SneakerService service;
	@Autowired
	private UsersService uService;
	@Autowired
	private ItemService ites;
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
			@ModelAttribute("filter") SneakerFilter filter,
			@CookieValue(defaultValue = "0", name = "userId") int id,
			HttpServletResponse response) {
		model.addAttribute("genders", genderService.findAll());
		model.addAttribute("seasons", seasonService.findAll());
		model.addAttribute("colors", colorService.findAll());
		model.addAttribute("brands", brandService.findAll());
		model.addAttribute("sizes", sizeService.findAll());
		model.addAttribute("models", modelService.findAll());
		model.addAttribute("page", sneakerService.findAll(pageable, filter));
		return "user-sneakerInShop";
	}

	@GetMapping("/shopping")
	public String shopping(Model model,
			@CookieValue(defaultValue = "0", name = "userId") int userId) {
		model.addAttribute("sneakers", service.findByUserId(userId));
		return "user-shopping";
	}

	// @GetMapping("/buy/{commodityId}")
	// public String buy(Model model, @CookieValue(value = "userId") int userId,
	// @PathVariable int itemId) {
	//
	// uService.addToShoppingCart(userId, itemId);
	// return "redirect:/sneakerInShop";
	// }
	@GetMapping("/buy/{id}")
	public String buy(@PathVariable int id, Model model, Pageable pageable,
			@ModelAttribute("purchaseInfo") Item item, Principal principal,
			SessionStatus status) {

		if (principal != null) {
			System.out.println(principal.getName());
			item.setUserName(principal.getName());
			item.setSneakerBrand(service.findOne(id).getBrand().getName());
			item.setSneakerModel(service.findOne(id).getModel().getName());
			item.setPrice(service.findOne(id).getPrice());
			item.setTotalPrice(service.findOne(id).getPrice());
			ites.save(item);
			status.setComplete();
		}
		return "redirect:/user/cart";
	}
}
