package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.BrandDao;
import ua.com.shop.entity.Brand;
import ua.com.shop.service.BrandService;
@Service
public class BrandServiceImpl implements BrandService {
@Autowired
private BrandDao brandDao;


	public void save(Brand brand) {
		brandDao.save(brand);
		
	}

	public List<Brand> findAll() {
		// TODO Auto-generated method stub
		return brandDao.findAll();
	}

	public Brand findOne(int id) {
		// TODO Auto-generated method stub
		return brandDao.findOne(id);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		brandDao.delete(id);
	}

}
