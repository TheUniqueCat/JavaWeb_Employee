package com.notice;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.salary.Salary;
import com.salary.SalaryDAO;

/**
 * Servlet implementation class NoticeServlet
 */
@WebServlet("/NoticeServlet")
public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeServlet() {
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
		NoticeDAO dao = new NoticeDAO();
		if(type.equals("add")){
			Notice no = this.requestDataObj(request);
			dao.addNotice(no);
			List<Notice> notice = dao.selectAll();
			request.getSession().setAttribute("no_list", notice);
			request.getRequestDispatcher("Notice.jsp").forward(request, response);
		}
		if(type.equals("select")){
			List<Notice> no = dao.selectAll();
			request.getSession().setAttribute("no_list", no);
			request.getRequestDispatcher("Notice.jsp").forward(request, response);
		}
		if(type.equals("delect")){
			int notice_id = Integer.valueOf(request.getParameter("Notice_id"));
			dao.update(notice_id);
			List<Notice> notice = dao.selectAll();
			request.getSession().setAttribute("no_list", notice);
			request.getRequestDispatcher("Notice.jsp").forward(request, response);
		}
		if(type.equals("view")){
			request.getRequestDispatcher("MessageServlet?type=select").forward(request, response);
		}
		
	}

	private Notice requestDataObj(HttpServletRequest request) {
		Notice no = new Notice();
		String title = request.getParameter("notice_title");
		String content = request.getParameter("notice_content");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(new Date());
		no = new Notice(title, content, date);
		return no;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
