package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Account;
import bean.Message;
import dao.MessageDao;

/**
 * Servlet implementation class MessageBoardDeal
 */
@WebServlet("/MessageBoardDeal")
public class MessageBoardDeal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageBoardDeal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String email = request.getParameter("email");
		String content = request.getParameter("content");

        HttpSession session = request.getSession();
		Account account = (Account)session.getAttribute("account");
		Message mes = new Message(account.getUser_id(), email, content);
		MessageDao mesDao = new MessageDao();
		int n = 0;
		try {
			n = mesDao.addMessage(mes);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(n>0){
			out.println("<script>alert('¡Ù—‘≥…π¶');history.back();</script>");
		}
		else{
			out.println("<script>alert('¡Ù—‘ ß∞‹£¨«Î÷ÿ ‘£°');history.back();</script>");
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
