package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class DodCategory {
	@Id
	// діє на одне поле
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@ManyToOne
	private Category category;
	@OneToMany
	private List<Sneaker> sneakerList;

	public DodCategory() {

	}

	public DodCategory(String name, Category category, List<Sneaker> sneakerList) {
		super();
		this.name = name;
		this.category = category;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Sneaker> getSneakerList() {
		return sneakerList;
	}

	public void setSneakerList(List<Sneaker> sneakerList) {
		this.sneakerList = sneakerList;
	}

	
	
}
