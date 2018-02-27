package com.ui.bookstore;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.bookstore.OrderDao;
import com.model.bookstore.CartItem;
import com.model.bookstore.Users;

/**
 * Servlet implementation class AddToCart
 */
@WebServlet("/AddToCart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1:将添加到购物车里面的物品显示出来
        Map<Integer,CartItem> map=(Map<Integer,CartItem>)request.getSession().getAttribute("cart");
        Users user = (Users) request.getSession().getAttribute("User");
        int userId = user.getId();
        int orderid = 0;
       //2:将购物车里面的内容遍历出来
       float totalPrice=0;//显示出总价格
       for(Map.Entry<Integer,CartItem> entry : map.entrySet()){
           //计算出每一样的书籍一共花了多少钱
           float price=entry.getValue().getBook().getUnitPrice()* entry.getValue().getNumber();
           //计算出一共花了多少钱
           totalPrice=totalPrice+price;
       }
       try {
		orderid = OrderDao.addOrder(userId, totalPrice, 1);
		System.out.println(orderid);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		boolean flag = false;
       for(Map.Entry<Integer,CartItem> entry : map.entrySet()){
           //计算出每一样的书籍一共花了多少钱
    	   int BookID = entry.getValue().getBook().getId();
    	   int Quantity = entry.getValue().getNumber();
           float price=entry.getValue().getBook().getUnitPrice()* entry.getValue().getNumber();
			try {
				flag = OrderDao.addOrderbooks(BookID, orderid, Quantity, price);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       }
		request.setAttribute("flag", flag);
		request.getSession().removeAttribute("cart");
		request.getRequestDispatcher("/BooksRandom").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
