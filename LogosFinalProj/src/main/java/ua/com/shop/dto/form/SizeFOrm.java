package ua.com.shop.dto.form;

import java.util.List;

import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import ua.com.shop.entity.Sneaker;

public class SizeFOrm {
	private int id;
	private String size;
	private List<Sneaker> listSneaker;
	@Transient
	private MultipartFile file;
	private int version;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public List<Sneaker> getListSneaker() {
		return listSneaker;
	}

	public void setListSneaker(List<Sneaker> listSneaker) {
		this.listSneaker = listSneaker;
	}

}
