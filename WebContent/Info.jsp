<%@page import="com.task4.Applicant"%>
<%@page import="com.task2.ApplicantDAO"%>
<%@page import="com.info.*"%>
<%@page import="com.task3.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="css/bootstrap/css/bootstrap.css">
<title>查看简历</title>
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
				<h3 class="panel-title">查看简历信息</h3>
			</div>

			<div class="panel-body">

				<div class="panel-body">
					<!-- 表单 -->
					<form action="ResumeBasicinfoServlet?type=add" method="post" class="form-horizontal">
						
 					<%	
 						int applicantID = (int)request.getSession().getAttribute("applicantID");
 						request.getSession().setAttribute("id2", applicantID);
					 	int id2 = Integer.valueOf(request.getSession().getAttribute("id2").toString());
 						System.out.println("查询的id是："+id2);
 						
					 	InfoDAO dao = new InfoDAO();
					 	InfoBasicinfo info = dao.select(id2);
					 	
					 	ResumeDAO resume = new ResumeDAO();
					 	ResumeBasicinfo re = resume.select(id2);
					 	if(info == null){
					 		System.out.println("该用户还未添加自己的简历");
							out.println("<script type = 'text/javascript'>");
							out.println("alert('该用户还未添加自己的简历！')");
							System.out.println(request.getSession().getAttribute("email"));
							
								%>
								window.location = "ResumeBasicinfoServlet?type=select && id=<%=id2 %>";
								<%
							
							
							out.println("</script>");
					 		
					 	}else{
					 		
					 
					 	System.out.println("个人信息"+re);
					 	System.out.println("个人简历信息："+info);
 					
					%>
						
						
						
						<div class="form-group col-sm-8">
							<label>姓名：<%=re.getName() %></label>
						</div>
						
						<div class="form-group col-sm-8">
							<label>电话：<%=re.getPhone() %></label>
						</div>
						
						<div class="form-group col-sm-8">
							<label>Email：<%=re.getEmail() %></label>
						</div>
						
						<div class="form-group col-sm-8">
							<label>性别：<%	String	sex = re.getSex();
							if(sex.equals("male")){
								out.print("男");
							}else{
								out.print("女");
							}
							 %>
							 </label>
						</div>
						
						<div class="form-group col-sm-8">
							<label>年龄：<%=info.getAge() %></label>
						</div>
						
						<div class="form-group col-sm-8">
							<label>意向工作：<%=info.getJob() %></label>
						</div>
						
						<div class="form-group col-sm-8">
							<label>工作经验：<%=info.getExperience() %></label>
						</div>
						
						<p><img src="images/person_img.jpg" class="img-rounded"></p>
						<%
						}
						%>
						<div class="form-group col-sm-8">
							<a href="UpdateInfo.jsp?id=${id2 }" class="btn btn-primary" role="button">修改简历</a>
						</div>			
					</form>
				</div>
			</div>
		</div>
		
		</div>
		
	</div>
	
	
	
	
		

</body>
</html>