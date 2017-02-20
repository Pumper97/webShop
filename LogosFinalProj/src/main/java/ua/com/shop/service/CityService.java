package ua.com.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ua.com.shop.entity.City;
@Service
public interface CityService {
	void save(City city);

	List<City> findAll();

	City findOne(int id);

	void delete(int id);
}
