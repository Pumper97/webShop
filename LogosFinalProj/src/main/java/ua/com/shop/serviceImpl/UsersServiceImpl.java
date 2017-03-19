package ua.com.shop.serviceImpl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.UsersDao;
import ua.com.shop.entity.Role;
import ua.com.shop.entity.Users;
import ua.com.shop.service.UsersService;

@Service("userDetailsService")
public class UsersServiceImpl implements UsersService, UserDetailsService {
	@Autowired
	private UsersDao usersDao;
	@Autowired
	private BCryptPasswordEncoder encoder;

	public void save(Users users) {
		users.setPassword(encoder.encode(users.getPassword()));
		users.setRole(Role.ROLE_USER);
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

	@PostConstruct
	public void addAdmin() {
		Users user = usersDao.findByEmail("admin");
		if (user == null) {
			user = new Users();
			user.setPassword(encoder.encode("admin"));
			user.setEmail("admin");
			user.setRole(Role.ROLE_ADMIN);
			usersDao.save(user);
		}
	}

	@Override
	public UserDetails loadUserByUsername(String arg0)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return usersDao.findByEmail(arg0);
	}

	@Override
	public Users findByEmail(String string) {
		// TODO Auto-generated method stub
		return usersDao.findByEmail(string);
	}
}
