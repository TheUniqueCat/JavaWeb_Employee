<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理员网站头部文件</title>
<link rel=stylesheet href="css/bootstrap/css/bootstrap.css">
<link href="css/base.css" type="text/css" rel="stylesheet" />
<link href="css/resume.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<script type="text/javascript">
	function validate(){
		var search_id = document.getElementById("search_id");
		if (search_id.value == "") {
			alert("不能为空，请输入员工编号！");
			search_id.focus();
			return false;
		}
		return true;
	}
</script>
	<nav class="navbar navbar-default" role="navigation">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">欢迎来到....</a>
	</div>
	<div class="collapse navbar-collapse">
		<!--管理员已经登录 -->

		<ul class="nav navbar-nav">
			<li><a href="allIndex.jsp">首页</a></li>
			
			
			
			
			<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">通知公告 <b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="AddNotice.jsp">发布通知</a></li>
					<li class="divider"></li>
					<li><a href="NoticeServlet?type=select">查看所有通知</a></li>
			</ul></li>
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			<li><a href="./ContactServlet">通讯录</a></li>
			<li><a href="All_ResumeServlet">所有员工信息</a></li>
			<form action="All_ResumeServlet" method="post" onsubmit="return validate();" class="navbar-form navbar-left" role="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="输入员工ID搜索员工"
						name="search_id" id="search_id">
				</div>
				
				<button type="submit" class="btn btn-default">搜索</button>
			</form>
		</ul>




		<ul class="nav navbar-nav  navbar-right">
			<li><a href="#"><span class="glyphicon glyphicon-user" style="font-size: 18px;" > <%=session.getAttribute("email") %></span></a>
			</li>
			<li><a href="out.jsp"><span class="glyphicon glyphicon-send"
					style="font-size: 18px;"> 安全退出</span></a></li>
		</ul>

	</div>


	</nav>

</body>
</html>