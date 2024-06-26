package com.jsp.EbookMangement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.EbookMangement.dao.Userdao;
import com.jsp.EbookMangement.entity.User;

@WebServlet(value = "/userAddress")
public class UserUpdateAddressController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HttpSession httpSession = req.getSession();
		
		User user=(User)httpSession.getAttribute("userobj");
		
		Userdao userdao = new Userdao();
	
		String address = req.getParameter("address");
		String landmark = req.getParameter("landmark");
		String city = req.getParameter("city");
		String state = req.getParameter("state");
		String pincode = req.getParameter("pincode");
		
		System.out.println(user);
		
		User user2 = new User(req.getParameter("email"), address, landmark, city, state, pincode);
		
		userdao.updateUserDetailsDao(user2);
		
		req.getRequestDispatcher("user_address.jsp").forward(req, resp);
		
	}
}
