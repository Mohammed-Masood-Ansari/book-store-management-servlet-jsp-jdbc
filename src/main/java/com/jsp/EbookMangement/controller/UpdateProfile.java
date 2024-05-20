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

@WebServlet("/update_profile")
public class UpdateProfile extends HttpServlet {
	UserService servcie=new UserService();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String phno = req.getParameter("phno");
			String password = req.getParameter("password");
			
			User user=new User();
			
			user.setId(id);
			user.setName(name);
			user.setEmail(email);
			user.setPhno(phno);
			 HttpSession session=req.getSession();

			boolean f=servcie.checkPasswordDao(id, password);
			
			if(f) {
				
				boolean f1=servcie.updateProfile(user);
				
				if(f1) {
					
					session.setAttribute("succMsg", "User profile update Successfully...");
					resp.sendRedirect("edit_profile.jsp");
				}
				else {
					
					session.setAttribute("faildMsg", "Something wrong on server");
					resp.sendRedirect("edit_profile.jsp");
					
				}
				
			}
			else {
				
				session.setAttribute("faildMsg", "Your password incorrect...");
				resp.sendRedirect("edit_profile.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	
	
	
	
	
	
}
   