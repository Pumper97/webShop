package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.shop.entity.Size;

public interface SizeDao extends JpaRepository<Size, Integer> {

}
