<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.*"%>
<%@page import="com.task3.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>企业通讯录</title>
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
		int num = 0;
	%>
	
	
	<div  class="row login-box">
       <div class="col-md-8 col-md-offset-2">
            <div class='panel panel-default'>
                 <div class="panel-heading">通讯录 </div>
                 <table class="table table-hover table-bordered" contenteditable="true">
                   <thead>
                     <tr>
				<th>序号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>电话</th>
			</tr>
                   </thead>
                   <tbody>
		<%
			//List<Salary> salary_list = (List<Salary>)request.getAttribute("Sal_list");
		List<ResumeBasicinfo> re_list = (List<ResumeBasicinfo>)request.getAttribute("re_list");
		 for(ResumeBasicinfo re :  re_list){
		%>
			
		
			<tr>
				<td><%=++num %></td>
				<td><%=re.getName() %></td>
				<td><%	String	sex = re.getSex();
							if(sex.equals("male")){
								out.print("男");
							}else{
								out.print("女");
							}
							 %></td>
				<td><%=re.getPhone() %></td>
				
			</tr>
			<%} %>
		
		</tbody>
                 </table>
				
            </div>
            <br>
       </div>
   </div>

</body>
</html>