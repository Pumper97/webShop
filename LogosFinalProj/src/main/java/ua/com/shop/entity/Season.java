package ua.com.shop.entity;

import javax.persistence.Entity;
import javax.persistence.Enumerated;


public enum Season {
	@Enumerated
	WINTER, SUUMER, AUTUMN, SPRING, DEMISEZON;
}
