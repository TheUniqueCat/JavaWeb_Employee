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
<title>查看信息</title>
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
	%>
	<div>
	<div class="col-md-8 col-md-offset-2">
	
		<div class="panel panel-default">
			<!-- 标题 -->
			<div class="panel-heading"><h3 class="panel-title">查看个人信息</h3></div>
			

			<div class="panel-body">

				<div class="panel-body">
					<!-- 表单 -->
					<form action="ResumeBasicinfoServlet?type=add" method="post" class="form-horizontal">
					 <%
					 	int applicantID = (int)request.getSession().getAttribute("applicantID");
					 	ResumeDAO resume = new ResumeDAO();
					 	ResumeBasicinfo re = resume.select(applicantID);
					 	if(re == null){
					 		System.out.println("该用户还未添加自己的信息以及简历");
							out.println("<script type = 'text/javascript'>");
							out.println("alert('该用户还未添加自己的信息以及简历！')");
							out.println("window.location = 'All_ResumeServlet';");
							out.println("</script>");
					 	}else{
					 		
					 	
					 	System.out.println(re);
					%>
					
						<div class="form-group col-sm-8">
							<label>姓名：<%=re.getName()	%></label>
						</div>
						
						<div class="form-group col-sm-8">
							<label>电话：<%=re.getPhone()	%></label>
						</div>
						
						<div class="form-group col-sm-8">
							<label>Email：<%=re.getEmail()	%></label>
						</div>
						
						<div class="form-group col-sm-8">
							<label>性别：<%	if(re.getSex().equals("male")){
										out.print("男");
									}else{
										out.print("女");
									}%></label>
						</div>
						<%
					 	}
						%>
						<p><img src="./images/person_img.jpg" class="img-rounded"></p>
						
						<div class="form-group col-sm-8" align="center">
							<a href="UpdateResume.jsp?id2=<%=applicantID %>" class="btn btn-primary" role="button">修改信息</a>
							<%
								InfoDAO dao = new InfoDAO();
							InfoBasicinfo info = dao.select(applicantID);
							if(info != null){
							%>
								<a href="InfoBasicinfoServlet?type=select&&id2=<%=applicantID %>" class="btn btn-warning" role="button">查看简历</a>
							<%
							}
							%>
						</div>
					</form>

				
				</div>
			</div>
		</div>
		
		</div>
		
	</div>
	
</body>
</html>







