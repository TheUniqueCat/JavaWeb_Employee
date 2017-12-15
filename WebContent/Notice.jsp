<%@page import="com.notice.NoticeDAO"%>
<%@page import="com.notice.Notice"%>
<%@page import="com.admin.User"%>
<%@page import="com.task4.Applicant"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>查看所有通知</title>
<link rel=stylesheet href="css/bootstrap/css/bootstrap.css">
<link href="css/base.css" type="text/css" rel="stylesheet" />
<link href="css/resume.css" type="text/css" rel="stylesheet" />
<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="/scripts/jquery.min.js"></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%
		
		String email_id = (String)request.getSession().getAttribute("email");
		if("903283542@qq.com".equals(email_id) ){
			%>
			<jsp:include page="AdminTop.jsp"></jsp:include>
			<%
		}else{
			%><jsp:include page="top.jsp"></jsp:include>
			<% 
		}
		int num = 0;
	%>
	<div  class="row login-box">
       <div class="col-md-10 col-md-offset-1">
            <div class='panel panel-primary'>
                 <div class="panel-heading">查看通知 </div>
                 <table class="table table-hover table-bordered" contenteditable="true">
                   <thead>
                     <tr>
                     	<th width="5%">序号</th>
                     	<th width="20%">发布时间</th>
                     	<th width="60%">标题</th>
                       <th width="15%">操作</th>
                     </tr>
                   </thead>
                   <tbody>
                   <%
                   		List<Notice> list = (List<Notice>)request.getSession().getAttribute("no_list");
                   		for(Notice no : list){
                   %>
                     <tr>
                     <td><%=++num	%></td>
                     <td><%=no.getNotice_date()	%></td>
                     <td><%=no.getNotice_title() %></td>
                       <td>
                       		<a href="NoticeServlet?type=view&&notice_id=<%=no.getNotice_id() %>" class="btn btn-info btn-xs" role="button">查看通知</a>
                       		<%
                       		if("903283542@qq.com".equals(email_id) ){
                       			%><a href="NoticeServlet?type=delect&&Notice_id=<%=no.getNotice_id() %>" class="btn btn-danger btn-xs" role="button">删除通知</a>
                       			<%}
                       		} %>
                       </td>
                     </tr>
                
                   </tbody>
                 </table>
				
            </div>
            <br>
       </div>
   </div>

</body>
</html>