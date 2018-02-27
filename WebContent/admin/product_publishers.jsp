<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>出版社</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${pageContext.request.contextPath}/admin/style/adminStyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i></i><em>出版社</em></span>
    <span class="modular fr"><a href="${pageContext.request.contextPath}/admin/add_publishers.jsp" class="pt-link-btn">+添加新出版社</a></span>
  </div>
  
  <table class="list-style">
   <tr>
    <th>出版社ID</th>
    <th>出版社</th>
    <th>操作</th>
   </tr>
   <c:forEach var="publisher" items="${publishers }">
      <tr>
	    <td>
	     <input type="checkbox"/>
	     <span>${publisher.getId() }</span>
	    </td>
	    <td class="center">${publisher.getName() }</td>
	    <td class="center"><a class="block" href="/Bookstore/Man/PublishersMan?flagType=delete&id=${publisher.getId() }" title="移除"><img src="${pageContext.request.contextPath}/admin/images/icon_trash.gif"/></a></td>
	  </tr>
   </c:forEach>
  </table>
  
  <!-- BatchOperation -->
  <div style="overflow:hidden;">
      <!-- Operation -->
	  <div class="BatchOperation fl">
	   <input type="checkbox" id="del"/>
	   <label for="del" class="btnStyle middle">全选</label>
	   <input type="button" value="批量删除" class="btnStyle"/>
	  </div>
	  <!-- turn page -->
	  <div class="turnPage center fr">
	   <a>第一页</a>
	   <a>1</a>
	   <a>最后一页</a>
	  </div>
  </div>
 </div>
</body>
</html>