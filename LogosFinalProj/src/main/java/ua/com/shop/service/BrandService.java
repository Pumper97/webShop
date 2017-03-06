package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.com.shop.entity.Brand;
import ua.dto.filter.BrandFilter;
@Service
public interface BrandService {
	void save(Brand brand);

	List<Brand> findAll();

	Brand findOne(int id);

	void delete(int id);

	Brand findByName(String name);
	Page<Brand> findAll(BrandFilter brandFilter,Pageable pageable);
}
