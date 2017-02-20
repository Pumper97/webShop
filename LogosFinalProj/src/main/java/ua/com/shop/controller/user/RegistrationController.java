package ua.com.shop.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.shop.entity.Users;
import ua.com.shop.service.UsersService;

@Controller
@RequestMapping("/user/account")
public class RegistrationController {
	@Autowired
	private UsersService usersService;
	@RequestMapping
	public String show(Model model) {
		model.addAttribute("brands", usersService.findAll());

		return "user-account";
	}
@PostMapping
	public String registration(@RequestParam String fName,
			@RequestParam String lName, @RequestParam String email,
			@RequestParam String password) {
		Users users = new Users(fName, lName, email, password);
		usersService.save(users);

		return "redirect:/admin/brand";
	}

}
