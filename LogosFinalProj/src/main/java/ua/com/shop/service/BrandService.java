package ua.com.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ua.com.shop.entity.Brand;
@Service
public interface BrandService {
	void save(Brand brand);

	List<Brand> findAll();

	Brand findOne(int id);

	void delete(int id);

	Brand findByName(String name);
}
