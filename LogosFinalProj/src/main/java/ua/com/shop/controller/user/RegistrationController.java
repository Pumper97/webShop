package ua.com.shop.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationController {
	@RequestMapping("/user/next")
	public String registratio1n() {
		return "user-next";
	}

}
