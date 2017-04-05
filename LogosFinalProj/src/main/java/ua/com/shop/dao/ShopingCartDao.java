package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.shop.entity.ShopingCart;

public interface ShopingCartDao extends JpaRepository<ShopingCart, Integer> {

}
