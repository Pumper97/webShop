package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.Model;
import ua.com.shop.service.ModelService;

public class ModelEditor extends PropertyEditorSupport {
private final ModelService modelService;

public ModelEditor(ModelService modelService) {
	super();
	this.modelService = modelService;
}

@Override
public void setAsText(String text) throws IllegalArgumentException {
	Model model = modelService.findOne(Integer.valueOf(text));
	setValue(model);
}

}
