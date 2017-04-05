package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import ua.com.shop.entity.Users;
import ua.com.shop.service.UsersService;

public class UserValidator implements Validator {
	private final UsersService service;

	public UserValidator(UsersService service) {
		super();
		this.service = service;
	}
	public boolean supports(Class<?> arg0) {

		return Users.class.equals(arg0);
	}
	public void validate(Object arg0, Errors arg1) {
		Users user =  (Users) arg0;
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "email", "",
				"Can't be empty");
		if (service.findByEmail(user.getEmail())!= null){
			arg1.rejectValue("email", "", "Already exist");
		}
	}
}
