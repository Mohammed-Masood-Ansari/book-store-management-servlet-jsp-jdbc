package com.jsp.EbookMangement.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.EbookMangement.dao.CartDao;
import com.jsp.EbookMangement.entity.Book_Order;
import com.jsp.EbookMangement.entity.Cart;
import com.jsp.EbookMangement.service.BookOrderService;

@WebServlet("/order")
public class OrderController extends HttpServlet {


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			
			HttpSession session=req.getSession();
			
			int id = Integer.parseInt(req.getParameter("id"));

			String name = req.getParameter("username");
			String email = req.getParameter("email");
			String phno = req.getParameter("phno");
			String address = req.getParameter("address");
			String landmark = req.getParameter("landmark");
			String city = req.getParameter("city");
			String state = req.getParameter("state");
			String pincode = req.getParameter("pincode");
			String paymentType = req.getParameter("payment");
			

			String fullAdd = address + "," + landmark + "," + city + "," + state + "," + pincode;

			// System.out.println(name+", "+email+","+phno+" ,"+fullAdd+" ,"+paymentType);
			CartDao dao = new CartDao();

	
			  List<Cart> blist = dao.getBookByUser(id);
			  
			  if(blist.isEmpty()) {
				  session.setAttribute("failedMsg", " Please Add Item");

				   resp.sendRedirect("checkout.jsp");
				   
			  }else {
			  BookOrderService service = new BookOrderService();
			  
			  Book_Order o = null;
			  
			  ArrayList<Book_Order> orderlist = new ArrayList<Book_Order>();
			  
			  Random r = new Random();
			  for (Cart c : blist) {
				  
				  o = new Book_Order();
			  
			  o.setOrderId("BOOK-ORD-00" + r.nextInt(1000));
			  o.setUsername(name);
			  o.setEmail(email);
			  o.setPhno(phno);
			  o.setFulladd(fullAdd);
			  o.setBookName(c.getBookName());
			  o.setAuthor(c.getAuthor());
			  o.setPrice(c.getPrice() + "");
			  o.setPaymenttype(paymentType);
			  
			  orderlist.add(o);
			  
			  }
			  
			  if ("noselect".equals(paymentType)) {
				  
				  session.setAttribute("failedMsg", "Please Choose Payment Method");
			     resp.sendRedirect("checkout.jsp");
			  }
			  
			  else {
			  
			  boolean f = service.saveOrderService(orderlist);
			  
			       if (f)
			     {
			     resp.sendRedirect("order_success.jsp");
			  
			  } else { 
				  session.setAttribute("failedMsg", "Your order failed");
				     resp.sendRedirect("checkout.jsp");
			  } }
			 
			  }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}

	}

}
