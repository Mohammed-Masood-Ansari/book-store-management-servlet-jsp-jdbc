package com.jsp.EbookMangement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.EbookMangement.DB.DBConnect;
import com.jsp.EbookMangement.entity.BookDtls;
import com.jsp.EbookMangement.entity.Cart;

public class CartDao {

	DBConnect connect = new DBConnect();

	Connection connection = connect.getConn();

	public boolean registerCartUserDao(Cart cart) {
		boolean f=false;

		try {
			String Query = "insert into cart(bid,uid,book_name, author,price,total_price) values(?,?,?,?,?,?) ";
			PreparedStatement preparedStatement = connection.prepareStatement(Query);

			preparedStatement.setInt(1, cart.getBid());
			preparedStatement.setInt(2, cart.getUserId());
			preparedStatement.setString(3, cart.getBookName());
			preparedStatement.setString(4, cart.getAuthor());
			preparedStatement.setDouble(5, cart.getPrice());
			preparedStatement.setDouble(6, cart.getTotalprice());

		int i=preparedStatement.executeUpdate();
			
		if(i==1) {
			f=true;
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return f;

	}

	public List<Cart> getBookByUser(int userId) {

		List<Cart> list = new ArrayList<Cart>();
        Cart c=null;
		double totalPrice = 0;

		try {
			String Query = "select * from cart where uid=?";
			PreparedStatement preparedStatement = connection.prepareStatement(Query);

			preparedStatement.setInt(1, userId);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
              c=new Cart();
				c.setCid(resultSet.getInt(1));
				c.setBid(resultSet.getInt(2));
				c.setUserId(resultSet.getInt(3));
				c.setBookName(resultSet.getString(4));
				c.setAuthor(resultSet.getString(5));
				c.setPrice(resultSet.getDouble(6));
				totalPrice = totalPrice + resultSet.getDouble(7);
				c.setTotalprice(totalPrice);
				list.add(c);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	public int deleteBook(int bid,int uid,int cid) {
		String Query = "delete from cart where bid = ? and uid=? and cid= ? ";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(Query);
			preparedStatement.setInt(1, bid);
			preparedStatement.setInt(2, uid);
			preparedStatement.setInt(3, cid);


			return preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}
}
