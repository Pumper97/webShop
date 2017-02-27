package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.Gender;
import ua.com.shop.service.GenderService;

public class GenderEditor extends PropertyEditorSupport {
private final GenderService genderService;

public GenderEditor(GenderService genderService) {
	super();
	this.genderService = genderService;
}

@Override
public void setAsText(String text) throws IllegalArgumentException {
	Gender gender = genderService.findOne(Integer.valueOf(text));
	setValue(gender);
}

}
