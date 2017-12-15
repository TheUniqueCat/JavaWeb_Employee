package com.task2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.task4.Applicant;

/**
 * Servlet implementation class ApplicantLoginServlet
 */
@WebServlet("/ApplicantLoginServlet")
public class ApplicantLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String rememberMe = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicantLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//编码设置
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset = utf-8");
		PrintWriter out = response.getWriter();
		//参数获取
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String rememberMe = request.getParameter("rememberMe");
		//登录验证
		ApplicantDAO dao = new ApplicantDAO();
		int applicantID = dao.login(email,password);
		if(applicantID > 0){
			//将用户的信息存入会话对象
			Applicant applicant = new Applicant(applicantID, email, password);
			request.getSession().setAttribute("SESSION_APPLICANT",applicant);
			rememberMe(rememberMe, email, password, request, response);
			request.getSession().setAttribute("email", email);
			request.getSession().setAttribute("applicantID", applicantID);
			response.sendRedirect("allIndex.jsp");
		}
		if(applicantID == -1){
			out.println("<script type = 'text/javascript'>");
			out.println("alert('密码错误，请重新输入！');");
			out.println("window.location = 'login.jsp';");
			out.println("</script>");
		}
		else{
			out.println("<script type = 'text/javascript'>");
			out.println("alert('用户不存在，请先进行注册');");
			out.println("window.location = 'register.jsp';");
			out.println("</script>");
		}
	}
	
	private void rememberMe(String rememberMe, String email, String password, HttpServletRequest request, HttpServletResponse response){
		System.out.println("rememberMe的值:"+rememberMe);
		if("true".equals(rememberMe)){
			System.out.println("记录cookie");
			//记住邮箱和密码
			Cookie cookie = new Cookie("COOKIE_APPLICANTEMAIL", email);
			cookie.setPath("/");
			cookie.setMaxAge(365*24*60*60);
			response.addCookie(cookie);
			cookie = new Cookie("COOKIE_APPLICANTPWD", password);
			cookie.setPath("/");
			cookie.setMaxAge(365*24*60*60);
			response.addCookie(cookie);
		}else{
			System.out.println("删除cookie");
			Cookie[] cookies = request.getCookies();
			if(cookies != null){
				for (Cookie cookie : cookies) {
					if("COOKIE_APPLICANTEMAIL".equals(cookie.getName()) || "COOKIE_APPLICANTPWD".equals(cookie.getName())){
						cookie.setMaxAge(0);
						cookie.setPath("/");
						response.addCookie(cookie);
					}//if
				}//for
			}//if
		}//else
	}//rememberMe

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
