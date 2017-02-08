package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.shop.entity.Users;

public interface UsersDao extends JpaRepository<Users, Integer> {

}
