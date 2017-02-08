package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.shop.entity.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {

}
