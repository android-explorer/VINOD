package com.psas.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.psas.common.HibernateUtil;
import com.psas.dao.LoginInterface;
import com.psas.pojo.Users;
import com.psas.vo.UserVo;



public class LoginImpl implements LoginInterface {

	@Override
	public int getcheck(String name, String password) throws Exception {
		// TODO Auto-generated method stub
		
		Users userTemp = null;
		Session session = null;
		Transaction tx = null;
		int result = 0;
		
		try{
			
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			
			
			userTemp =  (Users) session.createCriteria(Users.class)
					.add(Restrictions.eq("name",name.toLowerCase().trim()).ignoreCase())
					.add(Restrictions.eq("password",password.toLowerCase().trim()).ignoreCase())
					
					.uniqueResult();

			if (userTemp != null) {

//				result=2;	
			}else{
				
				result=1;
			}
			
			
			
			
			
			
		}catch(Exception e){
			if(tx != null)
			{
				tx.rollback();
			}

			e.printStackTrace();
			throw new Exception(e);
		} finally {
			if (session != null)
				session.close();
		}
		
		
		
		
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<UserVo> getuserList() throws Exception {
		// TODO Auto-generated method stub
		List<UserVo> usersList = new ArrayList<UserVo>();
		Users userTemp = null;
		Session session = null;
		Transaction tx = null;
		UserVo usersVo=null;
		try
		{
           	session = HibernateUtil.getSession();
            tx = session.beginTransaction();
		
            
			List<Users> getuserList = (List<Users>) session
					.createCriteria(Users.class)					
					.list();
           
			for(Users usersDB :getuserList){
			
			
			usersVo= new UserVo();
			
			usersVo.setId(usersDB.getId());			
			usersVo.setAddress(usersDB.getAddress());
			usersVo.setCountry(usersDB.getCountry());
			usersVo.setEmailid(usersDB.getEmailid());
			usersVo.setFirstname(usersDB.getFirstname());
			usersVo.setLastname(usersDB.getLastname());
			usersVo.setName(usersDB.getName());
			
			
			usersList.add(usersVo);
			
			
			
			}
			tx.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
        	if(session != null)
            session.close();
	    }

		return usersList;
	}

}
