<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.wsy.news,java.io.*" errorPage="../error.jsp"%>
    <jsp:useBean id="sql" class="com.wsy.selectsql" scope="page"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻查看</title>
<link href="../CSS/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div align="center">
  <p class="lunzi">新闻详细信息</p>
</div>
<%
String id=request.getParameter("id");
Collection temp=sql.selectNews(id);
Iterator it=temp.iterator();
while(it.hasNext()){
news news=(news)it.next();
 %>
<table width="500"  border="0" align="center" bordercolor="#FFFFFF" bgcolor="#CCCCCC">
  <tr bgcolor="#FFFFFF">
    <td width="190" align="center" class="lunzi">名称</td>
    <td width="300" align="center" class="lunzi">内容</td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td class="lunzi">新闻ID</td>
    <td align="center" class="zczi"><%=news.getId() %></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td class="lunzi">名称</td>
    <td align="center" class="zczi"><%=news.getTitle() %></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td class="lunzi">内容</td>
    <td align="left" class="zczi"><%=news.getContent() %></td>
  </tr>

   <tr bgcolor="#FFFFFF">
    <td class="lunzi">作者</td>
    <td align="center" class="zczi"><%=news.getAuthor() %></td>
  </tr>
    <tr bgcolor="#FFFFFF">
    <td class="lunzi">提交时间</td>
    <td align="center" class="zczi"><%=news.getSubmittime() %></td>
  </tr>
</table>
<%} %>

</body>
</html>