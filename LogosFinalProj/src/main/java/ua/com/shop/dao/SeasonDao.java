package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.shop.entity.Season;

public interface SeasonDao  extends JpaRepository<Season, Integer> {

}
