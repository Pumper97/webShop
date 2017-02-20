package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.UsersDao;
import ua.com.shop.entity.Users;
import ua.com.shop.service.UsersService;
@Service
public class UsersServiceImpl implements UsersService {
@Autowired
private UsersDao usersDao;

	public void save(Users users) {
		usersDao.save(users);
		
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public User findOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
