package ua.com.shop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Entity
public class ShopingCart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToMany(mappedBy = "shopingCart")
	private List<Users> users = new ArrayList<>();
	@ManyToMany
	private List<Sneaker> sneakers = new ArrayList<>();
	@Column(name = "_count")
	private int count;

	public void add(Sneaker e) {
		sneakers.add(e);
		count = sneakers.size();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	public List<Sneaker> getSneakers() {
		return sneakers;
	}

	public void setSneakers(List<Sneaker> sneakers) {
		this.sneakers = sneakers;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}
