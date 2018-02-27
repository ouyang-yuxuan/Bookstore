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
                <span>25%</span> discounts for purchase over $ 40
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
    
    <div id="templatemo_content" style="color:#969547;text-align: center;">
    	<div class="cart" >
		   <div class="cart-top">
		   	  <div class="cart-experience">
		   	  	 <h4>My Oreder</h4>
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
				 			<th>Ordernumber</th>
				 			<th class="long-txt">OrderDate</th>
				 			<th>UserId</th>
				 			<th>TotalPrice</th>
				 			<th>OrderStatus</th> 		 			 	
		   	 	     </tr>
					<c:forEach var="order" items="${orders }">
						<tr class="cake-top" style="height:50px">
			   	 	     	<td class="cakes">${order.getOrdernumber() }</td>
			   	 	        <td class="cakes">${order.getOrderDate() }</td>
			 	     	    <td class="cakes">${order.getUserId() }</td>
			   	 	     	<td class="cakes">${order.getTotalPrice() }</td>
			   	 	     	<td class="cakes">${order.getOrderStatus() }</td>
			   	 	     </tr>
					</c:forEach>
		   	 	     
		   	 	   </tbody>
		   	 	</table>
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