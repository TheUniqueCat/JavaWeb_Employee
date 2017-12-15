<%@page import="com.task4.Applicant"%>
<%@page import="com.task3.*"%>
<%@page import="com.task2.ApplicantDAO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="css/bootstrap/css/bootstrap.css">
<title>修改基本信息</title>
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
			<div class="panel-heading">
				<h3 class="panel-title">修改基本信息</h3>
			</div>

			<div class="panel-body">

				<div class="panel-body">
					<!-- 表单 -->
					<form action="ResumeBasicinfoServlet?type=update" method="post" class="form-horizontal">
					
					<%
						int applicantID = Integer.valueOf(request.getParameter("id2"));
						ResumeDAO dao = new ResumeDAO();
						ResumeBasicinfo re = dao.select(applicantID);
					
					
					%>
					
					
					
					
					
						<div class="form-group">
							<div class="col-sm-8">
								<label>姓名:</label> <input type="text" class="form-control"
									name="name" id="name" placeholder="请输入姓名" value=<%=re.getName() %>>
							</div>
						</div>



						<div class="form-group">
							<div class="col-sm-8">
								<label>电话:</label> <input type="text" class="form-control"
									name="phone" id="phone" placeholder="请输入电话号码" value=<%=re.getPhone() %>>
							</div>


						</div>


						<div class="form-group">
							<div class="col-sm-8">
								<label>邮箱:</label> <input type="text" class="form-control"
									name="email" id="email" placeholder="请输入邮箱" value=<%=re.getEmail() %>>
							</div>

						</div>

						<div class="form-group">
						<div class="col-sm-8"><label>性别:</label><br> 
						<%
							String sex = re.getSex();
							if("male".equals(sex)){
								%>
								<label class="radio-inline"><input type="radio" name="sex" value="male" checked="checked">男
								</label> <label class="radio-inline"> <input type="radio"
									name="sex" value="female">女
								</label>
								<%
							}else{
								%>
								<label class="radio-inline"><input type="radio" name="sex" value="male">男
								</label> <label class="radio-inline"> <input type="radio"
									name="sex" value="female"  checked="checked">女
								</label>
								
								<%
								
							}
						%>
							
								
								
							</div>
						</div>

						<!-- 修改照片 -->
						<!-- <div class="col-sm-8">
							<p><img src="images/person_img.jpg" class="img-rounded"></p>
								<div>
									<a href="resumeBasicInfoPicUpload.html">更换照片</a>
								</div>
						
						</div> -->
						<div class="form-group">
							<div class="col-sm-offset-3 col-sm-10">
								<button type="submit" class="btn btn-primary">修改</button>
								<button type="reset" class="btn btn-warning">重置</button>
							</div>
						</div>
					</form>


				</div>
			</div>
		</div>
		
		</div>
		
	</div>


</body>
</html>