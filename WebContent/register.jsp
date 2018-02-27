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
<script type="text/javascript" src="js/register.js"></script>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

</head>
<body>
<div id="templatemo_container">
		<%@ include file="header.jsp" %><!-- end of menu -->
    
    <!--start-login-form-->
				<div class="main">
			    	<div class="login-head">
					    <h1 style="color:#969547;">Elegant Login forms</h1>
					</div>
					<div  class="wrap">
						  <div class="Regisration" style="background:#4D3315">
						  	<div class="Regisration-head">
						    	<h2><span></span>Register</h2>
						 	 </div>
						  	<form action="/Bookstore/Register" method="post" name="myform">
						  		<input type="text" id="LoginId" name="LoginId" value="User Name" onfocus="this.value = '';" onblur="Ch_LoginId(this)" />
						  		<input type="text" id="Name" name="Name" value="Real Name" onfocus="this.value = '';" onblur="Ch_Name(this)" >
						  		<input type="text" id="Address" name="Address" value="Address" onfocus="this.value = '';" onblur="Ch_Address(this)" />
						  		<input type="text" id="Phone"  name="Phone" value="Phone" onfocus="this.value = '';" onblur="Ch_Phone(this)" />
						  		<input type="text" id="Mail"name="Mail" value="Email Address" onfocus="this.value = '';" onblur="Ch_Mail(this)" />
								<input type="password" id="LoginPwd"name="LoginPwd" value="Password" onfocus="this.value = '';" onblur="Ch_LoginPwd(this)" />
								<input type="password" id="reLoginPwd" name="reLoginPwd" value=" Confirm Password" onfocus="this.value = '';" onblur="Ch_reLoginPwd(this)" />
								 <div class="Remember-me">
								<div class="p-container">
								<label class="checkbox"><input type="checkbox" name="checkbox" checked><i></i>I agree to the Terms and Conditions</label>
								<div class ="clear"></div>
							</div>
								<div class="submit">
									<input type="button" onclick="repass(this.form)" value="Sign Me Up >" >
								</div>
									<div class="clear"> </div>
								</div>
											
						  </form>
					</div>
					</div>
			</div>
		    <div id="templatemo_footer">
		       Copyright © 2024
			</div> <!-- end of footer -->
				<!--//End-login-form-->	
</div> 
<!-- end of container -->

</body>
</html>