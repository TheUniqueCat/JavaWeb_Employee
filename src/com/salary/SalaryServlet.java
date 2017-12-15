package com.salary;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SalaryServlet
 */
@WebServlet("/SalaryServlet")
public class SalaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalaryServlet() {
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
		if(type.equals("select")){
			if(request.getParameter("id3") == null){
				System.out.println("id3为空");
				//个人查询
				int applicantID = (Integer)request.getSession().getAttribute("applicantID");
				System.out.println(applicantID);
				
				SalaryDAO salaryDAO = new SalaryDAO();
				System.out.println("date是"+request.getParameter("salary_date"));
				if(request.getParameter("salary_date") != null){
					//搜索一个月的工资
					request.setAttribute("salary_date", request.getParameter("salary_date"));
					Salary salary = salaryDAO.select_a_month(applicantID, request.getParameter("salary_date"));
					System.out.println(salary);
					request.setAttribute("Sal_list", salary);
					
				}else{
				List<Salary> salary_list = salaryDAO.select(applicantID);
				request.setAttribute("Sal_list", salary_list);
				}
				request.getRequestDispatcher("Salary.jsp").forward(request, response);
				
			}else{
				int id3 = Integer.valueOf(request.getParameter("id3"));
				System.out.println("id3是："+id3);
				SalaryDAO salaryDAO = new SalaryDAO();
				List<Salary> salary_list = salaryDAO.select(id3);
			
				request.setAttribute("Sal_list", salary_list);
				request.getRequestDispatcher("Salary.jsp").forward(request, response);
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
