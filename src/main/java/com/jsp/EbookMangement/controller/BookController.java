package com.jsp.EbookMangement.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.jsp.EbookMangement.entity.BookDtls;
import com.jsp.EbookMangement.service.BookService;

@WebServlet(value = "/add_books")
@MultipartConfig
public class BookController extends HttpServlet {

	BookService service = new BookService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String bookname = req.getParameter("bname");
			String author = req.getParameter("author");
			String price = req.getParameter("price");
			String categories = req.getParameter("categories");
			String status = req.getParameter("status");
			
			Part part = req.getPart("bimg");

			String fileName = part.getSubmittedFileName();

			BookDtls bookDtls = new BookDtls(bookname,author,price,categories,status,fileName,"admin");

			
			HttpSession session = req.getSession();
                service.BookAddService(bookDtls);
                
			if (bookDtls != null) {

				String path = getServletContext().getRealPath("") + "book";
    System.out.println(path);
				File file = new File(path);

				part.write(path + file.separator + fileName);
				session.setAttribute("succMsg", "Book Add Successfully...");
				resp.sendRedirect("admin/add_books.jsp");
			} else {
				session.setAttribute("failedMsg", "Something wrong on server");
				resp.sendRedirect("admin/add_books.jsp");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
