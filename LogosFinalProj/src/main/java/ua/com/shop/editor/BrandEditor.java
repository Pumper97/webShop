package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.Brand;
import ua.com.shop.service.BrandService;

public class BrandEditor extends PropertyEditorSupport {
private final BrandService brandService;

public BrandEditor(BrandService brandService) {
	super();
	this.brandService = brandService;
}

@Override
public void setAsText(String text) throws IllegalArgumentException {
	Brand brand = brandService.findOne(Integer.valueOf(text));
	setValue(brand);

}

}
