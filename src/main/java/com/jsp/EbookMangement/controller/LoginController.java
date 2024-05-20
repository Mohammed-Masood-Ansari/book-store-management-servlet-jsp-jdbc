package com.jsp.EbookMangement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.EbookMangement.entity.User;
import com.jsp.EbookMangement.service.UserService;

@SuppressWarnings("serial")
@WebServlet(value = "/login")
public class LoginController extends HttpServlet {

	UserService service = new UserService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  
		HttpSession session = req.getSession();
	
		try {
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			
			if("admin@gmail.com".equals(email) && "admin".equals(password)) {
				User user=new User();
				user.setName("Admin");
				session.setAttribute("userobj", user);
				resp.sendRedirect("admin/home.jsp");
			}
			else{
				
				User user = service.userLoginDaoByEmailDService(email, password);
				System.out.println(user);
			if(user.getEmail() != null && user.getPassword() != null) {

	
					session.setAttribute("userobj", user);
					resp.sendRedirect("index.jsp");
				}
				else {
					session.setAttribute("faildMsg", "Please Enter Valid Email & Password");
					resp.sendRedirect("login.jsp");
				}
			 		
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
}