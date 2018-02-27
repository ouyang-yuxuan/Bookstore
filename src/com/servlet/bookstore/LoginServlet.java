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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		if (request.getParameter("LoginId")!=""&&request.getParameter("LoginPwd")!="") {
			String LoginId = request.getParameter("LoginId");
			String LoginPwd = request.getParameter("LoginPwd");
			try {
				Users user = UserDao.loginQuery(LoginId, LoginPwd);
//				System.out.println(user);
				if (user!=null) {
					request.setAttribute("User", user);
					System.out.println(user.getPermissionId());
					request.getSession().setAttribute("User", user);
					response.sendRedirect(request.getContextPath() + "/admin/index.jsp");
				}else {
					response.sendRedirect(request.getContextPath() + "/adminLogin.jsp");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			request.getRequestDispatcher("/Booksotre/adminLogin.jsp").forward(request, response);;
		}	
	}

}
