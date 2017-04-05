package ua.com.shop.controller.user;

import java.math.BigDecimal;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.com.shop.entity.Item;
import ua.com.shop.service.ItemService;
import ua.com.shop.service.UsersService;

@Controller
@SessionAttributes("proceedItems")
@RequestMapping("/user/cart")
public class CartController {

	@Autowired
	private ItemService itemService;
	@Autowired
	private UsersService service;

	@ModelAttribute("submit")
	public Item getSubForm() {
		return new Item();
	}

	@GetMapping
	public String cartShow(Model model, Principal principal,
			@ModelAttribute("purchaseInfo") Item item) {
    BigDecimal totalPrice = new BigDecimal(0);

		if (principal != null) {
			model.addAttribute(
					"purchInfo",
					itemService.findByUserNameAndPurchaseStatus(
							principal.getName(), 0));
			for (Item itemPrice : itemService.findByUserNameAndPurchaseStatus(
					principal.getName(), 0)) {
				System.out.println(itemPrice.getPrice());
				totalPrice = totalPrice.add(itemPrice.getPrice());
			}

			System.out.println(principal.getName());
			model.addAttribute("username", principal.getName());
			
			model.addAttribute("totalPrice", totalPrice);
			model.addAttribute("items", itemService.findByUserName(principal.getName()));
		}

		return "user-cart";
	}

	@GetMapping("/remove/{id}")
	public String remove(@PathVariable int id, Model model,
			Principal principal, @ModelAttribute("purchaseInfo") Item item) {
		itemService.delete(id);
		return "redirect:/user/cart";
	}

	@GetMapping("/submittion")
	public String submit(@ModelAttribute("submit") Item item,
			Principal principal) {
		String orderedItems = " ";
		if (principal != null) {
			for (Item itemStatus : itemService.findByUserName(principal
					.getName())) {
				itemStatus.setPurchaseStatus(1);
				itemService.save(itemStatus);

			}

		}
		return "redirect:/user/sneakerInShop";
	}

}