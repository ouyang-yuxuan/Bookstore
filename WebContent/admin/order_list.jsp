<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>订单列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${pageContext.request.contextPath}/admin/style/adminStyle.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/admin/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/admin/js/public.js"></script>
</head>
<body>
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i class="order"></i><em>订单列表</em></span>
  </div>
  <div class="operate">
   <form>
    <img src="${pageContext.request.contextPath}/admin/images/icon_search.gif"/>
    <input type="text" class="textBox length-long" placeholder="输入订单编号或收件人姓名..."/>
    <select class="inline-select">
     <option>未付款</option>
     <option>已付款</option>
    </select>
    <input type="button" value="查询" class="tdBtn"/>
   </form>
  </div>
  <table class="list-style Interlaced">
   <tr>
    <th>订单ID</th>
    <th>订单编号</th>
    <th>下单时间</th>
    <th>收件人</th>
    <th>订单金额</th>
    <th>订单状态</th>
    <th>操作</th>
   </tr>
   <c:forEach var="order" items="${orders }">
   		   <tr>
		    <td>
		     <input type="checkbox"/>
		     <a href="order_detail.jsp">${order.getId() }</a>
		    </td>
		    <td>
		     <a href="order_detail.jsp">${order.getOrdernumber() }</a>
		    </td>
		    <td class="center">
		     <span class="block">${userDao.queryUserById(order.getUserId()).getLoginId()}</span>
		     <span class="block">${order.getOrderDate() }</span>
		    </td>
		    <td width="450">
		     <span class="block">${userDao.queryUserById(order.getUserId()).getName()} [${userDao.queryUserById(order.getUserId()).getPhone()}]</span>
		     <address>${userDao.queryUserById(order.getUserId()).getAddress()}</address>
		    </td>
		    <td class="center">
		     <span><i>￥</i><b>${order.getTotalPrice() }</b></span>
		    </td>
		    <td class="center">
		     <span>
		     	${order.getOrderStatus()==0?"未付款":"已付款"}
		    </span>
		    </td>
		    <td class="center">
		     <a href="${pageContext.request.contextPath}/admin/order_detail.jsp" class="inline-block" title="查看订单"><img src="${pageContext.request.contextPath}/admin/images/icon_view.gif"/></a>
		     <a href="/Bookstore/Man/OrdersUpdata?id=${order.getId() }" title="编辑"><img src="${pageContext.request.contextPath}/admin/images/icon_edit.gif"/></a>
		     <a href="/Bookstore/Man/OrdersMan?id=${order.getId() }&flagType=delete" class="inline-block" title="删除订单"><img src="${pageContext.request.contextPath}/admin/images/icon_trash.gif"/></a>
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
	   <input type="button" value="打印订单" class="btnStyle"/>
	   <input type="button" value="配货" class="btnStyle"/>
	   <input type="button" value="删除订单" class="btnStyle"/>
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