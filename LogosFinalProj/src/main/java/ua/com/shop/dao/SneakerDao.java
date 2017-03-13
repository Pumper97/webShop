package ua.com.shop.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.entity.Sneaker;

public interface SneakerDao extends JpaRepository<Sneaker, Integer>, JpaSpecificationExecutor<Sneaker> {
	@Query(value="SELECT a FROM Sneaker a LEFT JOIN FETCH a.brand LEFT JOIN FETCH a.color LEFT JOIN FETCH a.size"
			+ " LEFT JOIN FETCH a.model LEFT JOIN FETCH a.season  LEFT JOIN FETCH a.gender",
			countQuery="SELECT count(a.id) FROM Sneaker a")

	Page<Sneaker> findAll(Pageable pageable);

}
