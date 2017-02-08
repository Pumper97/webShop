package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.shop.entity.Brand;

public interface BrandDao extends JpaRepository<Brand, Integer> {

}
