package ua.com.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ua.com.shop.entity.Item;
@Service
public interface ItemService {
	void save(Item item);

	List<Item> findAll();

	Item findOne(int id);

	void delete(int id);

	List<Item> findByUserName(String username);

	List<Item> findByPurchaseStatus(int status);

	List<Item> findByUserNameAndPurchaseStatus(String username, int status);
}
