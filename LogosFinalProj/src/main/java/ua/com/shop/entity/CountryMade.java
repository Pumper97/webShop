package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CountryMade {
	@Id
	// діє на одне поле
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToMany
	private List<Sneaker> sneakerList;

	public CountryMade() {

	}

	public CountryMade(String name, List<Sneaker> sneakerList) {
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
