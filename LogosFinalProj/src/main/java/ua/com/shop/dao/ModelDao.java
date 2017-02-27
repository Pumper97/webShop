package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.shop.entity.Brand;
import ua.com.shop.entity.Model;

public interface ModelDao extends JpaRepository<Model, Integer> {
	Model findByName(String name);

}
