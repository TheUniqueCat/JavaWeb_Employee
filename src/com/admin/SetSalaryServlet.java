package com.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.info.InfoBasicinfo;
import com.salary.Salary;
import com.salary.SalaryDAO;

/**
 * Servlet implementation class SetSalaryServlet
 */
@WebServlet("/SetSalaryServlet")
public class SetSalaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetSalaryServlet() {
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
			Salary sal = this.requestDataObj(request);
			SalaryDAO dao = new SalaryDAO();
			int id5 = Integer.valueOf(request.getParameter("id5"));
			dao.setSalary(sal, id5);
			List<Salary> salary_list = dao.select(id5);
			request.setAttribute("Sal_list", salary_list);
			request.getRequestDispatcher("Salary.jsp").forward(request, response);
		}

	}
	

	private Salary requestDataObj(HttpServletRequest request){
		Salary sal = null;
		float post_salary = Float.valueOf(request.getParameter("post_salary"));
		float attendance_salary = Float.valueOf(request.getParameter("attendance_salary"));
		float bonus = Float.valueOf(request.getParameter("bonus"));
		String date = (String)request.getParameter("date");
		sal = new Salary(post_salary, attendance_salary, bonus, date);
		return sal;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
