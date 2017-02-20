package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.shop.entity.Gender;

public interface GenderDao extends JpaRepository<Gender, Integer> {

}
