package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.Brand;
import ua.com.shop.entity.CountryMade;

public interface CountryService {
	void save(CountryMade country);

	List<CountryMade> findAll();

	CountryMade findOne(int id);

	void delete(int id);
}
