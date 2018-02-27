<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>新增图书分类</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${pageContext.request.contextPath}/admin/style/adminStyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i></i><em>添加出版社</em></span>
  </div>
  <form action="/Bookstore/Man/PublishersMan" method="post">
    <table class="list-style">
     <tr>
      <td style="text-align:right;width:15%;">出版社：</td>
      <td>
       <input type="text" name="name" class="textBox"/>
      </td>
     </tr>
     <tr>
      <td style="text-align:right;">分出版社ID：</td>
      <td>
       <input type="text" name="id" class="textBox length-short"/>
      </td>
     </tr>
     <tr>
      <td style="text-align:right;"></td>
      <td><input type="submit" value="保存" class="tdBtn"/></td>
     </tr>
    </table>
  </form>
 
 </div>
</body>
</html>