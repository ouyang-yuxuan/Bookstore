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
import com.Dao.bookstore.OrderDao;
import com.Dao.bookstore.UserDao;
import com.model.bookstore.Orderbook;
import com.model.bookstore.Orders;

/**
 * Servlet implementation class OrdersUpdataServlet
 */
@WebServlet("/Man/OrdersUpdata")
public class OrdersUpdataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersUpdataServlet() {
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
		int OrderID = Integer.valueOf(request.getParameter("id"));
		try {
			
			Orders order = OrderDao.getOrder(OrderID);
			ArrayList<Orderbook>  orderbooks = OrderDao.getOrderBooks(OrderID);
			UserDao userDao = new UserDao();
			BooksDao booksDao = new BooksDao();
			request.setAttribute("order", order);
			request.setAttribute("userDao", userDao);
			request.setAttribute("orderbooks", orderbooks);
			request.setAttribute("booksDao", booksDao);
			request.getRequestDispatcher("/admin/edit_order_detail.jsp").forward(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		int id = Integer.valueOf(request.getParameter("id"));
		String name = request.getParameter("Name");
		String phone = request.getParameter("Phone");
		String address = request.getParameter("Address");
		try {
			boolean flag = UserDao.updateUser(id, name, address, phone);
			request.setAttribute("flag", flag);
			request.getRequestDispatcher("/Man/OrdersMan").forward(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
