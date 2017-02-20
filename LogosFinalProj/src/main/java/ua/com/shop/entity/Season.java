package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Season {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToMany
	private List<Sneaker> listSneaker;
	public Season() {
		// TODO Auto-generated constructor stub
	}
	public Season(String name, List<Sneaker> listSneaker) {
		super();
		this.name = name;
		this.listSneaker = listSneaker;
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
	public List<Sneaker> getListSneaker() {
		return listSneaker;
	}
	public void setListSneaker(List<Sneaker> listSneaker) {
		this.listSneaker = listSneaker;
	}
	
	
}
