package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.ModelDao;
import ua.com.shop.entity.Model;
import ua.com.shop.service.ModelService;

@Service
public class ModelServiceImpl implements ModelService {
@Autowired
private ModelDao modelDao;

public void save(Model model) {
	// TODO Auto-generated method stub
	modelDao.save(model);
}

public List<Model> findAll() {
	// TODO Auto-generated method stub
	return modelDao.findAll();
}

public Model findOne(int id) {
	// TODO Auto-generated method stub
	return modelDao.findOne(1);
}

public void delete(int id) {
	// TODO Auto-generated method stub
	modelDao.delete(id);
}

}
