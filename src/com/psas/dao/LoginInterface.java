package com.psas.dao;

import java.util.List;

import com.psas.vo.UserVo;

public interface LoginInterface {

	int getcheck(String name, String password)throws Exception;

	List<UserVo> getuserList() throws Exception ;

}
