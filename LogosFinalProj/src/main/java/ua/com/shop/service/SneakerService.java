package ua.com.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ua.com.shop.entity.Sneaker;
@Service
public interface SneakerService {
	void save(Sneaker sneaker);

	List<Sneaker> findAll();

	Sneaker findOne(int id);

	void delete(int id);
}
