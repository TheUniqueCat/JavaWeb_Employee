package com.task3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.task4.Applicant;

/**
 * Servlet implementation class ResumeBasicinfoServlet
 */
@WebServlet("/ResumeBasicinfoServlet")
public class ResumeBasicinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResumeBasicinfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String type = request.getParameter("type");
		if(type.equals("add")){
			//个人信息添加
			ResumeBasicinfo basicinfo = this.requestDataObj(request);
			//将数据存储到数据库
			ResumeDAO dao = new ResumeDAO();
			System.out.println("id:"+(int)request.getSession().getAttribute("applicantID"));
			int basicinfoID = dao.add(basicinfo,(int)request.getSession().getAttribute("applicantID"));
			request.getSession().setAttribute("SESSION_RESUMEID", basicinfoID);
			response.sendRedirect("index.jsp");
		}
		if(type.equals("update")){
			//个人信息修改
			ResumeBasicinfo basicinfo = this.requestDataObj(request);
			//将数据存储到数据库
			ResumeDAO dao = new ResumeDAO();
			System.out.println("id:"+(int)request.getSession().getAttribute("applicantID"));
			int basicinfoID = dao.update(basicinfo, (int)request.getSession().getAttribute("applicantID"));
			request.getSession().setAttribute("SESSION_RESUMEID", basicinfoID);
			response.sendRedirect("index.jsp");
		}
		
		if(type.equals("select")){
			//个人信息查询
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println("查询的id是："+id);
			request.getSession().setAttribute("applicantID", id);
			response.sendRedirect("index.jsp");
		}
		
		

	}

	private ResumeBasicinfo requestDataObj(HttpServletRequest request) {
		ResumeBasicinfo basicinfo = null;
		String name = request.getParameter("name");
		int phone = Integer.valueOf(request.getParameter("phone"));
		String email = request.getParameter("email");
		String sex = request.getParameter("sex");
		
		request.getSession().setAttribute("name", name);
		request.getSession().setAttribute("phone", phone);
		request.getSession().setAttribute("sex", sex);
		
		
		System.out.println("requestDataObj:"+name+";"+phone+";"+email+";"+sex);
		//将所填写的信息封装成一个个人基本信息的对象
		basicinfo = new ResumeBasicinfo(name, phone, email, sex);
		return basicinfo;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
