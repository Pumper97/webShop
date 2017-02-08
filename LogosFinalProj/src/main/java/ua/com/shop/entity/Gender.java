package ua.com.shop.entity;

import javax.persistence.Entity;
import javax.persistence.Enumerated;


public enum Gender {
	@Enumerated
	MALE, FEMALE;
}
