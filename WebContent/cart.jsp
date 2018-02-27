<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.model.bookstore.*,java.util.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Book Store Template, Free CSS Template, cssMoban.com</title>
<meta name="keywords" content="Book Store Template, Free CSS Template, CSS Website Layout, CSS, HTML, cssMoban.com" />
<meta name="description" content="Book Store Template, Free CSS Template, Download CSS Website from cssMoban.com" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<link href="css/style1.css" rel="stylesheet" type="text/css" media="all"/>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
<script src="js/jquery-1.11.0.min.js"></script>
	<script>$(document).ready(function(c) {
		$('.close').on('click', function(c){
			$('.cake-top').fadeOut('slow', function(c){
		  		$('.cake-top').remove();
			});
		});	  
	});
	</script>
	
	<script>$(document).ready(function(c) {
		$('.close-btm').on('click', function(c){
			$('.cake-bottom').fadeOut('slow', function(c){
		  		$('.cake-bottom').remove();
			});
		});	  
	});
	</script>
</head>
<body>

<div id="templatemo_container">
		<%@ include file="header.jsp" %> <!-- end of menu -->
    
    <div id="templatemo_header">
    	<div id="templatemo_special_offers">
        	<p>
                <span>25%</span> discounts for
        purchase over $ 40
        	</p>
			<a href="#" style="margin-left: 50px;">Read more...</a>
        </div>
        
        
        <div id="templatemo_new_books">
        	<ul>
                <li>Suspen disse</li>
                <li>Maece nas metus</li>
                <li>In sed risus ac feli</li>
            </ul>
            <a href="#" style="margin-left: 50px;">Read more...</a>
        </div>
    </div> <!-- end of header -->
    
    <div id="templatemo_content" style="color:#969547">
    	<div class="cart" >
		   <div class="cart-top">
		   	  <div class="cart-experience">
		   	  	 <h4>Shopping Cart Experience</h4>
		   	  </div>
		   	  <div class="cart-login">
		   	  	 <div class="cart-login-img">
		   	  	 	<img src="images/loggin_man.png">
		   	  	 </div>
		   	  	 <div class="cart-login-text">
		   	  	 	<h5>Logged in as</h5>
		   	  	 </div> 
		   	  	 <div class="clear"> </div>
		   	  </div>
		   	 <div class="clear"> </div>
		   </div>
		   <div class="cart-bottom">
		   	 <div class="table">
		   	 	<table style="width:100%">
		   	 		<tbody>
		   	 	      <tr  class="main-heading">	  	      	
				 			<th>Images</th>
				 			<th class="long-txt">Product Description</th>
				 			<th>Quantity</th>
				 			<th>Price</th>
				 			<th>Total</th> 		 			 	
		   	 	     </tr>
		   	 	     	<% 
							//1:将添加到购物车里面的物品显示出来
							Map<Integer,CartItem> map=(Map<Integer,CartItem>)session.getAttribute("cart");
					   	 	    if(map==null){
					   		        //new一个购物车
					   		        map=new HashMap<>();
					   		    }
							//2:将购物车里面的内容遍历出来
							float count=0;//显示出总价格
							for(Map.Entry<Integer,CartItem> entry : map.entrySet()){
						   //计算出每一样的书籍一共花了多少钱
						   float price=entry.getValue().getBook().getUnitPrice() * entry.getValue().getNumber();    
						   //计算出一共花了多少钱
						   count=count+price;
						%>
		   	 	     <tr class="cake-top" style="height:200px">
		   	 	     	<td class="cakes">	 	     	  
		   	 	     		<div class="product-img">
		   	 	     			<img src="images/cack1.png">
		   	 	     		</div>
		   	 	        </td>
		   	 	        <td class="cake-text">
		   	 	     		<div class="product-text">

		   	 	     			<h2><%=entry.getValue().getBook().getTitle()  %></h2>
		   	 	     			<h3><%=entry.getValue().getBook().getAuthor()  %></h3>
		   	 	     			<h4>ISBN:<%=entry.getValue().getBook().getISBN()  %></h4>
		   	 	     		</div>
		 	     	    </td>
		 	     	    <td class="quantity"> 	 	     	 
		   	 	     	  <div class="product-right">
		   	 	     	  	 <input min="1" type="number" id="quantity" name="quantity" value="<%=entry.getValue().getNumber() %>" class="form-control input-small"/>				  
		   	 	     	  </div>
		   	 	     	</td>
		   	 	     	<td class="price">
		   	 	     		<h4>￥:<%=entry.getValue().getBook().getUnitPrice()  %></h4>	
		   	 	     	</td>
		   	 	     	<td class="top-remove">
		   	 	     		<h4>￥:<%=price  %></h4>
		   	 	     		<div class="close">
		   	 	     	      <h5>Remove</h5>
		   	 	            </div>
		   	 	     	</td>
		   	 	     </tr>
		   	 	      <% } %>
		   	 	   </tbody>
		   	 	</table>
		   	 </div>
		   	 <div class="vocher">
		   	 	<div class="dis-total">
		   	 		<h1 style="background:#835500">Total ￥：<%=count %></h1>
		   	 		<div class="tot-btn">
		   	 			<a class="shop" href="#">Back to Shop</a>
		   	 			<a class="check" href="/Bookstore/AddToCart">Continue to Checkout</a>
		   	 		</div>
		   	 	</div>
		   	   <div class="clear"> </div>
		   	 </div>
		   </div>
		</div>
    </div> <!-- end of content -->
    
    <div id="templatemo_footer">
	       Copyright © 2024
	       
	</div> <!-- end of footer -->
</div> <!-- end of container -->
</body>
</html>