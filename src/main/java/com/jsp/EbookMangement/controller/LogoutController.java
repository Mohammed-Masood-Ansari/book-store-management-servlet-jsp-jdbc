package com.jsp.EbookMangement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {

	
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 try
		{
	HttpSession httpSession=req.getSession();
    httpSession.removeAttribute("userobj");
			
	HttpSession httpSession2=req.getSession()	;
	
	 httpSession.setAttribute("succMsg", "Logout succesfully ");
		
	resp.sendRedirect("login.jsp");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
	}

}
