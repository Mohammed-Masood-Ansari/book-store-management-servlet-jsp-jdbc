package com.jsp.EbookMangement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.EbookMangement.DB.DBConnect;
import com.jsp.EbookMangement.entity.BookDtls;

public class BookDao {

	DBConnect connect = new DBConnect();

	Connection connection = connect.getConn();

	public BookDtls BookAddDao(BookDtls bookDtls) {
		String Query = "insert into book_dtls(bookname,author,price, bookCategory,status,photo,email) values(?,?,?,?,?,?,?) ";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(Query);

			preparedStatement.setString(1, bookDtls.getBookname());
			preparedStatement.setString(2, bookDtls.getAuthor());
			preparedStatement.setString(3, bookDtls.getPrice());
			preparedStatement.setString(4, bookDtls.getBookCategory());
			preparedStatement.setString(5, bookDtls.getStatus());
			preparedStatement.setString(6, bookDtls.getPhotoName());
			preparedStatement.setString(7, bookDtls.getEmail());

			preparedStatement.executeUpdate();

			return bookDtls;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * displayAllBookDao
	 */

	public List<BookDtls> displayAllBookDao() {

		List<BookDtls> list = new ArrayList<BookDtls>();
		String Query = "select * from book_dtls";

		try {
			PreparedStatement ps = connection.prepareStatement(Query);

			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				BookDtls bookDetails = new BookDtls();
				bookDetails.setBookId(resultSet.getInt(1));
				bookDetails.setBookname(resultSet.getString(2));
				bookDetails.setAuthor(resultSet.getString(3));
				bookDetails.setPrice(resultSet.getString(4));
				bookDetails.setBookCategory(resultSet.getString(5));
				bookDetails.setStatus(resultSet.getString(6));
				bookDetails.setPhotoName(resultSet.getString(7));
				bookDetails.setEmail(resultSet.getString(8));

				list.add(bookDetails);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	/**
	 * getBookDetailsById
	 */
	public BookDtls getBookDetailsById(int id) {

		BookDtls b = new BookDtls();

		String Query = "select * from book_dtls where bookid = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(Query);
			ps.setInt(1, id);
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				b = new BookDtls();
				b.setBookId(resultSet.getInt(1));
				b.setBookname(resultSet.getString(2));
				b.setAuthor(resultSet.getString(3));
				b.setPrice(resultSet.getString(4));
				b.setBookCategory(resultSet.getString(5));
				b.setStatus(resultSet.getString(6));
				b.setPhotoName(resultSet.getString(7));
				b.setEmail(resultSet.getString(8));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return b;
	}

	/**
	 * editBookDetailsById
	 */

	public BookDtls editBookDetailsById(BookDtls bookDetails) {
		String Query = "update book_dtls set bookName =?, author = ?, price=?, status = ? where bookId = ? ";

		try {
			PreparedStatement ps = connection.prepareStatement(Query);
			ps.setString(1, bookDetails.getBookname());
			ps.setString(2, bookDetails.getAuthor());
			ps.setString(3, bookDetails.getPrice());
			ps.setString(4, bookDetails.getStatus());
			ps.setInt(5, bookDetails.getBookId());

			ps.executeUpdate();
//            System.out.println(bookDetails);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookDetails;
	}

	/**
	 * deleteBookById
	 */

	public int deleteBookById(int id) {
		String Query = "delete from book_dtls where bookId = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(Query);
			preparedStatement.setInt(1, id);
			return preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	public List<BookDtls> getNewBookDisplayDao() {

		List<BookDtls> list = new ArrayList<BookDtls>();
		String Query = "select * from book_dtls where bookCategory=? and status=? order by bookId DESC ";

		try {
			PreparedStatement ps = connection.prepareStatement(Query);

			ps.setString(1, "New");
			ps.setString(2, "Active");
			ResultSet resultSet = ps.executeQuery();
			int i = 1;
			while (resultSet.next() && i <= 4) {
				BookDtls bookDetails = new BookDtls();
				bookDetails.setBookId(resultSet.getInt(1));
				bookDetails.setBookname(resultSet.getString(2));
				bookDetails.setAuthor(resultSet.getString(3));
				bookDetails.setPrice(resultSet.getString(4));
				bookDetails.setBookCategory(resultSet.getString(5));
				bookDetails.setStatus(resultSet.getString(6));
				bookDetails.setPhotoName(resultSet.getString(7));
				bookDetails.setEmail(resultSet.getString(8));

				list.add(bookDetails);
				i++;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	public List<BookDtls> getRecentBookDisplayDao() {

		List<BookDtls> list = new ArrayList<BookDtls>();
		String Query = "select * from book_dtls where  status=? order by bookId DESC ";

		try {
			PreparedStatement ps = connection.prepareStatement(Query);

			ps.setString(1, "Active");
			ResultSet resultSet = ps.executeQuery();
			int i = 1;
			while (resultSet.next() && i <= 4) {
				BookDtls bookDetails = new BookDtls();
				bookDetails.setBookId(resultSet.getInt(1));
				bookDetails.setBookname(resultSet.getString(2));
				bookDetails.setAuthor(resultSet.getString(3));
				bookDetails.setPrice(resultSet.getString(4));
				bookDetails.setBookCategory(resultSet.getString(5));
				bookDetails.setStatus(resultSet.getString(6));
				bookDetails.setPhotoName(resultSet.getString(7));
				bookDetails.setEmail(resultSet.getString(8));

				list.add(bookDetails);
				i++;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	public List<BookDtls> getOldBookDisplayDao() {

		List<BookDtls> list = new ArrayList<BookDtls>();
		String Query = "select * from book_dtls where bookCategory=? and status=? order by bookId DESC ";

		try {
			PreparedStatement ps = connection.prepareStatement(Query);

			ps.setString(1, "Old");
			ps.setString(2, "Active");
			ResultSet resultSet = ps.executeQuery();
			int i = 1;
			while (resultSet.next() && i <= 4) {
				BookDtls bookDetails = new BookDtls();
				bookDetails.setBookId(resultSet.getInt(1));
				bookDetails.setBookname(resultSet.getString(2));
				bookDetails.setAuthor(resultSet.getString(3));
				bookDetails.setPrice(resultSet.getString(4));
				bookDetails.setBookCategory(resultSet.getString(5));
				bookDetails.setStatus(resultSet.getString(6));
				bookDetails.setPhotoName(resultSet.getString(7));
				bookDetails.setEmail(resultSet.getString(8));

				list.add(bookDetails);
				i++;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	public List<BookDtls> getAllRecentBookDisplayDao() {

		List<BookDtls> list = new ArrayList<BookDtls>();
		String Query = "select * from book_dtls where  status=? order by bookId DESC ";

		try {
			PreparedStatement ps = connection.prepareStatement(Query);

			ps.setString(1, "Active");
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				BookDtls bookDetails = new BookDtls();
				bookDetails.setBookId(resultSet.getInt(1));
				bookDetails.setBookname(resultSet.getString(2));
				bookDetails.setAuthor(resultSet.getString(3));
				bookDetails.setPrice(resultSet.getString(4));
				bookDetails.setBookCategory(resultSet.getString(5));
				bookDetails.setStatus(resultSet.getString(6));
				bookDetails.setPhotoName(resultSet.getString(7));
				bookDetails.setEmail(resultSet.getString(8));

				list.add(bookDetails);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	public List<BookDtls> getAllNewBookDisplayDao() {

		List<BookDtls> list = new ArrayList<BookDtls>();
		String Query = "select * from book_dtls where bookCategory=? and status=? order by bookId DESC ";

		try {
			PreparedStatement ps = connection.prepareStatement(Query);

			ps.setString(1, "New");
			ps.setString(2, "Active");
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				BookDtls bookDetails = new BookDtls();
				bookDetails.setBookId(resultSet.getInt(1));
				bookDetails.setBookname(resultSet.getString(2));
				bookDetails.setAuthor(resultSet.getString(3));
				bookDetails.setPrice(resultSet.getString(4));
				bookDetails.setBookCategory(resultSet.getString(5));
				bookDetails.setStatus(resultSet.getString(6));
				bookDetails.setPhotoName(resultSet.getString(7));
				bookDetails.setEmail(resultSet.getString(8));

				list.add(bookDetails);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	public List<BookDtls> getAllOldBookDisplayDao() {

		List<BookDtls> list = new ArrayList<BookDtls>();
		String Query = "select * from book_dtls where bookCategory=? and status=? order by bookId DESC ";

		try {
			PreparedStatement ps = connection.prepareStatement(Query);

			ps.setString(1, "Old");
			ps.setString(2, "Active");
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				BookDtls bookDetails = new BookDtls();
				bookDetails.setBookId(resultSet.getInt(1));
				bookDetails.setBookname(resultSet.getString(2));
				bookDetails.setAuthor(resultSet.getString(3));
				bookDetails.setPrice(resultSet.getString(4));
				bookDetails.setBookCategory(resultSet.getString(5));
				bookDetails.setStatus(resultSet.getString(6));
				bookDetails.setPhotoName(resultSet.getString(7));
				bookDetails.setEmail(resultSet.getString(8));

				list.add(bookDetails);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}
	
	// email and category i.e   By email
	public List<BookDtls> getBookByOld(String email, String cate) {

		List<BookDtls> list = new ArrayList<BookDtls>();

		String Query = "select * from book_dtls where bookCategory=? and email=? ";

		try {
			PreparedStatement ps = connection.prepareStatement(Query);

			ps.setString(1, cate);
			ps.setString(2, email);
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {

				BookDtls bookDetails = new BookDtls();
				bookDetails.setBookId(resultSet.getInt(1));
				bookDetails.setBookname(resultSet.getString(2));
				bookDetails.setAuthor(resultSet.getString(3));
				bookDetails.setPrice(resultSet.getString(4));
				bookDetails.setBookCategory(resultSet.getString(5));
				bookDetails.setStatus(resultSet.getString(6));
				bookDetails.setPhotoName(resultSet.getString(7));
				bookDetails.setEmail(resultSet.getString(8));

				list.add(bookDetails);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}
	// remove by user via email and category
	
	public int oldBookDelete(String email,String cate,int id) {
		String Query = "delete from book_dtls where bookCategory=? and email=? and bookId=?";
		try {
			PreparedStatement ps = connection.prepareStatement(Query);
			ps.setString(1, cate);
			ps.setString(2, email);
			ps.setInt(3, id);

			return ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	public List<BookDtls> getBookBySearch(String ch){
		
		List<BookDtls> list = new ArrayList<BookDtls>();

		String Query = "select * from book_dtls where bookname like ? or author like ? or bookCategory like ? and status=?";

		try {
			PreparedStatement ps = connection.prepareStatement(Query);

			ps.setString(1, "%"+ch+"%");
			ps.setString(2, "%"+ch+"%");
			ps.setString(3, "%"+ch+"%");
			ps.setString(4, "Active");

			
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {

				BookDtls bookDetails = new BookDtls();
				bookDetails.setBookId(resultSet.getInt(1));
				bookDetails.setBookname(resultSet.getString(2));
				bookDetails.setAuthor(resultSet.getString(3));
				bookDetails.setPrice(resultSet.getString(4));
				bookDetails.setBookCategory(resultSet.getString(5));
				bookDetails.setStatus(resultSet.getString(6));
				bookDetails.setPhotoName(resultSet.getString(7));
				bookDetails.setEmail(resultSet.getString(8));

				list.add(bookDetails);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

		
	}

}











