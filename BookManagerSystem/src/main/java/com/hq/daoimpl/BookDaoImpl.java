package com.hq.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.hq.bean.Books;
import com.hq.dao.BookDao;
import com.hq.utils.JDBCUtils1;

public class BookDaoImpl implements BookDao {

	@Override
	public List<Books> selectAllBooks() {
		// TODO 连接数据库  获取所有的书信息
		Connection conn = JDBCUtils1.getConnection();
		String sql = "select * from j2ee_books";
		//创建一个集合对象用来存储Books对象
		List<Books> list_books = new ArrayList<>();
		try {
			PreparedStatement pt = conn.prepareStatement(sql);
			//sql中没有？就不需要设置值
			//执行sql
			ResultSet st = pt.executeQuery();
			while (st.next()) {
				//获取对应行的列数据
				Books book = new Books();
				book.setBook_id(st.getString("book_id"));
				book.setBook_name(st.getString("book_name"));
				book.setBook_type(st.getInt("book_type"));
				book.setAuthor(st.getString("author"));
				book.setPress(st.getString("press"));
				book.setPublish_date(st.getDate("publish_date"));
				book.setPrice(st.getDouble("price"));
				book.setRegister_time(st.getTimestamp("register_time"));
				book.setIs_borrow(st.getBoolean("is_borrow"));
				
				//将书对象添加进集合List中
				list_books.add(book);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list_books;
	}

	//添加图书的具体实现  操作数据库
	@Override
	public void insertBook(Books book) {
		// TODO Auto-generated method stub
	 Connection conn = 	JDBCUtils1.getConnection();
	 String sql = "insert into j2ee_books values(?,?,?,?,?,?,?,?,?)";
	 try {
		PreparedStatement pt = conn.prepareStatement(sql);
		//给？设置具体的值
		pt.setString(1, book.getBook_id());
		pt.setString(2, book.getBook_name());
		pt.setInt(3, book.getBook_type());
		pt.setString(4, book.getAuthor());
		pt.setString(5, book.getPress());
		//对日期的处理  javaBean :java.util.Date     pt.setDate(6, java.sql);	 java.sql.date 提供了一个构造方法（Long 时间的毫秒数）
        //java.util.Date   getTime() 就可以返回毫秒数:book.getPublish_date().getTime()
		pt.setDate(6,new java.sql.Date(book.getPublish_date().getTime()) );	
		pt.setDouble(7, book.getPrice());
		pt.setTimestamp(8, new java.sql.Timestamp(book.getRegister_time().getTime()));
		pt.setBoolean(9, book.isIs_borrow());
		//执行sql
		pt .executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
		
	}

	//根据BookId查询书籍信息
	@Override
	public Books selectBookByBookId(String book_id) {
		Connection conn = JDBCUtils1.getConnection();
		String sql = "select * from j2ee_books where book_id=?";
		Books book  = null;
		try {
			PreparedStatement pt = conn.prepareStatement(sql);
			pt.setString(1, book_id);
			ResultSet st = pt.executeQuery();
			while (st.next()) {
				//获取对应行的列数据
				book = new Books();
				book.setBook_id(st.getString("book_id"));
				book.setBook_name(st.getString("book_name"));
				book.setBook_type(st.getInt("book_type"));
				book.setAuthor(st.getString("author"));
				book.setPress(st.getString("press"));
				book.setPublish_date(st.getDate("publish_date"));
				book.setPrice(st.getDouble("price"));
				book.setRegister_time(st.getTimestamp("register_time"));
				book.setIs_borrow(st.getBoolean("is_borrow"));	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return book;
	}

	@Override
	public void deleteBook(String book_id) {
		Connection conn = JDBCUtils1.getConnection();
		String sql = "delete from j2ee_books where book_id =?";
		try {
			PreparedStatement pt = conn.prepareStatement(sql);
			pt.setString(1, book_id);
			pt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	//修改数据
	@Override
	public void updateBook(Books book) {
		// TODO Auto-generated method stub
		Connection conn = JDBCUtils1.getConnection();
		String sql = "update j2ee_books set book_name=?,book_type=?,author=?,press=?,publish_date=?,price=?,register_time=?,is_borrow=? where book_id=?";
		try {
			PreparedStatement pt = conn.prepareStatement(sql);
			//给？设置具体的值
			
			pt.setString(1, book.getBook_name());
			pt.setInt(2, book.getBook_type());
			pt.setString(3, book.getAuthor());
			pt.setString(4, book.getPress());
			//对日期的处理  javaBean :java.util.Date     pt.setDate(6, java.sql);	 java.sql.date 提供了一个构造方法（Long 时间的毫秒数）
	        //java.util.Date   getTime() 就可以返回毫秒数:book.getPublish_date().getTime()
			pt.setDate(5,new java.sql.Date(book.getPublish_date().getTime()) );	
			pt.setDouble(6, book.getPrice());
			pt.setTimestamp(7, new java.sql.Timestamp(book.getRegister_time().getTime()));
			pt.setBoolean(8, book.isIs_borrow());
			pt.setString(9, book.getBook_id());
			//执行sql
			pt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	

}
