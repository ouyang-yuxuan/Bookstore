package com.servlet.bookstore;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.bookstore.BooksDao;
import com.model.bookstore.Books;
import com.tools.bookstore.PageUtil;

/**
 * Servlet implementation class BooksManServlet
 */
@WebServlet("/Man/BooksMan")
public class BooksManServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BooksManServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		 //设置服务器输出的编码为UTF-8
	    response.setCharacterEncoding("UTF-8");
	    //告诉浏览器输出的内容是html,并且以utf-8的编码来查看这个内容。
	    response.setContentType("text/html; charset=utf-8");
		System.out.println(request.getParameter("flagType"));
		if (request.getParameter("flagType")!=null) {
			String flagType = request.getParameter("flagType");
			switch (flagType) {
			case "display":
				try {
						int pageNo = Integer.valueOf(request.getParameter("pageNo"));
						PageUtil page = BooksDao.getBooks(pageNo, 20);
			            page.setPageNo(pageNo);
			            request.setAttribute("page", page);
			            request.getRequestDispatcher("/admin/product_list.jsp").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "delete":
				int id = Integer.valueOf(request.getParameter("id"));
				try {
					boolean flag = BooksDao.deleteBook(id);
					request.setAttribute("flag", flag);
					request.getRequestDispatcher("/admin/product_list.jsp").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
					break;
			default:
				break;
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		 //设置服务器输出的编码为UTF-8
	    response.setCharacterEncoding("UTF-8");
	    //告诉浏览器输出的内容是html,并且以utf-8的编码来查看这个内容。
	    response.setContentType("text/html; charset=utf-8");
		String type = request.getParameter("type");
		try {

			int pageNo = Integer.valueOf(request.getParameter("pageNo"));
			PageUtil page = BooksDao.queryBooks(pageNo, 20, type);
			request.setAttribute("page", page);
			request.getRequestDispatcher("/admin/product_list.jsp").forward(request, response);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
