package ua.com.shop.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String userName;

	private String sneakerBrand;
	private String sneakerModel;
	private BigDecimal price;

	private BigDecimal quantity;

	private BigDecimal totalPrice;

	private int purchaseStatus;

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSneakerBrand() {
		return sneakerBrand;
	}

	public void setSneakerBrand(String sneakerBrand) {
		this.sneakerBrand = sneakerBrand;
	}

	public String getSneakerModel() {
		return sneakerModel;
	}

	public void setSneakerModel(String sneakerModel) {
		this.sneakerModel = sneakerModel;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getPurchaseStatus() {
		return purchaseStatus;
	}

	public void setPurchaseStatus(int purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
	}

}
