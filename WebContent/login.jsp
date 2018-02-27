<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Book Store Template, Free CSS Template, cssMoban.com</title>
<meta name="keywords" content="Book Store Template, Free CSS Template, CSS Website Layout, CSS, HTML, cssMoban.com" />
<meta name="description" content="Book Store Template, Free CSS Template, Download CSS Website from cssMoban.com" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<link href="css/style2.css" rel="stylesheet" type="text/css" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
</head>
<body>
<div id="templatemo_container">
		<%@ include file="header.jsp" %><!-- end of menu -->
    
    <!--start-login-form-->
				<div class="main">
			    	<div class="login-head">
					    <h1 style="color:#969547;">Elegant Register forms</h1>
					</div>
					<div  class="wrap">
						 
					<div class="Login" style="width:60%;background:#4D3315">
							<div class="Login-head">
						    	<h3>LOGIN</h3>
						 	</div>

						<form action="/Bookstore/UserLogin" method="post">
								<div class="ticker">
									<h4>Username</h4>
						  			<input type="text" value="John Smith" name="LoginId" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'John Smith';}" /><span> </span>
						  			<div class="clear"> </div>
						  		</div>
						  		<div>
						  		<h4>Username</h4>
								<input type="password" value="Password" name="LoginPwd" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}" />
								  			<div class="clear"> </div>
								</div>
								<div class="checkbox-grid">
									<div class="inline-group green">
									<label class="radio"><input type="radio" name="radio-inline"/><i> </i>Remember me</label>
									<div class="clear"> </div>
									</div>

								</div>
												 
								<div class="submit-button">
									<input type="submit" onclick="myFunction()" value="LOGIN  >" />
								</div>
									<div class="clear"> </div>
								</div>
											
						  </form>
					</div>
			</div>
				<!--//End-login-form-->	
				    <div id="templatemo_footer">
					       Copyright © 2024
					</div> <!-- end of footer -->
</div> <!-- end of container -->
</body>
</html>