package com.servlet.bookstore;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.User;

import com.Dao.bookstore.OrderDao;
import com.Dao.bookstore.UserDao;
import com.model.bookstore.Orders;

/**
 * Servlet implementation class OrdersManServlet
 */
@WebServlet("/Man/OrdersMan")
public class OrdersManServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersManServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			if ("delete".equals(request.getParameter("flagType"))) {
				int id = Integer.valueOf(request.getParameter("id"));
				int OrderID = id;
				boolean flag1 = OrderDao.deleteOrders(id);
				boolean flag2 = OrderDao.deleteOrderbooks(OrderID);
			}
			ArrayList<Orders> orders = OrderDao.getOrders();
			UserDao userDao = new UserDao();
			request.setAttribute("orders", orders);
			request.setAttribute("userDao", userDao);
			request.getRequestDispatcher("/admin/order_list.jsp").forward(request, response);
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
		doGet(request, response);
	}

}
