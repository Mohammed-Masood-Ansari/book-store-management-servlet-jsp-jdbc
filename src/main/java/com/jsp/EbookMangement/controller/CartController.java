package com.jsp.EbookMangement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.EbookMangement.dao.BookDao;
import com.jsp.EbookMangement.entity.BookDtls;
import com.jsp.EbookMangement.entity.Cart;
import com.jsp.EbookMangement.entity.User;
import com.jsp.EbookMangement.service.CartService;

@WebServlet("/cart")
public class CartController extends HttpServlet {

	CartService cartService = new CartService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		User user = (User)req.getSession().getAttribute("userobj");
		try {
			String bid = req.getParameter("bid");
		int uid = user.getId();
			System.out.println(uid);

			int bid1 = Integer.parseInt(bid);
			System.out.println(bid1);
//			int ud1 = Integer.parseInt(uid);

		BookDao bookDao = new BookDao();
		BookDtls bookDtls1 = bookDao.getBookDetailsById(bid1);

			  
			Cart cart = new Cart();

			cart.setBid(bid1);
			cart.setUserId(uid);
			cart.setBookName(bookDtls1.getBookname());
			cart.setAuthor(bookDtls1.getAuthor());
			cart.setPrice(Double.parseDouble(bookDtls1.getPrice()));
			cart.setTotalprice(Double.parseDouble(bookDtls1.getPrice()));
 
		boolean f=cartService.saveCartUserService(cart);
			
           HttpSession session=req.getSession();
           
			if(f) {
         
				session.setAttribute("addCart", "Book Add to cart");
				resp.sendRedirect("all_new_book.jsp");
			}
			else {
				session.setAttribute("failed", "Something wrong a server");
				resp.sendRedirect("all_new_book.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	
	
	}
}
