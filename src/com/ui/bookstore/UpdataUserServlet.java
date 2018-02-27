package com.ui.bookstore;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.Dao.bookstore.UserDao;
import com.model.bookstore.Users;

/**
 * Servlet implementation class UpdataUserServlet
 */
@WebServlet("/UpdataUser")
public class UpdataUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdataUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Users user = (Users)request.getSession().getAttribute("User");
		int id = user.getId();
		String loginId = request.getParameter("loginId");
		System.out.println("id:"+loginId);
		String loginPwd = request.getParameter("loginPwd");
		String name = request.getParameter("Name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String mail = request.getParameter("mail");
		try {
			boolean flag = UserDao.updateUser(id, loginId, loginPwd, name, address, phone, mail);
			request.setAttribute("flag", flag);
			if (flag) {
				request.getRequestDispatcher("/BooksRandom").forward(request, response);
			}else {
				request.getRequestDispatcher("/updateUser.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
