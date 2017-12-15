<%@page import="com.task3.*"%>
<%@page import="com.task2.ApplicantDAO"%>
<%@page import="com.task4.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加简历界面</title>
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
				<h3 class="panel-title">添加简历</h3>
			</div>

			<div class="panel-body">

				<div class="panel-body">
					<!-- 表单 -->
					<form action="InfoBasicinfoServlet?type=add" method="post" class="form-horizontal">
						<%
						int applicantID = (int)request.getSession().getAttribute("applicantID");
						ResumeDAO dao = new ResumeDAO();
						ResumeBasicinfo re = dao.select(applicantID);
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
							 %></label>
						</div>
					
				

						<div class="form-group col-sm-8">
								<label>年龄： </label><input type="text" class="form-control"
									name="age" id="age" placeholder="请输入您的年龄">
						</div>
						
						<div class="form-group col-sm-8">
							<label for="name">意向工作：</label>
							<div>
								<label class="checkbox-inline"><input name="job" type="radio" value="C ">	C语言开发</label>
								<label class="checkbox-inline"><input name="job" type="radio" value="Android ">	Android开发</label>
								<label class="checkbox-inline"><input name="job" type="radio" value="IOS ">	IOS开发</label>
								<label class="checkbox-inline"><input name="job" type="radio" value="Other ">	其他</label>
							</div>
						</div>
						

						<div class="form-group col-sm-8">
							<label>工作经验：</label>
							<select class="form-control" name="experience">
								<option value = "No">无</option>
								<option value = "Less than one year">少于一年</option>
								<option value = "One year to two years">一年到两年</option>
								<option value = "Two to three years">两年到三年</option>
								<option value = "More than three years">三年以上</option>
							</select>
						</div>
						

						<!-- 修改照片 -->
						<!-- <div class="panel-body" style="float: right">
							<div>
								<img alt="" src="images/anonymous.png">
								<div>
									<a href="resumeBasicInfoPicUpload.html">更换照片</a>
								</div>
							</div>
						</div> -->
						<div class="form-group">
							<div class="col-sm-offset-3 col-sm-10">
								<button type="submit" class="btn btn-primary">添加</button>

								<button type="reset" class="btn btn-warning">清空</button>
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