package ua.com.shop.serviceImpl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ua.com.shop.dao.BrandDao;
import ua.com.shop.dto.filter.BrandFilter;
import ua.com.shop.entity.Brand;
import ua.com.shop.service.BrandService;
import ua.com.shop.service.FileWriter;
import ua.com.shop.service.FileWriter.Folder;

@Service
public class BrandServiceImpl implements BrandService {
	@Autowired
	private BrandDao brandDao;
	@Autowired
	private FileWriter fileWriter;

	public void save(Brand brand) {
		MultipartFile file = brand.getFile();
		brand = brandDao.saveAndFlush(brand);
		if(fileWriter.write(Folder.BRAND, file, brand.getId())){
			brand.setVersion(brand.getVersion()+1);
			brandDao.save(brand);
			}
		
		brandDao.save(brand);

	}

	public List<Brand> findAll() {
		// TODO Auto-generated method stub
		return brandDao.findAll();
	}

	public Brand findOne(int id) {
		// TODO Auto-generated method stub
		return brandDao.findOne(id);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		brandDao.delete(id);
	}

	public Brand findByName(String name) {
		// TODO Auto-generated method stub
		return brandDao.findByName(name);
	}

	@Override
	public Page<Brand> findAll(BrandFilter brandFilter, Pageable pageable) {

		return brandDao.findAll(findByNameLike(brandFilter), pageable);
	}

	private Specification<Brand> findByNameLike(BrandFilter brandFilter) {
		return (root, query, cb) -> {
			if (brandFilter.getSearch().isEmpty())
				return null;
			return cb.like(cb.lower(root.get("name")), brandFilter.getSearch()
					.toLowerCase() + "%");

		};
	}
}
