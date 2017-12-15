package com.task2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApplictionRegisterServlet
 */
@WebServlet("/ApplicantRegisterServlet")
public class ApplicantRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicantRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//编码设置
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset = utf-8");
		
		PrintWriter out = response.getWriter();
		//参数获取
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String verifyCode = request.getParameter("verifyCode");
		
		System.out.println("填写的邮箱是:"+email);
		System.out.println("填写的密码是:"+password);

		//判断验证码是否正确
		String sessionValidateCode = (String) request.getSession().getAttribute("SESSION_VALIDATECODE");
		if(!sessionValidateCode.equals(verifyCode)){
			//验证码不正确
			System.out.println("验证码输入错误");
			out.println("<script type = 'text/javascript'>");
			out.println("alert('请输入正确的验证码！')");
			out.println("window.location = 'register.jsp';");
			out.println("</script>");
		}else{
			System.out.println("验证码输入正确");
			ApplicantDAO dao = new ApplicantDAO();
			System.out.println("开始链接sql");
			//判断邮箱是否已经注册
			boolean flag = dao.isExistEmail(email);
			if(flag){
				//邮箱被注册
				System.out.println("注册失败");
				out.println("<script type = 'text/javascript'>");
				out.println("alert('邮箱已经被注册，请重新输入！');");
				out.println("window.location = 'register.jsp';");
				out.println("</script>");
			}else{
				//未被注册
				dao.save(email,password);
				response.sendRedirect("login.jsp");
				System.out.println("注册成功");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
