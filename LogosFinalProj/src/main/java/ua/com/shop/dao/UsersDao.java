package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

import ua.com.shop.entity.Users;

public interface UsersDao extends JpaRepository<Users, Integer> {

	Users findByEmail(String string);

}
