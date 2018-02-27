package com.phone.bookstore;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.User;

import com.Dao.bookstore.UserDao;
import com.model.bookstore.Users;

/**
 * Servlet implementation class PhoneRegister
 */
@WebServlet("/PhoneRegister")
public class PhoneRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhoneRegisterServlet() {
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
		request.setCharacterEncoding("utf-8");
		String loginId = request.getParameter("LoginId");
		String loginPwd = request.getParameter("LoginPwd");
		String name = request.getParameter("Name");
		String address = request.getParameter("Address");
		String phone = request.getParameter("Phone");
		String mail = request.getParameter("Mail");
		try {
			PrintWriter out = response.getWriter();
			boolean flag = false;
			Users user = UserDao.loginQueryByLoginId(loginId);
			System.out.println(user);
			if (user==null) {
				flag = UserDao.addUser(loginId, loginPwd, name, address, phone, mail);
				out.print(flag);
				System.out.println(flag);
			}else {
				out.print("0");
				System.out.println("0");
			}
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
