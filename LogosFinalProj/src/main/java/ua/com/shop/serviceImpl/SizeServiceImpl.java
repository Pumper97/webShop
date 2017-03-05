package ua.com.shop.serviceImpl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.SizeDao;
import ua.com.shop.dto.form.SizeFOrm;
import ua.com.shop.entity.Size;
import ua.com.shop.service.SizeService;

@Service
public class SizeServiceImpl implements SizeService {
	@Autowired
	private SizeDao sizeDao;

	public void save(Size size) {
		sizeDao.save(size);

	}

	public List<Size> findAll() {
		// TODO Auto-generated method stub
		return sizeDao.findAll();
	}

	public Size findOne(int id) {
		// TODO Auto-generated method stub
		return sizeDao.findOne(id);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		sizeDao.delete(id);
	}

	public Size findUniqe(String size) {
		// TODO Auto-generated method stub
		return sizeDao.findUnique(new BigDecimal(size.replace(',', '.')));
	}

	public void save(SizeFOrm size) {
		Size ent = new Size();
		ent.setSize(new BigDecimal(size.getSize().replace(',', '.')));
		ent.setId(size.getId());
		ent.setListSneaker(size.getListSneaker());
		sizeDao.save(ent);
	}

	public SizeFOrm findForm(int id) {
		Size ent = findOne(id);
		SizeFOrm fOrm = new SizeFOrm();
		fOrm.setSize(String.valueOf(ent.getSize()));
		fOrm.setId(ent.getId());
		fOrm.setListSneaker(ent.getListSneaker());
		return fOrm;
	}
}
