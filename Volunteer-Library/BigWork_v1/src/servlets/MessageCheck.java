package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import bean.Message;
import dao.MessageDao;

/**
 * Servlet implementation class MessageCheck
 */
@WebServlet("/MessageCheck")
public class MessageCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/html;charset=utf-8");
		
		MessageDao Mdao = new MessageDao();
		List<Message> messagelist = new ArrayList<Message>();
		ResultSet rs = null;
		try {
			rs = Mdao.getAllMessage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(rs!=null){
			try {
				while(rs.next()){
					String message_id = rs.getString("message_id");
					String user_id = rs.getString("user_id");
					String content = rs.getString("content");
					String email = rs.getString("email");
					String status = rs.getString("status");
					String time = rs.getString("time");
					Message mes = new Message(message_id, user_id, content, email, status, time);
					messagelist.add(mes);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.setAttribute("messagelist", messagelist);
		
		request.getRequestDispatcher("/showMessage_manager.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
