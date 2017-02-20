package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.GenderDao;
import ua.com.shop.entity.Gender;
import ua.com.shop.service.GenderService;
@Service
public class GenderServiceImpl implements GenderService {
	@Autowired
	private GenderDao genderDao;

	public void save(Gender gender) {
		genderDao.save(gender);

	}

	public List<Gender> findAll() {

		return genderDao.findAll();
	}

	public Gender findOne(int id) {
		// TODO Auto-generated method stub
		return genderDao.findOne(id);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		genderDao.delete(id);
	}

}
