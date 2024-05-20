package com.jsp.EbookMangement.service;

import com.jsp.EbookMangement.dao.BookDao;
import com.jsp.EbookMangement.entity.BookDtls;

public class BookService {

	BookDao dao = new BookDao();

	public BookDtls BookAddService(BookDtls bookDtls) {

		return dao.BookAddDao(bookDtls);

	}

	public BookDtls editBookDetailsByIdService(BookDtls bookDtls) {

		return dao.editBookDetailsById(bookDtls);

	}

	public int deleteBookById(int id) {
		return dao.deleteBookById(id);
	}

	public int oldBookDeleteService(String email, String cate,int id) {

		return dao.oldBookDelete(email, cate, id);

	}
}
