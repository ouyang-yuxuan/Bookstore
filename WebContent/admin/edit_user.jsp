<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>编辑会员资料</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${pageContext.request.contextPath}/admin/style/adminStyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i class="edit_user"></i><em>编辑会员资料</em></span>
  </div>
  <form action="/Bookstore/Man/UserUpdateAndDelete?id=${user.getId() }" method="post">
  	<table class="list-style">
   <tr>
    <td style="width:15%;text-align:right;">真实姓名：</td>
    <td><input type="text" name="Name" class="textBox length-middle" value="${user.getName() }"/></td>
   </tr>
   <tr>
    <td style="width:15%;text-align:right;">会员昵称：</td>
    <td><input type="text" name="loginId" class="textBox length-middle" value="${user.getLoginId() }"/></td>
   </tr>
   <tr>
    <td style="text-align:right;">电子邮件：</td>
    <td><input type="text" name="mail" class="textBox length-middle" value="${user.getMail() }"/></td>
   </tr>
   <tr>
    <td style="text-align:right;">用户地址：</td>
    <td><input type="text" name="address" class="textBox length-middle" value="${user.getAddress() }"/></td>
   </tr>
   <tr>
    <td style="text-align:right;">手机号码：</td>
    <td><input type="text" name="phone" class="textBox length-middle" value="${user.getPhone() }"/></td>
   </tr>
   <tr>
    <td style="text-align:right;">重置密码：</td>
    <td><input type="password" name="loginPwd" class="textBox length-middle" value=""/></td>
   </tr>
   <tr>
    <td style="text-align:right;">确认密码：</td>
    <td><input type="password" name="reLoginPwd" class="textBox length-middle" value=""/></td>
   </tr>
   <tr>
    <td style="text-align:right;"></td>
    <td><input type="submit" class="tdBtn" value="更新保存"/></td>
   </tr>
  </table>
  </form>
  
 </div>
</body>
</html>