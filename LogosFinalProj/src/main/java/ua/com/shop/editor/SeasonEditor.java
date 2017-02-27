package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.Season;
import ua.com.shop.service.SeasonService;

public class SeasonEditor extends PropertyEditorSupport {
private final SeasonService seasonService;

public SeasonEditor(SeasonService seasonService) {
	super();
	this.seasonService = seasonService;
}

@Override
public void setAsText(String text) throws IllegalArgumentException {
  Season season = seasonService.findOne(Integer.valueOf(text));
  setValue(season);
}

}
