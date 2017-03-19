package ua.com.shop.controller.user;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.com.shop.entity.Users;
import ua.com.shop.service.UsersService;

@Controller
public class RegistrationController {
	@Autowired
	private UsersService usersService;

	@RequestMapping("/")
	public String index(Principal principal, Model model, String string) {
		if (principal != null) {
			System.out.println(principal.getName());
			model.addAttribute("userLogIn", principal.getName());
		}
//		model.addAttribute("page", usersService.findByEmail(string));
		return "user-index";
	}

	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("user", new Users());
		return "user-registration";
	}

	@PostMapping("/registration")
	public String save(@ModelAttribute("user") Users user) {
		usersService.save(user);
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String login() {
		return "user-login";
	}
}
