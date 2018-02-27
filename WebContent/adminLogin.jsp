<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>后台管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="robots" content="nofollow"/>
<link href="${pageContext.request.contextPath}/css/adminStyle.css" rel="stylesheet" type="text/css" />
<style>
body{width:100%;height:100%;overflow:hidden;background:url(images/pc_loginBg.jpg) no-repeat;background-size:cover;position:absolute;}
</style>
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/Particleground.js"></script>
<script>
$(document).ready(function() {
  $('body').particleground({
    dotColor:'green',
    lineColor:'#c9ec6e'
  });
  $('.intro').css({
    'margin-top': -($('.intro').height() /2)
  });
});
</script>

</head>
<body>
  <div class="loginform">
   <h1>后台管理系统</h1>
   <form action="/Bookstore/Login" method="post">
    <ul>
    <li>
     <label>账号：</label>
     <input type="text" name="LoginId" class="textBox" placeholder="管理员账号"/>
    </li>
    <li>
     <label>密码：</label>
     <input type="password" name="LoginPwd" class="textBox" placeholder="登陆密码"/>
    </li>
    <li>
     <input type="submit" type="button" value="立即登陆"/>
    </li>
   </ul>
   </form>
  </div>
</body>
</html>