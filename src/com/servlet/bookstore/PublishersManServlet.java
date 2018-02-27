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
import com.Dao.bookstore.OtherDao;
import com.model.bookstore.Books;
import com.model.bookstore.Publishers;

/**
 * Servlet implementation class PublishersManServlet
 */
@WebServlet("/Man/PublishersMan")
public class PublishersManServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublishersManServlet() {
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
					ArrayList<Publishers> publishers = OtherDao.getPublishers();
					request.setAttribute("publishers", publishers);
					request.getRequestDispatcher("/admin/product_publishers.jsp").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "search":
				break;
			case "delete":
				int id = Integer.valueOf(request.getParameter("id"));
				try {
					boolean flag = OtherDao.deletePublishers(id);
					request.setAttribute("flag", flag);
					request.getRequestDispatcher("/admin/product_publishers.jsp").forward(request, response);
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
		int id = Integer.valueOf(request.getParameter("id"));
		String name = request.getParameter("name");
		try {
			boolean flag = OtherDao.addPublishers(id, name);
			request.setAttribute("flag", flag);
			request.setAttribute("flagType", "display");
			request.getRequestDispatcher("/admin/product_publishers.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
