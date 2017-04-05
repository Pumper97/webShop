package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.SneakerDao;
import ua.com.shop.dto.filter.SneakerFilter;
import ua.com.shop.entity.Sneaker;
import ua.com.shop.service.SneakerService;
import ua.com.shop.specification.SneakerSpecification;
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

	@Override
	public Page<Sneaker> findAll(Pageable pageable, SneakerFilter filter) {
		// TODO Auto-generated method stub
		return sneakerDao.findAll(new SneakerSpecification(filter), pageable);
	}

	@Override
	public int findCount(int id) {
		Integer count = sneakerDao.findCount(id);
		if(count==null)return 0;
		return count;
		
	}

	@Override
	public List<Sneaker> findByUserId(int userId) {
		
		return sneakerDao.findByUserId(userId);
	}

	
}
