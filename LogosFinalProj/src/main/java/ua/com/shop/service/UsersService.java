package ua.com.shop.service;

import java.util.List;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import ua.com.shop.entity.Brand;
import ua.com.shop.entity.Users;
@Service
public interface UsersService {
	void save(Users users);

	List<User> findAll();

	User findOne(int id);

	void delete(int id);
}
