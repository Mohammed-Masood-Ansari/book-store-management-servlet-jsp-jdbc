package com.jsp.EbookMangement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jsp.EbookMangement.DB.DBConnect;
import com.jsp.EbookMangement.entity.User;

public class Userdao {

	DBConnect connect = new DBConnect();

	Connection connection = connect.getConn();

	public User registerUserDao(User user) {
		String Query = "insert into user(name,email,phno, password)  values(?,?,?,?) ";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(Query);

			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPhno());
			preparedStatement.setString(4, user.getPassword());

			preparedStatement.executeUpdate();
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	/***
	 * userLoginDaoByEmail
	 */
	public User userLoginDaoByEmailDao(String email, String password) {
		User user = new User();
		String Query = "select * from user where email = ? and password = ? ";

		try {
			PreparedStatement ps = connection.prepareStatement(Query);
			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				user.setId(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setEmail(resultSet.getString(3));
				user.setPhno(resultSet.getString(4));
				user.setPassword(resultSet.getString(5));
				user.setAdress(resultSet.getString(6));
				user.setLandmark(resultSet.getString(7));
				user.setCity(resultSet.getString(8));
				user.setState(resultSet.getString(9));
				user.setPincode(resultSet.getString(10));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	public boolean checkPasswordDao(int id, String ps) {

		boolean f = false;

		String Query = "select * from user where id=? and password = ? ";

		try {

			PreparedStatement ps1 = connection.prepareStatement(Query);
			ps1.setInt(1, id);
			ps1.setString(2, ps);
			ResultSet resultSet = ps1.executeQuery();

			while (resultSet.next()) {
				f = true;

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return f;
	}

	public boolean updateProfile(User user) {
		boolean f = false;

		try {
			String Query = " update user set name=?,email=?,phno=? where id=? ";
			PreparedStatement preparedStatement = connection.prepareStatement(Query);

			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPhno());
			preparedStatement.setInt(4, user.getId());
			int i = preparedStatement.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return f;

	}

	// unique email i.e data base me agr email phle se hy to wha pe alerady exits
	// dikhana chhaiye

	
	
	public boolean checkUser(String em) {
		
		boolean f=true;
		
		try {
			String Query = " select * from user where email=?";
			PreparedStatement ps = connection.prepareStatement(Query);

			ps.setString(1, em);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				
				f=false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return f;

		
	}
	
	
	
}











