<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
<%@page import="com.salary.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>我的工资</title>
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
<script type="text/javascript">
	function validate(){
		var search_id = document.getElementById("search_id");
		if (search_id.value == "") {
			alert("不能为空，请输入正确的数字！");
			search_id.focus();
			return false;
		}
		return true;
	}
</script>

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


<div class="container-fluid">

<div class="table-responsive">
	<table class="table table-hover table-bordered" contenteditable="true">
	<%
	float sum_Post_salary = 0;
	 float sum_Attendance_salary = 0;
	 float sum_Bonus = 0;
	 float sum_Total_salary = 0;
	 
	 if(!"903283542@qq.com".equals(email_id) ){
		 %>
		 <div class="panel panel-default">
    <div class="panel-body"><label>搜索当前月份工资：</label></div>
    <form action="SalaryServlet?type=select" method="post">
	<div class="form-group col-sm-4">
		<p><select class="form-control" name="salary_date">
			<option value = "2017/01" selected="selected">2017年01月</option>
			<option value = "2017/02">2017年02月</option>
			<option value = "2017/03">2017年03月</option>
			<option value = "2017/04">2017年04月</option>
			<option value = "2017/05">2017年05月</option>
			<option value = "2017/06">2017年06月</option>
			<option value = "2017/07">2017年07月</option>
			<option value = "2017/08">2017年08月</option>
			<option value = "2017/09">2017年09月</option>
			<option value = "2017/10">2017年10月</option>
			<option value = "2017/11">2017年11月</option>
			<option value = "2017/12">2017年12月</option>
			</select>
	</div>
	<input type="submit" value="搜索" class="btn btn-danger">
	</p>
	
	</form>
</div>
		 <% 
	 }
	%>
	
	
	
	
	
	
		<caption>工资明细</caption>
		<thead>
			<tr>
				
				<th>时间</th>
				<th>应发工资</th>
				<th>考勤</th>
				<th>奖金</th>
				<th>实发工资</th>
			</tr>
		</thead>
		<tbody>
			<%		
			if(request.getAttribute("salary_date") == null){
				//查询全部的工资
				List<Salary> salary_list = (List<Salary>)request.getAttribute("Sal_list");
                for(Salary sal :  salary_list)
                {
                 %>
		
			<tr>
				<td><%=sal.getDate()	 %></td><td><%=sal.getPost_salary()	 %></td><td><%=sal.getAttendance_salary()	 %></td>
				<td><%=sal.getBonus()	%></td><td style="color: red"><%=sal.getPost_salary()+sal.getAttendance_salary()+sal.getBonus()	%></td>
			</tr>
			
			<%
			sum_Post_salary += sal.getPost_salary();
			sum_Attendance_salary += sal.getAttendance_salary();
			sum_Bonus += sal.getBonus();
			sum_Total_salary += (sal.getPost_salary()+sal.getAttendance_salary()+sal.getBonus());
                     } %>
		</tbody>
		
<table class="table table-hover table-bordered" contenteditable="true">
	<caption>全年工资统计</caption>
	<thead>
		<tr>
			<th>时间</th>
			<th>应发工资</th>
			<th>考勤</th>
			<th>奖金</th>
			<th>实发工资</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>2017年</td>
			<td><%=sum_Post_salary %></td>
			<td><%=sum_Attendance_salary %></td>
			<td><%=sum_Bonus %></td>
			<td><%=sum_Total_salary %></td>
			
		</tr>
		
	</tbody>
</table>

		<%
			}else{
        	//查询一个月的工资
        	Salary s = (Salary)request.getAttribute("Sal_list");
        	%>
        	<tr>
				<td><%=s.getDate()	%></td><td><%=s.getPost_salary()	 %></td><td><%=s.getAttendance_salary()	 %></td>
				<td><%=s.getBonus()	%></td><td style="color: red"><%=s.getPost_salary()+s.getAttendance_salary()+s.getBonus()	%></td>
			</tr>
        	<%
        	
        }
		%>
		
		</table>
</div> 


</div>




</body>
</html>