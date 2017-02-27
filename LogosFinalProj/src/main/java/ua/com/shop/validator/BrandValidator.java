package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.Brand;
import ua.com.shop.service.BrandService;

public class BrandValidator implements Validator {
	private final BrandService brandService;

	public BrandValidator(BrandService brandService) {
		super();
		this.brandService = brandService;
	}

	public boolean supports(Class<?> arg0) {

		return Brand.class.equals(arg0);
	}

	public void validate(Object arg0, Errors arg1) {
		Brand brand = (Brand) arg0;
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "name", "",
				"Can't be empty");
		if (brandService.findByName(brand.getName()) != null) {
			arg1.rejectValue("name", "", "Already exist");
		}
	}

}
