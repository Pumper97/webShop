package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Gender {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToMany
	private List<Sneaker> sneaekrList;

	public Gender() {
		// TODO Auto-generated constructor stub
	}

	

	public Gender(String name, List<Sneaker> sneaekrList) {
		super();
		this.name = name;
		this.sneaekrList = sneaekrList;
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



	public List<Sneaker> getSneaekrList() {
		return sneaekrList;
	}



	public void setSneaekrList(List<Sneaker> sneaekrList) {
		this.sneaekrList = sneaekrList;
	}



	
}
