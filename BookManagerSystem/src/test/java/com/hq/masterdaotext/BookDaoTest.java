package com.hq.masterdaotext;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

import com.hq.bean.Books;
import com.hq.daoimpl.BookDaoImpl;
import com.hq.utils.UUIDUtils;

public class BookDaoTest {
	private BookDaoImpl bookDao = new BookDaoImpl();
	
	@Test
  public void  selectAllBooks() throws ParseException{
	List<Books> books = 	bookDao.selectAllBooks();
	//遍历list集合获取里面的数据
	for (Books books2 : books) {
		System.out.println("booksText:"+books2);
		
	}
	
	  
  }
}
