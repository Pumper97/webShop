package ua.com.shop.dao;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.dto.form.SizeFOrm;
import ua.com.shop.entity.Size;

public interface SizeDao extends JpaRepository<Size, Integer> {
	@Query("SELECT s FROM Size s WHERE s.size=?1")
	Size findUnique(BigDecimal size);
}
