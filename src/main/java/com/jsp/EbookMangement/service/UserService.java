package com.jsp.EbookMangement.service;

import com.jsp.EbookMangement.dao.Userdao;
import com.jsp.EbookMangement.entity.User;

public class UserService {

	Userdao userdao = new Userdao();

	public User saveUserService(User user) {

		return userdao.registerUserDao(user);

	}

	public User userLoginDaoByEmailDService(String email, String password) {

		return userdao.userLoginDaoByEmailDao(email, password);
	}

	public boolean checkPasswordDao(int id, String ps) {

		return userdao.checkPasswordDao(id, ps);

	}
	
	   public boolean updateProfile(User user) {
		   
		   return userdao.updateProfile(user);
	   }		
	   public boolean checkUser(String em) {
		   return userdao.checkUser(em);
	   }
}
