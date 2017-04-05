package ua.com.shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.entity.Item;

public interface ItemDao extends JpaRepository<Item, Integer> {
	List<Item> findByUserName(String username);

	List<Item> findByPurchaseStatus(int status);

	@Query("SELECT i FROM Item i WHERE i.userName=?1 AND i.purchaseStatus=?2")
	List<Item> findByUserNameAndPurchaseStatus(String username, int status);
}
