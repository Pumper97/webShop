package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.Brand;
import ua.com.shop.entity.Category;

public interface BrandService {
	void save(Brand brand);

	List<Brand> findAll();

	Brand findOne(int id);

	void delete(int id);
}
