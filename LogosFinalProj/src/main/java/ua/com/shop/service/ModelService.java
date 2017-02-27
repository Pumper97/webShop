package ua.com.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ua.com.shop.entity.Brand;
import ua.com.shop.entity.Model;
@Service
public interface ModelService {
	void save(Model model);

	List<Model> findAll();

	Model findOne(int id);

	void delete(int id);

	Model findByName(String name);
}
