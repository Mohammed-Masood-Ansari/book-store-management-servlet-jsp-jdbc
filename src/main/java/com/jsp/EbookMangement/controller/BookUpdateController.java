package com.jsp.EbookMangement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.EbookMangement.entity.BookDtls;
import com.jsp.EbookMangement.service.BookService;

@WebServlet(value = "/Edit_Books")
public class BookUpdateController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		BookService addService = new BookService();
		
		try {
			
			String id = req.getParameter("Id");
//			System.out.println(id);
			int bookId = Integer.parseInt(id);
//			System.out.println(bookId);
			String bookName = req.getParameter("bname");
			String author = req.getParameter("author");
//			Double price = Double.parseDouble(req.getParameter("price"));
			
//			String price1=req.getParameter("price");
//			System.out.println(price1);
//			
//			Double price=Double.parseDouble(price1);
//			System.out.println(price);
//			
			String price=req.getParameter("price");
			
			String status = req.getParameter("bstatus");
			
			BookDtls bookDetails = new BookDtls();
			bookDetails.setBookId(bookId);
			bookDetails.setBookname(bookName);
			bookDetails.setAuthor(author);
			bookDetails.setPrice(price);
			bookDetails.setStatus(status);
			
			HttpSession session = req.getSession();
			
			if(bookId >0) {
				addService.editBookDetailsByIdService(bookDetails);
				session.setAttribute("succMsg", "Book Update Successfully");
				resp.sendRedirect("admin/all_books.jsp");
			}
			else {
				session.setAttribute("FailedMsg", "Something wrong on server");
				resp.sendRedirect("admin/edit_books.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}