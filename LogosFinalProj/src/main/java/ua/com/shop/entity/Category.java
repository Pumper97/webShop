package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@OneToMany
	private List<DodCategory> dodCategories;

	public Category() {
	}

	public Category(String name, List<DodCategory> dodCategories) {
		super();
		this.name = name;
		this.dodCategories = dodCategories;
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

	public List<DodCategory> getDodCategories() {
		return dodCategories;
	}

	public void setDodCategories(List<DodCategory> dodCategories) {
		this.dodCategories = dodCategories;
	}

	

}
