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
	// діє на одне поле
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Enumerated(EnumType.STRING)
	private Season season;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@OneToMany
	private List<DodCategory> dodCategories;

	public Category() {
	}

	public Category(String name, Season season, Gender gender,
			List<DodCategory> dodCategories) {
		super();
		this.name = name;
		this.season = season;
		this.gender = gender;
		this.dodCategories = dodCategories;
	};

}
