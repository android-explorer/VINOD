package com.psas.dao;

public interface RegisterInterface {

	int saveusers(String name, String lastname,  String password, String emailid, String address, String phone, String firstname,String country)throws Exception;

	 
}
