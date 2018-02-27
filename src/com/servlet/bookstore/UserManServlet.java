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

import com.Dao.bookstore.UserDao;
import com.model.bookstore.Users;

/**
 * Servlet implementation class UserManServlet
 */
@WebServlet("/Man/UserMan")
public class UserManServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserManServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Users> users = new ArrayList<>();
		if (request.getParameter("LoginId")!=null&&request.getParameter("LoginId")!="") {
			String LoginId = request.getParameter("LoginId");
			try {
				users = UserDao.QueryUsersByLoginId(LoginId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				users = UserDao.getUsers();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.setAttribute("users", users);
		request.getRequestDispatcher("/admin/user_list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String loginId = request.getParameter("loginId");
		String loginPwd = request.getParameter("loginPwd");
		String name = request.getParameter("Name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String mail = request.getParameter("mail");

		try {
			boolean flag = UserDao.addUser(loginId, loginPwd, name, address, phone, mail);
			System.out.println(flag);
			request.getRequestDispatcher("/admin/user_list.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
