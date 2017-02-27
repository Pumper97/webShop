package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.ColorDao;
import ua.com.shop.entity.Color;
import ua.com.shop.service.ColorService;
@Service
public class ColorServiceImpl implements ColorService {
@Autowired
private ColorDao colorDao;
	public void save(Color color) {
		colorDao.save(color);
		
	}

	public List<Color> findAll() {
		// TODO Auto-generated method stub
		return colorDao.findAll() ;
	}

	public Color findOne(int id) {
		// TODO Auto-generated method stub
		return colorDao.findOne(id);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		colorDao.delete(id);
	}

	public Color findByName(String name) {
		// TODO Auto-generated method stub
		return colorDao.findByName(name);
	}

}
