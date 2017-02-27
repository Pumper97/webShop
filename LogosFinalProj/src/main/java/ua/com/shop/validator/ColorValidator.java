package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.Color;
import ua.com.shop.service.ColorService;

public class ColorValidator implements Validator {
	private final ColorService colorService;

	public ColorValidator(ColorService colorService) {
		super();
		this.colorService = colorService;
	}

	public boolean supports(Class<?> arg0) {

		return Color.class.equals(arg0);
	}

	public void validate(Object arg0, Errors arg1) {
		Color color = (Color) arg0;
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "name", "",
				"Can't be empty");
		if (colorService.findByName(color.getName())!=null){
	arg1.rejectValue("name", "", "Already exist");
}
	}

}
