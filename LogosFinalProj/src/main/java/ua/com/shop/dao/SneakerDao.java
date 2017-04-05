package ua.com.shop.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.entity.Sneaker;

public interface SneakerDao extends JpaRepository<Sneaker, Integer>,
		JpaSpecificationExecutor<Sneaker> {
	@Query(value = "SELECT a FROM Sneaker a LEFT JOIN FETCH a.brand LEFT JOIN FETCH a.color LEFT JOIN FETCH a.size"
			+ " LEFT JOIN FETCH a.model LEFT JOIN FETCH a.season  LEFT JOIN FETCH a.gender", countQuery = "SELECT count(a.id) FROM Sneaker a")
	Page<Sneaker> findAll(Pageable pageable);

	@Query("SELECT sc.count FROM Users u JOIN u.shopingCart sc WHERE u.id=?1")
	Integer findCount(int id);

	@Query("SELECT i FROM Sneaker i JOIN i.shopingCarts sc JOIN sc.users u WHERE u.id=?1")
	List<Sneaker> findByUserId(int userId);
}
