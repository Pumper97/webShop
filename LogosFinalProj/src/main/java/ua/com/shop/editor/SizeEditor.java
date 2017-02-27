package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.Size;
import ua.com.shop.service.SizeService;

public class SizeEditor extends PropertyEditorSupport {
private final SizeService sizeService;

public SizeEditor(SizeService sizeService) {
	super();
	this.sizeService = sizeService;
}

@Override
public void setAsText(String text) throws IllegalArgumentException {
	Size  size = sizeService.findOne(Integer.valueOf(text));
	setValue(size);
}

}
