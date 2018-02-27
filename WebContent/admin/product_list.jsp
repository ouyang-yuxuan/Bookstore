<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>图书列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${pageContext.request.contextPath}/admin/style/adminStyle.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/admin/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/admin/js/public.js"></script>
</head>
<body>
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i></i><em>图书列表</em></span>
    <span class="modular fr"><a href="/Bookstore/Man/BooksAdd" class="pt-link-btn">+添加图书</a></span>
  </div>
  <div class="operate">
   <form action="/Bookstore/Man/BooksMan?pageNo=1" method="post">
    <input type="text" class="textBox length-long" name="type" placeholder="输入图书名称/ISBN..."/>
    <input type="submit" value="查询" class="tdBtn"/>
   </form>
  </div>
  <table class="list-style Interlaced">
   <tr>
    <th>ID编号</th>
    <th>ISBN</th>
    <th>图书名字</th>
    <th>单价</th>
    <th>库存</th>
    <th>操作</th>
   </tr>
   <c:forEach var="book" items="${page.data }">
   		   <tr>
	    <td>
	     <span>
	     <input type="checkbox" class="middle children-checkbox"/>
	     <i>${book.getId() }</i>
	     </span>
	    </td>
	    <td class="center pic-area">${book.getISBN() }</td>
	    <td class="td-name">
	      <span class="ellipsis td-name block">${book.getTitle() }</span>
	    </td>
	    <td class="center">
	     <span>
	      <i>￥</i>
	      <em>${book.getUnitPrice() }</em>
	     </span>
	    </td>
	    <td class="center">
	    ${book.getRepertory() }
	    </td>
	    <td class="center">
	     <a href="/Bookstore/Man/BooksUpdata?id=${book.getId() }&flagType=display" title="查看" target="_blank"><img src="${pageContext.request.contextPath}/admin/images/icon_view.gif"/></a>
	     <a href="/Bookstore/Man/BooksUpdata?id=${book.getId() }&flagType=display" title="编辑"><img src="${pageContext.request.contextPath}/admin/images/icon_edit.gif"/></a>
	     <a title="删除" href="/Bookstore/Man/BooksMan?flagType=delete&id=${book.getId() }"><img src="${pageContext.request.contextPath}/admin/images/icon_drop.gif"/></a>
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
	  	<a>总共${page.totalPage}页 &nbsp;&nbsp;${page.pageNo}/${page.totalPage}&nbsp;&nbsp;</a>
	  		 <a href="/Bookstore/Man/BooksMan?flagType=display&pageNo=1">首页</a>
	  		 	<c:choose>
	                    <c:when test="${page.pageNo > 1}">
	                        <a href="/Bookstore/Man/BooksMan?flagType=display&pageNo=${page.pageNo-1}">上一页</a>
	                    </c:when>
	                    <c:otherwise>
	                       		<a>上一页</a>
	                    </c:otherwise>
                </c:choose>

                <c:choose>
	                    <c:when test="${page.pageNo < page.totalPage}">
	                        <a href="/Bookstore/Man/BooksMan?flagType=display&pageNo=${page.pageNo+1}">下一页</a>
	                    </c:when>
	                    <c:otherwise>
	                        	<a>下一页</a>	
	                    </c:otherwise>
                </c:choose>
                  <a href="/Bookstore/Man/BooksMan?flagType=display&pageNo=${page.totalPage}">尾页</a>
	  </div>
  </div>
 </div>
</body>
</html>