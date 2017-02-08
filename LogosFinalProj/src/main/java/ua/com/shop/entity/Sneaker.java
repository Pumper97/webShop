package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Sneaker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	private Brand brand;
	@OneToMany
	private List<Size> sizes;
	@OneToMany
	private List<Model> models;
	@Enumerated(EnumType.STRING)
	private Season season;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@ManyToOne
	private Color color;
	private String opis;
	public Sneaker() {
		// TODO Auto-generated constructor stub
	}
	public Sneaker(Brand brand, List<Size> sizes, List<Model> models,
			Season season, Gender gender, Color color, String opis) {
		super();
		this.brand = brand;
		this.sizes = sizes;
		this.models = models;
		this.season = season;
		this.gender = gender;
		this.color = color;
		this.opis = opis;
	}
	
	
}
