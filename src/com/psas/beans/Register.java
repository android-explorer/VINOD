package com.psas.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.psas.dao.RegisterInterface;
import com.psas.daoimpl.RegisterImpl;



@ManagedBean(name = "register", eager = true)
@RequestScoped
public class Register implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2490931270874523601L;
	
	private String name;
	private String lastname; 
	private String password;
	private String address;
	private String phone;
	private String firstname;
	private String emailid;
	private String country;
	
	
	
	private RegisterInterface registerInterface = new RegisterImpl();
	
	public String submit(){
		
		int result = 0;
		try{
			
			result=	registerInterface.saveusers(name,lastname,password, emailid, address,phone,firstname,country);
			
			 
			if(result==2){
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN,
								"User Exits",
								"Please check and try again"));
				return "register.xhtml";
				
			}

			
		}catch(Exception e){
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Internal Error",
							"Please check the server logs"));
		}
		return "home";
	}
	
	
	
	


	public String getEmailid() {
		return emailid;
	}



	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}



	public String getName() {
		return name;
	}
	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}
	
	
	

}

