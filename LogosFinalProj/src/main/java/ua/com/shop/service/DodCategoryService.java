package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.Brand;
import ua.com.shop.entity.DodCategory;

public interface DodCategoryService {
	void save(DodCategory dodCategory);

	List<DodCategory> findAll();

	DodCategory findOne(int id);

	void delete(int id);
}
