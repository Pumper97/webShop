package ua.com.shop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Model {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@ManyToOne
	private Sneaker sneaker;
	

	public Model() {
		// TODO Auto-generated constructor stub
	}

	public Model(String name, Sneaker sneaker) {
		super();
		this.name = name;
		this.sneaker = sneaker;
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

	public Sneaker getSneaker() {
		return sneaker;
	}

	public void setSneaker(Sneaker sneaker) {
		this.sneaker = sneaker;
	}

	

}
