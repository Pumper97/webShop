package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.SeasonDao;
import ua.com.shop.entity.Season;
import ua.com.shop.service.SeasonService;
@Service
public class SeasonServiceImpl implements SeasonService {
@Autowired
private SeasonDao seasonDao;
	public void save(Season season) {
		seasonDao.save(season);
		
	}

	public List<Season> findAll() {
		// TODO Auto-generated method stub
		return seasonDao.findAll();
	}

	public Season findOne(int id) {
		// TODO Auto-generated method stub
		return seasonDao.findOne(id);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		seasonDao.delete(id);
	}

}
