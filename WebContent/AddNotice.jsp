<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>发布通知</title>
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
			%>
			<jsp:include page="top.jsp"></jsp:include>
			<% 
		}
	%>
<div class="col-md-8 col-md-offset-2">
	
		<div class="panel panel-default">
			<!-- 标题 -->
			<div class="panel-heading">
				<h3 class="panel-title">发布通知</h3>
			</div>

			<div class="panel-body">

				<div class="panel-body">
	<form role="form" method="post" action="NoticeServlet?type=add">
	<div class="form-group">
		<label for="name">通知标题</label>
		
		<textarea class="form-control" rows="2" name="notice_title" id="notice_title"></textarea>
		<br>
		<label for="name">通知内容</label>
		<textarea class="form-control" rows="7" name="notice_content" id="notice_content"></textarea>
		
	</div>
	<div align="center">
								<button type="submit" class="btn btn-primary">发布</button>

								<button type="reset" class="btn btn-warning">清空</button>
		</div>
</form>
</div></div></div></div>



</body>
</html>