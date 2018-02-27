<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>会员列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${pageContext.request.contextPath}/admin/style/adminStyle.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/admin/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/admin/js/public.js"></script>
</head>
<body>
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i class="user"></i><em>会员列表</em></span>
    <span class="modular fr"><a href="${pageContext.request.contextPath}/admin/add_user.jsp" class="pt-link-btn">+添加新会员</a></span>
  </div>
  <div class="operate">
   <form action="/Bookstore/Man/UserMan">
    <input type="text" class="textBox length-long" name="LoginId" placeholder="输入会员昵称、姓名、手机号码..."/>
    <input type="submit" value="查询" class="tdBtn"/>
   </form>
  </div>
  <table class="list-style Interlaced">
   <tr>
     <th>ID编号</th>
     <th>真实名字</th>
     <th>会员昵称</th>
     <th>邮件地址</th>
     <th>手机号码</th>
     <th>居住地址</th>
     <th>创建日期</th>
     <th>操作</th>
   </tr>
   <c:forEach var="user" items="${users }">
   	<tr>
    <td>
     <input type="checkbox"/>
     <span class="middle">${user.getId() }</span>
    </td>
    <td class="center">${user.getName()}</td>
    <td class="center">${user.getLoginId() }</td>
    <td class="center">${user.getMail() }</td>
    <td class="center">${user.getPhone() }</td>
    <td class="center">${user.getAddress() }</td>
    <td class="center">${user.getCreateDate()}</td>
    <td class="center">
     <a href="/Bookstore/Man/UserUpdateAndDelete?id=${user.getId() }" class="inline-block" title="编辑"><img src="${pageContext.request.contextPath}/admin/images/icon_edit.gif"/></a>
     <a class="inline-block" title="删除" href="/Bookstore/Man/UserUpdateAndDelete?id=${user.getId() }&delete=yes"><img src="${pageContext.request.contextPath}/admin/images/icon_drop.gif"/></a>
    </td>
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