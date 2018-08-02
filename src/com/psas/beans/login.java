package com.psas.beans;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.psas.dao.LoginInterface;
import com.psas.daoimpl.LoginImpl;
import com.psas.vo.UserVo;



@ManagedBean(name = "login", eager = true)
@RequestScoped

public class login {
	
	private String name;
	private String password;
	private LoginInterface loginInterface= new LoginImpl();
	private List<UserVo> usersList=new ArrayList<UserVo>();
	
	
	
	@PostConstruct
	public void init(){
		usersList = new  ArrayList<UserVo>();
		
		try {
			usersList = loginInterface.getuserList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

	
	public String submit(){
		int result=0;
		
		try {
			result=loginInterface.getcheck(name,password);
			
			if(result==1){
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN,
								"enter users",
								"Please check and try again"));
				return "login";
				
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return "home";
		
		
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}



	public List<UserVo> getUsersList() {
		return usersList;
	}


	public void setUsersList(List<UserVo> usersList) {
		this.usersList = usersList;
	}


}
