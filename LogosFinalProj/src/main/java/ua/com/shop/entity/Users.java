package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String password;
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@ManyToMany
	@JoinTable(name = "user_in_city", joinColumns = @JoinColumn(name = "id_user"), 
	inverseJoinColumns = @JoinColumn(name = "id_city"))
	private List<City> cities;

	public Users() {
	};

}
