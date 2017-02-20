package ua.com.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ua.com.shop.entity.Brand;
import ua.com.shop.entity.Gender;
@Service
public interface GenderService {
	void save(Gender gender);

	List<Gender> findAll();

	Gender findOne(int id);

	void delete(int id);
}
