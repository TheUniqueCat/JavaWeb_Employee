<%@page import="com.message.MessageDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.message.Message"%>
<%@page import="com.notice.NoticeDAO"%>
<%@page import="com.notice.Notice"%>
<%@page import="javax.sound.midi.MidiDevice.Info"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.task3.*"%>
<%@page import="com.info.*"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>查看通知</title>
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
		
	 	Notice no = (Notice)request.getSession().getAttribute("no_list");
	 	
	 	int applicant_id = (Integer) request.getSession().getAttribute("applicantID");
	 	System.out.println(applicant_id);
	
	%>
	<div>
	<div class="col-md-8 col-md-offset-2">
	
		<div class="panel panel-default">
			<!-- 标题 -->
			<div class="panel-heading"><h3 class="panel-title"><%=no.getNotice_title() %></h3></div>
			<div class="panel-body">
				<div class="panel-body">
					<!-- 表单 -->
					<form action="#" method="post" class="form-horizontal">
						<div class="form-group">
							<label>发布日期：<%=no.getNotice_date()	%></label><br>
							<label><h3>内容：<%=no.getNotice_content()	%></h3></label>
						</div>
						
					</form>
				</div>
				<div class="progress">
					<div class="progress-bar" style="width: 0%;"></div>
				</div>
				<div class="panel-body">
					<form action="MessageServlet?type=add&&notice_id=<%=no.getNotice_id() %>&&applicant_id=<%=applicant_id %>" method="post" class="form-horizontal">
						<div class="form-group">
							<label><%=email_id %></label><br>
							<label for="name">留言内容：</label>
								<textarea class="form-control" rows="3" name="message_content" id="message_content"  placeholder="请在次输入你要留言的内容"></textarea>
						</div>
						
						<div class="form-group" align="center">
							<input class="btn btn-default" type="submit" value="提交">
							<input class="btn btn-default" type="reset" value="清空">
						</div>
					</form>
				</div>
				<div class="progress">
					<div class="progress-bar" style="width: 0%;"></div>
				</div>
				<table class="table table-condensed">
	<thead>
	
		<tr>
			<th width="10%">留言人</th>
			<th width="80%">内容</th>
			<th width="10%"> </th>
		</tr>
	</thead>
	<tbody>
<%		List<Message> message = (List<Message>)request.getSession().getAttribute("me_list");
		for(Message me : message){
			ResumeDAO redao = new ResumeDAO();
			ResumeBasicinfo re =  redao.select(me.getApplicant_id());
			%><tr>
			<td><%=re.getName() %></td>
			<td><%=me.getMessage_content() %></td>
			<td>
			<%
				if("903283542@qq.com".equals(email_id) ){
					%><a href="MessageServlet?type=delect&&notice_id=<%=no.getNotice_id() %>&&message_id=<%=me.getMessage_id() %>" class="btn btn-danger btn-xs" role="button">删除留言</a><%
				}else{
					%><a href="#" class="btn btn-danger btn-xs disabled" role="button">删除留言</a><%
				}%>
			</td></tr><%}%></tbody>
	</table>
</div>
</div>
</div>
</div>
	
</body>
</html>