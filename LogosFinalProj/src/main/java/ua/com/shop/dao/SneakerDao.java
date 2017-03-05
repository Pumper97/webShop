package ua.com.shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.com.shop.entity.Brand;
import ua.com.shop.entity.Sneaker;

public interface SneakerDao extends JpaRepository<Sneaker, Integer> {
	
}
