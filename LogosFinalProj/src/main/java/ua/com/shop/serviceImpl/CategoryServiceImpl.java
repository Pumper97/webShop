package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ua.com.shop.dao.CategoryDao;
import ua.com.shop.entity.Category;
import ua.com.shop.entity.Sneaker;
import ua.com.shop.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
@Autowired
private CategoryDao categoryDao;

public void save(Category category) {
	categoryDao.save(category);
	
}

public List<Category> findAll() {
	// TODO Auto-generated method stub
	return categoryDao.findAll();
}

public Category findOne(int id) {
	// TODO Auto-generated method stub
	return categoryDao.findOne(id);
}

public void delete(int id) {
	categoryDao.delete(id);
	
}

}
