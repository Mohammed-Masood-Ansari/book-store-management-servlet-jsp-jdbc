package com.jsp.EbookMangement.service;

import java.util.List;

import com.jsp.EbookMangement.dao.BookOrderDao;
import com.jsp.EbookMangement.entity.Book_Order;

public class BookOrderService {

	BookOrderDao dao = new BookOrderDao();

	public boolean saveOrderService(List<Book_Order> blist) {

		return dao.saveOrder(blist);

	}

	public List<Book_Order> getBook(String email) {

		return dao.getBook(email);
	}

	public List<Book_Order> getAllOrderBookServcie() {
		return dao.getAllOrderBookDao();
	}
}
