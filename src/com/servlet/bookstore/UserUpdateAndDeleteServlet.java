package com.servlet.bookstore;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.bookstore.UserDao;
import com.model.bookstore.Users;

/**
 * Servlet implementation class UserUpdateAndDeleteServlet
 */
@WebServlet("/Man/UserUpdateAndDelete")
public class UserUpdateAndDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateAndDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("id")!=null) {
			int id = Integer.valueOf(request.getParameter("id"));
			if (("yes").equals(request.getParameter("delete"))){
				try {
					boolean flag = UserDao.deleteUser(id);
					request.setAttribute("flag", flag);
					request.getRequestDispatcher("/admin/user_list.jsp").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				try {
					Users users = UserDao.queryUserById(id);
					request.setAttribute("user", users);
					request.setAttribute("id", id);
					request.getRequestDispatcher("/admin/edit_user.jsp").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int id = Integer.valueOf(request.getParameter("id"));
		String loginId = request.getParameter("loginId");
		String loginPwd = request.getParameter("loginPwd");
		String name = request.getParameter("Name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String mail = request.getParameter("mail");
		try {
			boolean flag = UserDao.updateUser(id, loginId, loginPwd, name, address, phone, mail);
			request.setAttribute("flag", flag);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("/admin/user_list.jsp").forward(request, response);
	}

}
