package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.SizeDao;
import ua.com.shop.entity.Size;
import ua.com.shop.service.SizeService;
@Service
public class SizeServiceImpl implements SizeService {
@Autowired
private SizeDao sizeDao;
	public void save(Size size) {
		sizeDao.save(size);
		
	}

	public List<Size> findAll() {
		// TODO Auto-generated method stub
		return sizeDao.findAll();
	}

	public Size findOne(int id) {
		// TODO Auto-generated method stub
		return sizeDao.findOne(id);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		sizeDao.delete(id);
	}

}
