package com.info;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.task3.ResumeBasicinfo;
import com.task3.ResumeDAO;
import com.task4.Applicant;

/**
 * Servlet implementation class InfoBasicinfoServlet
 */
@WebServlet("/InfoBasicinfoServlet")
public class InfoBasicinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoBasicinfoServlet() {
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
			/*
			 * 添加个人简历
			 */
			InfoBasicinfo info = this.requestDataObj(request);
			Applicant applicant = (Applicant) request.getSession().getAttribute("SESSION_APPLICANT");
			InfoDAO dao = new InfoDAO();
			int infoid = dao.addInfo(info, (int)request.getSession().getAttribute("applicantID"));
			
			response.sendRedirect("Info.jsp");
		}
		if(type.equals("update")){
			/*
			 * 更新个人简历
			 */
			InfoBasicinfo info = this.requestDataObj(request);
			
			InfoDAO dao = new InfoDAO();
			int infoid = dao.updaterInfo(info, (int)request.getSession().getAttribute("applicantID"));
			
			request.getSession().setAttribute("age", info.getAge());
			response.sendRedirect("Info.jsp");
		}
		
		if(type.equals("select")){
			/*
			 * 查看个人简历
			 */
			
			int id2 = Integer.valueOf(request.getParameter("id2"));
			System.out.println("id2是："+id2);
			request.getSession().setAttribute("id2", request.getParameter("id2"));
			response.sendRedirect("Info.jsp");
			
		}
	}
	
	
	private InfoBasicinfo requestDataObj(HttpServletRequest request) {
		InfoBasicinfo info = null;
		int age = Integer.valueOf(request.getParameter("age"));
		String job = request.getParameter("job");
		String experience = request.getParameter("experience");

		System.out.println("requestDataObj:"+age+";"+job+";"+experience);
		//将所填写的信息封装成一个个人基本信息的对象
		info = new InfoBasicinfo(age, job, experience);
		return info;
	}
	
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
