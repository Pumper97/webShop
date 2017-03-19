package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.ColorDao;
import ua.com.shop.dto.filter.ColorFilter;
import ua.com.shop.entity.Color;
import ua.com.shop.service.ColorService;
@Service
public class ColorServiceImpl implements ColorService {
@Autowired
private ColorDao colorDao;
	public void save(Color color) {
		colorDao.save(color);
		
	}

	public List<Color> findAll() {
		// TODO Auto-generated method stub
		return colorDao.findAll() ;
	}

	public Color findOne(int id) {
		// TODO Auto-generated method stub
		return colorDao.findOne(id);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		colorDao.delete(id);
	}

	public Color findByName(String name) {
		// TODO Auto-generated method stub
		return colorDao.findByName(name);
	}

	@Override
	public Page<Color> findAll(ColorFilter filter, Pageable pageable) {
		// TODO Auto-generated method stub
		return colorDao.findAll(findByNameLike(filter), pageable);
	}

	private Specification<Color> findByNameLike(ColorFilter filter) {
		return (root, query, cb) -> {
			if (filter.getSearch().isEmpty())
				return null;
			return cb.like(cb.lower(root.get("name")), filter.getSearch()
					.toLowerCase() + "%");

		};
	
	}

}
