package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.shop.entity.CountryMade;

public interface CountryDao extends JpaRepository<CountryMade, Integer> {

}
