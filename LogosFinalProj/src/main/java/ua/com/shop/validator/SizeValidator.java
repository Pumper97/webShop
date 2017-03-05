package ua.com.shop.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ua.com.shop.dto.form.SizeFOrm;
import ua.com.shop.service.SizeService;

public class SizeValidator implements Validator {
	private final static Pattern REG = Pattern
			.compile("^([0-9]{1,17}\\.[0-9]{1,2})|([0-9]{1,17}\\,[0-9]{1,2})|([0-9]{1,17})$");
	private final SizeService sizeService;

	public SizeValidator(SizeService sizeService) {
		super();
		this.sizeService = sizeService;
	}

	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return SizeFOrm.class.equals(arg0);
	}

	public void validate(Object arg0, Errors arg1) {
		SizeFOrm form = (SizeFOrm) arg0;
		if (!REG.matcher(form.getSize()).matches()) {
			arg1.rejectValue("size", "",
					"Enter number with . or , or only numbers");
		}
		if (arg1.getFieldError("size") == null) {
			if (sizeService.findUniqe(form.getSize()) != null) {
				arg1.rejectValue("size", "", "Already exist");
			}
		}
	}

}
