<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理员登录界面</title>
<link rel=stylesheet href="css/bootstrap/css/bootstrap.css">

<script type="text/javascript">
	function validate() {
		var email = document.getElementById("email");
		var password = document.getElementById("password");
		if (email.value == "") {
			alert("邮箱不能为空！");
			email.focus();
			return false;
		}
		if (password.value == "") {
			alert("密码不能为空！");
			password.focus();
			return false;
		}
		if(email.value != "903283542@qq.com"){
			alert("您还不是管理员，请切换到普通员工登录！");
			email.focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<%
		String applicantEmail = "";
		String applicantPwd = "";

		//获取cookie
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("COOKIE_APPLICANTEMAIL")) {
					applicantEmail = cookie.getValue();
				}
				if (cookie.getName().equals("COOKIE_APPLICANTPWD")) {
					applicantPwd = cookie.getValue();
				}
			} //for
		} //if
	%>
	
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
	%>
	
	<!-- 登录 -->
	<div class="row login-box">
		<div class="col-md-4 col-md-offset-4">
			<div class="panel panel-primary">

				<div class="panel-heading" align="center">登录</div>

				<div class="panel-body">

					<form action="ApplicantLoginServlet" method="post"
						onsubmit="return validate();">

						<div class="form-group">
							<label>管理员账号:</label> <input type="text" class="form-control"
								name="email" id="email" value="<%=applicantEmail%>">
						</div>
						<div class="form-group">
							<label>密&nbsp;码:</label> <input type="password" class="form-control"
								name="password" id="password" value="<%=applicantPwd%>">
						</div>
						<div class="form-group">
							<span> <label class="checkbox-inline"> <input checked="checked"
									type="checkbox" name="rememberMe" value="true">记住密码？
							</label>
							</span>
						</div>

						<div class="form-group">
							<div class="col-md-4 col-md-offset-3">
								<input type="submit" class="btn btn-primary" name="" value="登录">
							</div>
							<div>
								<input type="reset" class="btn btn-warning" name="" value="重置">
							</div>

						</div>
					</form>
					<div class="form-group">
						<p align="center">
							 <a href="login.jsp">员工登录</a><br><b>还没有账号？</b><a href="register.jsp">立即注册</a>
						</p>
					</div>
			</div>
		</div>
		</div>
	</div>
</body>
</html>