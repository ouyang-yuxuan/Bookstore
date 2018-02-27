package com.ui.bookstore;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.bookstore.UserDao;
import com.model.bookstore.Users;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLogin")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpServletRequest httpreq=(HttpServletRequest)request;
		HttpSession httpsession = httpreq.getSession();
		httpsession.invalidate();
		response.sendRedirect(request.getContextPath() + "/BooksRandom");
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
					request.getSession().setAttribute("User", user);
					response.sendRedirect(request.getContextPath() + "/BooksRandom");
				}else {
					response.sendRedirect(request.getContextPath() + "/login.jsp");
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
