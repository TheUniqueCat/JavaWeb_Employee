package com.message;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.notice.Notice;
import com.notice.NoticeDAO;

/**
 * Servlet implementation class MessageServlet
 */
@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageServlet() {
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
		MessageDAO dao = new MessageDAO();
		NoticeDAO dao1 = new NoticeDAO();
		
		if("add".equals(type)){
			int notice_id = Integer.valueOf(request.getParameter("notice_id"));
			int applicant_id = Integer.valueOf(request.getParameter("applicant_id"));
			dao.addMessage(new Message(request.getParameter("message_content")), notice_id, applicant_id);
		}
		if("select".equals(type)){}
		if("delect".equals(type)){
			int message_id = Integer.valueOf(request.getParameter("message_id"));
			dao.delete(message_id);
		}
		int notice_id = Integer.valueOf(request.getParameter("notice_id"));
		Notice notice = dao1.selectByid(notice_id);
		request.getSession().setAttribute("no_list", notice);
		List<Message> message = dao.selectAll(notice_id);
		request.getSession().setAttribute("me_list", message);
		request.getRequestDispatcher("ViewNotice.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}