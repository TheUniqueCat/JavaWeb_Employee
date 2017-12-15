<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>欢迎登陆</title>
<link rel="stylesheet" href="css/bootstrap/css/bootstrap.css">
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
	
	<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="col-md-8 col-md-offset-2">
			<div class="alert alert-info">
				 <button type="button" class="close" data-dismiss="alert"> ×</button>
				<h2>您好！<c:out value="${sessionScope.email }" default="游客"></c:out>，欢迎访问XXX系统</h2>
				<strong>提示!</strong> 第一次登陆本系统请点击导航栏添加自己的个人信息与简历
			</div>
			
			
	<div class="panel panel-default">
		
			<div class="carousel slide" id="carousel-314990">
				<ol class="carousel-indicators">
					<li class="active" data-slide-to="0" data-target="#carousel-314990"></li>
					<li data-slide-to="1" data-target="#carousel-314990"></li>
				</ol>
				<div class="carousel-inner">
					<div class="item active">
						<img alt="" src="images/1.jpg" />
					</div>
					<div class="item">
						<img alt="" src="images/2.jpg" />
					</div>
					
				</div> <a data-slide="prev" href="#carousel-314990" class="left carousel-control">‹</a> <a data-slide="next" href="#carousel-314990" class="right carousel-control">›</a>
			</div>
			</div></div>
		</div>
	</div>
</div>
	
	
	
	
</body>
</html>