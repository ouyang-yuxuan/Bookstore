<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>订单详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${pageContext.request.contextPath}/admin/style/adminStyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i class="order"></i><em>订单编号：${order.getOrdernumber() }</em></span>
  </div>
    <form action="/Bookstore/Man/OrdersUpdata?id=${order.getUserId()}" method="post">
    <dl class="orderDetail">
       <dt class="order-h">订单详情</dt>

       <dd>
        <ul>
         <li>
          <span class="h-cont h-right">收件人姓名：</span>
          <input type="text" class="textBox" value="${userDao.queryUserById(order.getUserId()).getName()}" name="Name"/>
         </li>
         <li>
          <span class="h-cont h-right">联系电话：</span>
          <input type="text" class="textBox" value="${userDao.queryUserById(order.getUserId()).getPhone()}" name="Phone"/>
          </li>
         <li>
          <span class="h-cont h-right ">联系地址：</span>
          <input type="text" class="textBox length-long" value="${userDao.queryUserById(order.getUserId()).getAddress()}" name="Address"/>
          </li>
         <li>
          <span class="h-cont h-right">付款状态：</span>
          <span class="h-cont h-left">${order.getOrderStatus()==0?"未付款":"已付款"}</span>
         </li>
         <li>
          <span class="h-cont h-right">下单时间：</span>
          <span class="h-cont h-left">${order.getOrderDate() }</span>
         </li>
        </ul>
       </dd>
       <dd>
        <table class="list-style">
         <tr>
          <th>ISBN</th>
          <th>图书名称</th>
          <th>单价</th>
          <th>数量</th>
          <th>小计</th>
         </tr>
         <c:forEach var="orderbook" items="${orderbooks }">
         	     <tr>
    		      <td>${booksDao.getBook(orderbook.getBookID()).getISBN() }</td>
    		      <td>${booksDao.getBook(orderbook.getBookID()).getTitle() }</td>
    		      <td>
    		       <span>
    		        <i>￥</i>
    		        <em>${booksDao.getBook(orderbook.getBookID()).getUnitPrice() }</em>
    		       </span>
    		      </td>
    		      <td>${orderbook.getQuantity() }</td>
    		      <td>
    		       <span>
    		        <i>￥</i>
            		 <input type="hidden" value="${orderbook.getUnitPrice()}" name="UnitPrice"/>
    		        <em>${orderbook.getUnitPrice() }</em>
    		       </span>
    		      </td>
    		     </tr>
         </c:forEach>

         <tr>
          <td colspan="5">
           <div class="fr">
            <span style="font-size:15px;font-weight:bold;">
             <i>订单共计金额：￥</i>
             <input type="hidden" value="${order.getTotalPrice()}" name="TotalPrice"/>
             <b>${order.getTotalPrice() }</b>
            </span>
           </div>
          </td>
         </tr>
        </table>
       </dd>
       <dd>
          <!-- Operation -->
    	  <div class="BatchOperation">
    	   <input type="submit" value="修改订单" class="btnStyle"/>
    	   <input type="button" value="取消订单" class="btnStyle"/>
    	  </div>
       </dd>
    </dl>
  </form>
 </div>
</body>
</html>