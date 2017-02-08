package ua.com.shop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Model {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	public Model() {
		// TODO Auto-generated constructor stub
	}

	public Model(String name) {
		super();

		this.name = name;
	}

	@Override
	public String toString() {
		return "Model [id=" + id + ", name=" + name + "]";
	}

}
