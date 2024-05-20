package com.jsp.EbookMangement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.EbookMangement.service.BookService;

@WebServlet("/delete_old_book")
public class DeleteOldBook extends HttpServlet {
	BookService service=new BookService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			
		 String em=req.getParameter("em");	
		  int id=Integer.parseInt(req.getParameter("id"));
			service.oldBookDeleteService(em, "Old",id);
			
			HttpSession session=req.getSession();
			
			
			if(em!=null && id!=0) {
				
				
				session.setAttribute("succMsg", " Old Book Delete Succesfully");
				resp.sendRedirect("old_book.jsp");
			}
			else {
				session.setAttribute("failedMsg", "Something wrong on Server");
				resp.sendRedirect("old_book.jsp");
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

	
	
}
