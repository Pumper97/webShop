package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.shop.entity.Commodity;

public interface CommodityDao extends JpaRepository<Commodity, Integer>{

}
