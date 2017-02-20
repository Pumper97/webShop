package ua.com.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ua.com.shop.entity.Brand;
import ua.com.shop.entity.Color;
@Service
public interface ColorService {
	void save(Color color);

	List<Color> findAll();

	Color findOne(int id);

	void delete(int id);
}
