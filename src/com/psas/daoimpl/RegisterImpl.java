package com.psas.daoimpl;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.psas.common.HibernateUtil;
import com.psas.dao.RegisterInterface;
import com.psas.pojo.Users;



public class RegisterImpl implements RegisterInterface {

	@Override
	public int saveusers(String name, String lastname, String password, String emailid, String address, String phone,String firstname,String country) throws Exception {
		// TODO Auto-generated method stub
	
		
		Users usersTemp = null;
		Session session = null;
		Transaction tx = null;
		int result = 0;
		 
		
		try {
			
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
		
			usersTemp = (Users) session.createCriteria(Users.class)
					.add(Restrictions.eq("name",name.toLowerCase().trim()).ignoreCase())
					.uniqueResult();

			if (usersTemp != null) {

				result=2;	
			}else{
				
				usersTemp = new Users();
				
				usersTemp.setName(name);
				usersTemp.setFirstname(firstname);
				usersTemp.setLastname(lastname);
				usersTemp.setPassword(password);
				usersTemp.setAddress(address);
				usersTemp.setPhone(phone);
				usersTemp.setEmailid(emailid);
				usersTemp.setCountry(country);
				
				session.save(usersTemp);
				
			
			result=1;
			}
			
				tx.commit();
			
		} catch (Exception e) 
		{
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


	

}
