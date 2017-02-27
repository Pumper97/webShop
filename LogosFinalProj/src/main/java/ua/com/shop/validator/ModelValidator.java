package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.Model;
import ua.com.shop.service.ModelService;

public class ModelValidator implements Validator {
	private final ModelService modelService;

	public ModelValidator(ModelService modelService) {
		super();
		this.modelService = modelService;
	}

	public boolean supports(Class<?> arg0) {

		return Model.class.equals(arg0);
	}

	public void validate(Object arg0, Errors arg1) {
		Model model = (Model) arg0;
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "name", "",
				"Can't be empty");
		if (modelService.findByName(model.getName()) != null) {
			arg1.rejectValue("name", "", "Already exist");
		}
	}

}
