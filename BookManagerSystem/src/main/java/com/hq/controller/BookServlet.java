package com.hq.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hq.bean.Books;
import com.hq.serviceimpl.BookServiceImpl;
import com.hq.utils.UUIDUtils;

@WebServlet("/BookSevlet")
public class BookServlet extends HttpServlet {// 处理书的请求 添加 查找 删除 修改
	//
	BookServiceImpl bookService = new BookServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 如果让一个servlet处理多个请求 需要再jsp页面设置参数来区分不同的请求
		String path = req.getParameter("path");
		System.out.println("path:" + path);
		if (path.equals("addbookui")) {
			// 转发到add.jsp页面
			addBookUI(req, resp);

		} else if (path.equals("addbook")) {
			try {
				addBook(req, resp);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (path.equals("deletebookId")) {
			deleteBooId(req, resp);

		} else if (path.equals("updatebookui")) {
			// 进入到修改页面
			updateBookUI(req, resp);

		} else if (path.equals("updateBook")) {
			try {
				updateBook(req,resp);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	protected void updateBook(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, ParseException {
		// 更新数据的操作 从页面获取book_id
		String bookId = req.getParameter("bookId");
		System.out.println("bookId:" + bookId);
		// 获取修改页面修改后的数据

		String bookName = req.getParameter("bookname");

		int bookType = Integer.parseInt(req.getParameter("bookType"));
		boolean isBorrow = Boolean.parseBoolean(req.getParameter("isBorrow"));
		String author = req.getParameter("author");
		String press = req.getParameter("press");
		double price = Double.parseDouble(req.getParameter("price"));

		// 时间的处理： 书二点发布时间 ：表单输入： 2020-01-01
		String publishtime = req.getParameter("publishtime"); // 如何将String类型转换为Date
		SimpleDateFormat sp = new SimpleDateFormat("YYYY-MM-DD");// 数据库表中的date字段数据格式xxxx-xx-xx
		Date publishDate = sp.parse(publishtime);
		// register_time 值是系统的时间 如何获取系统时间:System.currentTimeMillis() 获取系统时间的毫秒值
		// long System.currentTimeMillis() Date(Long time) new Date()
		// Date register_time = new Date(System.currentTimeMillis());
		String registerTime = req.getParameter("registerTime");
		SimpleDateFormat sp1 = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
		Date db_registerTime = sp1.parse(registerTime);

		Books book = new Books(bookId, bookName, bookType, author, press, publishDate, price, db_registerTime,
				isBorrow);
		System.out.println("book" + book);
		bookService.updateBook(book);

		// 转发到list.jsp
		// 响应： 响应到main.jsp中 list.jsp中要显示全部书的信息 ？
		List<Books> books = bookService.selectAllBooks();
		req.setAttribute("book1", books);

		req.getRequestDispatcher("/view/system/main/list.jsp").forward(req, resp);

	}

	protected void updateBookUI(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取页面传递的book_id
		String book_id = req.getParameter("id");
		System.out.println("book_id:====" + book_id);
		// 进入到修改页面
		Books book = bookService.selectBookByBookId(book_id);
		System.out.println("book====" + book);
		// 将我们查询到的book信息传递到jsp页面上
		req.setAttribute("book", book);
		req.getRequestDispatcher("/view/system/main/update.jsp").forward(req, resp);

	}

	protected void deleteBooId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 从页面获取传递过来的book_id
		String bookId = req.getParameter("id");
		// 根据jsp页面传递的book_id 执行删除操作
		bookService.deleteBooks(bookId);
		// 响应： 响应到main.jsp中 list.jsp中要显示全部书的信息 ？
		List<Books> books = bookService.selectAllBooks();
		req.setAttribute("book1", books);

		req.getRequestDispatcher("/view/system/main/list.jsp").forward(req, resp);

	}

	protected void addBookUI(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/view/system/main/add.jsp").forward(req, resp);

	}

	protected void addBook(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, ParseException {
		// 1 获取add.jsp页面的参数 :req.getParameter("表单的name属性值") 该方法的返回值是String类型
		// 3:将对象传递到service层 --dao 实现添加功能
		String bookId = UUIDUtils.getUUID();// 书有编号 随机的String值
		String bookName = req.getParameter("bookname");

		int bookType = Integer.parseInt(req.getParameter("bookType"));
		boolean isBorrow = Boolean.parseBoolean(req.getParameter("isBorrow"));
		String author = req.getParameter("author");
		String press = req.getParameter("press");
		double price = Double.parseDouble(req.getParameter("price"));

		// 时间的处理： 书二点发布时间 ：表单输入： 2020-01-01
		String publishtime = req.getParameter("publishtime"); // 如何将String类型转换为Date
		SimpleDateFormat sp = new SimpleDateFormat("YYYY-MM-DD");// 数据库表中的date字段数据格式xxxx-xx-xx
		Date publishDate = sp.parse(publishtime);
		// register_time 值是系统的时间 如何获取系统时间:System.currentTimeMillis() 获取系统时间的毫秒值
		// long System.currentTimeMillis() Date(Long time) new Date()
		Date register_time = new Date(System.currentTimeMillis());

		Books book = new Books(bookId, bookName, bookType, author, press, publishDate, price, register_time, isBorrow);
		System.out.println("book" + book);
		// 调用业务逻辑层
		bookService.addBook(book);

		// 响应： 响应到main.jsp中 list.jsp中要显示全部书的信息 ？
		List<Books> books = bookService.selectAllBooks();
		req.setAttribute("book1", books);

		req.getRequestDispatcher("/view/system/main/list.jsp").forward(req, resp);

	}

}
