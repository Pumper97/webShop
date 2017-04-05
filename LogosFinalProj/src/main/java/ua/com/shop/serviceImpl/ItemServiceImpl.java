package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.ItemDao;
import ua.com.shop.entity.Item;
import ua.com.shop.service.ItemService;
@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemDao dao;

	@Override
	public void save(Item item) {
		dao.save(item);
	}

	@Override
	public List<Item> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Item findOne(int id) {
		// TODO Auto-generated method stub
		return dao.findOne(id);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
dao.delete(id);
	}

	@Override
	public List<Item> findByUserName(String username) {
		// TODO Auto-generated method stub
		return dao.findByUserName(username);
	}

	@Override
	public List<Item> findByPurchaseStatus(int status) {
		// TODO Auto-generated method stub
		return dao.findByPurchaseStatus(status);
	}

	@Override
	public List<Item> findByUserNameAndPurchaseStatus(String username,
			int status) {
		// TODO Auto-generated method stub
		return dao.findByUserNameAndPurchaseStatus(username, status);
	}

}
