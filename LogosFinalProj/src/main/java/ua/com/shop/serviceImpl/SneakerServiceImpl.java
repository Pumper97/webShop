package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.SneakerDao;
import ua.com.shop.entity.Sneaker;
import ua.com.shop.service.SneakerService;
@Service
public class SneakerServiceImpl implements SneakerService {
	@Autowired
	private SneakerDao sneakerDao;

	public void save(Sneaker sneaker) {
		sneakerDao.save(sneaker);
	}

	public List<Sneaker> findAll() {

		return sneakerDao.findAll();
	}

	public Sneaker findOne(int id) {
	
		return sneakerDao.findOne(id);
	}

	public void delete(int id) {
		sneakerDao.delete(id);

	}

	
}
