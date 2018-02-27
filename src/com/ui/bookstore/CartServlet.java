package com.ui.bookstore;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.bookstore.BooksDao;
import com.model.bookstore.Books;
import com.model.bookstore.CartItem;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/Cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.valueOf(request.getParameter("id"));
		//购物车功能
	    //1:首先考虑我购买的是哪一本书籍，这里可以使用id确认也可以使用session中取出哪一本书籍
	    Books book = new Books();
		try {
			book = BooksDao.getBook(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    //2:考虑如何把书籍放到购物车中
	        //2.1:首先考虑是否有购物车，如果没有，则创建，如果有直接使用
	        //2.2:其次先将购物车从session中拿出来，不存在就创建。
	    Map<Integer,CartItem> cart=(Map<Integer,CartItem>)request.getSession().getAttribute("cart");
	    //如果没有购物车，那么创建，只有第一次访问才会操作
	    if(cart==null){
	        //new一个购物车
	        cart=new HashMap<>();
	    }
	    
	    //3:考虑如何把书籍放到购物车中
	        //3.1:第一考虑购物车中是否有该书籍，所以先从购物车中获取该书籍，如果为空，那么没有该书籍
	    CartItem item=(CartItem)cart.get(book.getId());
	    if(item==null){
	        //如果购物车中不存在该书籍，那么创建，且数量默认为1
	        item=new CartItem();
	        //将书籍放到购物车中
	        item.setBook(book);
	        //将书籍的默认数量为1
	        item.setNumber(1);
	    }else{
	        //如果购物车中以及有该书籍，那么数量加1 
	        item.setNumber(item.getNumber()+1);
	    }
	    
	    //4:考虑如何把购物车项(即挑选的书籍是哪一个和书本的数量)放到购物车中
	    cart.put(book.getId(),item);
	    //5:将购物车放到session中，方便后面取出来
	    request.getSession().setAttribute("cart", cart);
	    
	    request.getRequestDispatcher("/BooksRandom").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("post");
	}

}
