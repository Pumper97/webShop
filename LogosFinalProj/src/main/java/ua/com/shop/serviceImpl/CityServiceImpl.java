package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.CityDao;
import ua.com.shop.entity.City;
import ua.com.shop.service.CityService;
@Service
public class CityServiceImpl implements CityService {
	@Autowired
	private CityDao cityDao;

	public void save(City city) {
		cityDao.save(city);
	}

	public List<City> findAll() {
		// TODO Auto-generated method stub
		return cityDao.findAll();
	}

	public City findOne(int id) {
		// TODO Auto-generated method stub
		return cityDao.findOne(id);
	}

	public void delete(int id) {
	cityDao.delete(id);

	}

}
