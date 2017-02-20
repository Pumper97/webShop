package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Size {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double size;
	@OneToMany
	private List<Sneaker> listSneaker;

	public Size() {
		// TODO Auto-generated constructor stub
	}

	public Size(double size, List<Sneaker> listSneaker) {
		super();
		this.size = size;
		this.listSneaker = listSneaker;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public List<Sneaker> getListSneaker() {
		return listSneaker;
	}

	public void setListSneaker(List<Sneaker> listSneaker) {
		this.listSneaker = listSneaker;
	}

	

}
