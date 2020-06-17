package com.hq.serviceimpl;

import java.util.List;

import com.hq.bean.Books;
import com.hq.daoimpl.BookDaoImpl;
import com.hq.service.BookService;

public class BookServiceImpl implements BookService {
	private BookDaoImpl bookDao = new BookDaoImpl();

	@Override
	public List<Books> selectAllBooks() {
		// TODO Auto-generated method stub
		return bookDao.selectAllBooks();
	}

	//添加书籍
	@Override
	public void addBook(Books book) {
		// TODO Auto-generated method stub
		bookDao.insertBook(book);
		
	}
    //根据book_id查询书籍信息
	@Override
	public Books selectBookByBookId(String book_id) {
		// TODO Auto-generated method stub
		
		return bookDao.selectBookByBookId(book_id);
	}

	@Override
	public void deleteBooks(String book_id) {
		// TODO Auto-generated method stub
		bookDao.deleteBook(book_id);
		
	}

	@Override
	public void updateBook(Books book) {
		// TODO Auto-generated method stub
		bookDao.updateBook(book);
	}

	
}
