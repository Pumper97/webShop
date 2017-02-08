package ua.com.shop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DodCategory {
	@Id
	// діє на одне поле
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@ManyToOne
	private Category category;

	public DodCategory() {

	}

	public DodCategory(String name, Category category) {
		super();
		this.name = name;
		this.category = category;
	}
	
}
