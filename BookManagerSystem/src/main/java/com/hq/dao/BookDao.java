package com.hq.dao;

import java.util.List;

import com.hq.bean.Books;

public interface BookDao {
	
	//查询所有书
	public List<Books> selectAllBooks();
	//添加书籍信息
	public void insertBook(Books book);
	//删除书籍信息
	public void deleteBook(String book_id);
	//根据bookid 查询书籍信息
	public Books selectBookByBookId(String book_id);
	//修改书籍信息
	public void updateBook(Books book);
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
