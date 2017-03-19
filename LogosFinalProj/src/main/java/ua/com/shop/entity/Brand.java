package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToMany
	List<Model> modList;
	@OneToMany
	private List<Sneaker> sneakerList;
	@Transient
	private MultipartFile file;
	private int version;

	public List<Model> getModList() {
		return modList;
	}

	public void setModList(List<Model> modList) {
		this.modList = modList;
	}

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

	public Brand() {
		super();
	}

	public Brand(String name, List<Sneaker> sneakerList) {
		super();
		this.name = name;
		this.sneakerList = sneakerList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Sneaker> getSneakerList() {
		return sneakerList;
	}

	public void setSneakerList(List<Sneaker> sneakerList) {
		this.sneakerList = sneakerList;
	}

	

}
