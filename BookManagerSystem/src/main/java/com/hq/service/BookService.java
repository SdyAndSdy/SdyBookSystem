package com.hq.service;

import java.util.List;

import com.hq.bean.Books;

public interface BookService {
	
	public List<Books> selectAllBooks();
	//添加书籍
	public void addBook(Books book);
	//删除图书信息
	public void deleteBooks(String book_id);
	//根据bookid 查询书籍信息
	public Books selectBookByBookId(String book_id);
	//修改书籍信息
	public void updateBook(Books book);
	
	
	

}
