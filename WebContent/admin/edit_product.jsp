<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>图书列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${pageContext.request.contextPath}/admin/style/adminStyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i class="add"></i><em>编辑/添加图书</em></span>
    <span class="modular fr"><a href="${pageContext.request.contextPath}/admin/product_list.jsp" class="pt-link-btn">图书列表</a></span>
  </div>
  <form action="/Bookstore/Man/BooksUpdata?id=${id }" method="post">
  <table class="list-style">
   <tr>
    <td style="text-align:right;width:15%;">图书名称：</td>
    <td><input type="text" name="Title" class="textBox length-long" value="${book.getTitle() }"/></td>
   </tr> 
    <tr>
    <td style="text-align:right;width:15%;">ISBN：</td>
    <td><input name="ISBN" type="text" value="${book.getISBN() }" class="textBox length-long"/></td>
   </tr>
   <tr>
    <td style="text-align:right;">图书分类：</td>
    <td>
     <select class="textBox" name="CategoryId">
     <c:forEach var="categorie" items="${categories }">
     	<c:if test="true">
     		 <option value="${categorie.getId() }" selected="${categorie.getName() }">${categorie.getName() }</option>
     	</c:if>
     	<c:if test="${categorie.getId()!=book.getCategoryId() }">
     	     <option value="${categorie.getId() }" >${categorie.getName() }</option>
     	</c:if>
     </c:forEach>
     </select>
    </td>
   </tr>
   <tr>
    <td style="text-align:right;">出版社：</td>
    <td>
     <select class="textBox" name="PublisherId">
     <c:forEach var="publisher" items="${publishers }">
     	<c:if test="${publisher.getId()==book.getPublisherId() }">
     		 <option value="${publisher.getId() }" selected="${publisher.getName() }">${publisher.getName() }</option>
     	</c:if>
     	<c:if test="${publisher.getId()!=book.getPublisherId() }">
     	     <option value="${publisher.getId() }" >${publisher.getName() }</option>
     	</c:if>
     </c:forEach>
     </select>
    </td>
   </tr>
    <tr>
    <td style="text-align:right;">出版日期：</td>
    <td>
     <input type="text" name="PublishDate" value="${book.getPublishDate() }" class="textBox length-short"/>
     <span>例如：2017/10/10</span>
    </td>
   </tr>
    <tr>
    <td style="text-align:right;width:15%;">作者：</td>
    <td><input name="Author" type="text" value="${book.getAuthor() }" class="textBox length-long"/></td>
   </tr>

   <tr>
    <td style="text-align:right;">作者简介：</td>
    <td><textarea class="textarea" name="AurhorDescription">${book.getAurhorDescription() }</textarea></td>
   </tr>
   <tr>
    <td style="text-align:right;">作品详情：</td>
    <td><textarea class="textarea" name="ContentDescription">${book.getContentDescription() }</textarea></td>
   </tr>


   <tr>
    <td style="text-align:right;">评论详情：</td>
    <td><textarea class="textarea" name="EditorComment">${book.getEditorComment() }</textarea></td>
   </tr>

   <tr>
    <td style="text-align:right;">章节详情：</td>
    <td><textarea class="textarea" name="TOC">${book.getTOC() }</textarea></td>
   </tr>




   <tr>
    <td style="text-align:right;">字数：</td>
    <td>
     <input type="text" name="WordsCount" value="${book.getWordsCount() }" class="textBox length-short"/>
     <span>字</span>
    </td>
   </tr>
   <tr>
    <td style="text-align:right;">库存：</td>
    <td>
     <input type="text" name="Repertory" value="${book.getRepertory() }" class="textBox length-short"/>
     <span>册</span>
    </td>
   </tr>
    <tr>
    <td style="text-align:right;">价格：</td>
    <td>
     <input type="text" name="UnitPrice" value="${book.getUnitPrice() }" class="textBox length-short"/>
     <span>元</span>
    </td>
   </tr>
<!--    <tr>
    <td style="text-align:right;">产品缩图片：</td>
    <td>
     <input type="file" id="suoluetu" class="hide"/>
     <label for="suoluetu" class="labelBtnAdd">+</label>
     <img src="#" width="60" height="60" class="mlr5"/>
    </td>
   </tr>
    -->
<!--    <tr>
    <td style="text-align:right;">产品主图：</td>
    <td>
     <input type="file"  multiple="multiple" id="chanpinzhutu" class="hide"/>
     <label for="chanpinzhutu" class="labelBtn2">本地上传(最多选择N张)</label>
    </td>
   </tr>
   <tr>
    <td style="text-align:right;"></td>
    <td>
     <img src="#" width="80" height="80"/>
     <img src="#" width="80" height="80"/>
     <img src="#" width="80" height="80"/>
     <img src="#" width="80" height="80"/>
     <img src="#" width="80" height="80"/>
    </td>
   </tr>
    -->

   <tr>
    <td style="text-align:right;"></td>
    <td><input type="submit" value="提交" class="tdBtn"/></td>
   </tr>
  </table>
  </form>
 </div>
</body>
</html>