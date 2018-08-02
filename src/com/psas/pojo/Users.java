package com.psas.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Users implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7133395100284433443L;

	private int id;
	private String name;
	private String address;
	private String phone;
	private String lastname;
	private String password ;
	private String firstname;
	private String emailid;
	private String country;

	
	
	public Users(int id) {
		this.id = id;
	}
	
	

	public Users() {
		// TODO Auto-generated constructor stub
	}



	public Users(int id, String name, String address, String phone, String lastname, String password, String firstname,
			String emailid, String country) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.lastname = lastname;
		this.password = password;
		this.firstname = firstname;
		this.emailid = emailid;
		this.country = country;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "name", unique = true, length = 100)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "Address", length = 100)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name = "phone", length = 12)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Column(name = "lastname", length = 12)
	public String getLastname() {
		return lastname;
	}
 
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@Column(name = "password", length = 12)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "firstname", length = 12)
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	@Column(name = "emailid", length = 592)
	public String getEmailid() {
		return emailid;
	}


	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}


	@Column(name = "country", length = 592)
	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}


	
	
	
}
