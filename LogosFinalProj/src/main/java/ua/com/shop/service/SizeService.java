package ua.com.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ua.com.shop.dto.form.SizeFOrm;
import ua.com.shop.entity.DodCategory;
import ua.com.shop.entity.Size;
@Service
public interface SizeService {
	void save(SizeFOrm size) ;

	List<Size> findAll();

	Size findOne(int id);

	void delete(int id);

	Size findUniqe(String size);
	SizeFOrm findForm(int id);
}
