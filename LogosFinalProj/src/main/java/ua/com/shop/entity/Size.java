package ua.com.shop.entity;

import java.math.BigDecimal;
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
	private BigDecimal size;
	@OneToMany
	private List<Sneaker> listSneaker;

	public Size() {
		// TODO Auto-generated constructor stub
	}

	public Size(BigDecimal size, List<Sneaker> listSneaker) {
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

	public BigDecimal getSize() {
		return size;
	}

	public void setSize(BigDecimal size) {
		this.size = size;
	}

	public List<Sneaker> getListSneaker() {
		return listSneaker;
	}

	public void setListSneaker(List<Sneaker> listSneaker) {
		this.listSneaker = listSneaker;
	}

	
	

}
