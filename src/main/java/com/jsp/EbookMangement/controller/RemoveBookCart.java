package com.jsp.EbookMangement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.EbookMangement.entity.Cart;
import com.jsp.EbookMangement.entity.User;
import com.jsp.EbookMangement.service.CartService;
@WebServlet("/remove_book")
public class RemoveBookCart extends HttpServlet {
    
	CartService service=new CartService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// User user = (User)req.getSession().getAttribute("userobj");


		try {
		int bid=Integer.parseInt(req.getParameter("bid"));
		//int uid=user.getId();
		
		 int uid=Integer.parseInt(req.getParameter("uid"));

		int cid=Integer.parseInt(req.getParameter("cid"));

		

		  System.out.println(bid);
		  System.out.println(uid);
	     System.out.println(cid);
		System.out.println("hey my name is sohit");
		service.deleteBook(bid,uid,cid);
		
		HttpSession session=req.getSession();
		
		
		if(bid!=0 && uid!=0 && cid!=0) {
			
			
			session.setAttribute("succMsg", "Book Removed from cart");
			resp.sendRedirect("checkout.jsp");
		}
		else {
			session.setAttribute("failedMsg", "Something wrong on Server");
			resp.sendRedirect("checkout.jsp");
		}
		
	}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	
	}
}
