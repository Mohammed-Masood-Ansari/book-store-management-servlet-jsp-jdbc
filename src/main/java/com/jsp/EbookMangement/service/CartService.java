package com.jsp.EbookMangement.service;

import com.jsp.EbookMangement.dao.CartDao;
import com.jsp.EbookMangement.entity.Cart;

public class CartService {

	CartDao dao = new CartDao();

	public boolean saveCartUserService(Cart cart) {

		return dao.registerCartUserDao(cart);

	}

	public int deleteBook(int bid,int uid,int cid) {

		return dao.deleteBook(bid, uid,cid);

	}
}
