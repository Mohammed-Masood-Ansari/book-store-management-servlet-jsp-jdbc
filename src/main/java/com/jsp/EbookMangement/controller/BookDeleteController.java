package com.jsp.EbookMangement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.EbookMangement.service.BookService;

@WebServlet(value = "/delete")
public class BookDeleteController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookService addService = new BookService();
		int id = Integer.parseInt(req.getParameter("id"));
		
		if(id != 0) {
			addService.deleteBookById(id);
			resp.sendRedirect("admin/all_books.jsp");
		}
			
	}
}