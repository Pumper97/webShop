package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.com.shop.dto.filter.SneakerFilter;
import ua.com.shop.entity.Sneaker;

@Service
public interface SneakerService {
	void save(Sneaker sneaker);

	List<Sneaker> findAll();

	Sneaker findOne(int id);

	void delete(int id);

	Page<Sneaker> findAll(Pageable pageable, SneakerFilter filter);

	int findCount(int id);

	List<Sneaker> findByUserId(int userId);

}
