package ua.com.shop.controller.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;

import ua.com.shop.dto.form.Quantity;
import ua.com.shop.service.SneakerService;

@ControllerAdvice
public class ShoppingController {
	@Autowired
	private SneakerService service;
	@ModelAttribute("quantity")
	public Quantity getQuantity(@CookieValue(defaultValue="0", name="userId") int userId){
		int count = service.findCount(userId);
		return new Quantity(count);
		
	}
}
