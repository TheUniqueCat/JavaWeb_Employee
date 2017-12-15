package com.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.salary.Salary;
import com.salary.SalaryDAO;
import com.task2.ApplicantDAO;
import com.task4.Applicant;

/**
 * Servlet implementation class All_ResumeServlet
 */
@WebServlet("/All_ResumeServlet")
public class All_ResumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public All_ResumeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicantDAO dao = new ApplicantDAO();
		if(request.getParameter("search_id") != null){
			int search_id = Integer.valueOf(request.getParameter("search_id"));
			List<User> user_list = dao.selectById(search_id);
			request.setAttribute("userList", user_list);
			request.getRequestDispatcher("All_Resume.jsp").forward(request, response);
		}else{
			List<User> user_list = dao.selectAll();
			request.setAttribute("userList", user_list);
			request.getRequestDispatcher("All_Resume.jsp").forward(request, response);
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
