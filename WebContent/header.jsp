<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.model.bookstore.Users"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div id="templatemo_menu">
    	<ul>
            <li><a href="/Bookstore/BooksRandom" class="current">Home</a></li>
            <li><a href="subpage.jsp">Search</a></li>
                <c:choose>
                   <c:when test="${sessionScope.User!=null}">
                        <li><a href="cart.jsp">Cart</a></li>			
                        <li><a href="/Bookstore/MyOrder">MyOrder</a></li>			
						<li><a href="updateUser.jsp">Modify My information</a></li>			
						<li><a href="/Bookstore/UserLogin">LoginOut</a></li>	
				   </c:when>
                   <c:when test="${sessionScope.User==null }">
			            <li><a href="login.jsp">login</a></li>         
			            <li><a href="register.jsp">Register</a></li>  
                   </c:when>
                </c:choose>         
    	</ul>
    </div> <!-- end of menu -->
</body>
</html>