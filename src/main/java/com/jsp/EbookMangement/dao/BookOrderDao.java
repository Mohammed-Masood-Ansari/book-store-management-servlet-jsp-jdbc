package com.jsp.EbookMangement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jsp.EbookMangement.DB.DBConnect;
import com.jsp.EbookMangement.entity.Book_Order;

public class BookOrderDao {

	DBConnect connect = new DBConnect();

	Connection connection = connect.getConn();

	

	public boolean saveOrder(List<Book_Order> blist) {

		boolean f=false;
		
		try {
			 
			
			String Query = "insert into book_order(order_id,user_name,email,address,phone,book_name,author,price,payment) values(?,?,?,?,?,?,?,?,?)";

			connection.setAutoCommit(false);
			PreparedStatement ps = connection.prepareStatement(Query);

			for(Book_Order b:blist) {
				
			ps.setString(1, b.getOrderId());
			ps.setString(2, b.getUsername());
			ps.setString(3, b.getEmail());
			ps.setString(4, b.getFulladd());
			ps.setString(5, b.getPhno());
			ps.setString(6, b.getBookName());
			ps.setString(7, b.getAuthor());
			ps.setString(8, b.getPrice());
			ps.setString(9, b.getPaymenttype());
            ps.addBatch();
			}
			
			int[] count=ps.executeBatch();
			
			connection.commit();
			f=true;
			connection.setAutoCommit(true);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return f;
		
		
	}
	
	public List<Book_Order> getBook(String email){
		
		List<Book_Order> list=new ArrayList<Book_Order>();
		
		Book_Order o=null;
		
		try {
			String Query = "select * from book_order where email=? ";

			PreparedStatement ps = connection.prepareStatement(Query);
            ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
				o=new Book_Order();
				o.setId(rs.getInt(1));
				o.setOrderId(rs.getString(2));
				o.setUsername(rs.getString(3));
				o.setEmail(rs.getString(4));
				o.setFulladd(rs.getString(5));
				o.setPhno(rs.getString(6));
				o.setBookName(rs.getString(7));
				o.setAuthor(rs.getString(8));
				o.setPrice(rs.getString(9));
				o.setPaymenttype(rs.getString(10));
				list.add(o);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
		
	
	}
	// admin sb user ko dekh ske total order
	
	public List<Book_Order> getAllOrderBookDao(){
		
    List<Book_Order> list=new ArrayList<Book_Order>();
		
		Book_Order o=null;
		
		try {
			String Query = "select * from book_order ";

			PreparedStatement ps = connection.prepareStatement(Query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
				o=new Book_Order();
				o.setId(rs.getInt(1));
				o.setOrderId(rs.getString(2));
				o.setUsername(rs.getString(3));
				o.setEmail(rs.getString(4));
				o.setFulladd(rs.getString(5));
				o.setPhno(rs.getString(6));
				o.setBookName(rs.getString(7));
				o.setAuthor(rs.getString(8));
				o.setPrice(rs.getString(9));
				o.setPaymenttype(rs.getString(10));
				list.add(o);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;

		
	}
}



















