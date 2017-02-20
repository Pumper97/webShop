package ua.com.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ua.com.shop.entity.Brand;
import ua.com.shop.entity.Season;

@Service
public interface SeasonService {
	void save(Season season);

	List<Season> findAll();

	Season findOne(int id);

	void delete(int id);
}
