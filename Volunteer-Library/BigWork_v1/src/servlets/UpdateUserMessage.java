package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Account;
import dao.AccountDao;

/**
 * Servlet implementation class UpdateUserMessage
 */
@WebServlet("/UpdateUserMessage")
public class UpdateUserMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserMessage() {
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
		PrintWriter out = response.getWriter();
		String user_name= request.getParameter("user_name");
		String password= request.getParameter("password");
		String phone= request.getParameter("phone");
		String address= request.getParameter("address");

		HttpSession session = request.getSession();
		Account acc = (Account)session.getAttribute("account");
		Account account = new Account(acc.getUser_id(), user_name, password, address, phone);
		AccountDao Adao = new AccountDao();
		
		int n = 0;
		try {
			n = Adao.updateUser(account);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(n>0){
			session.setAttribute("account", account);
			out.println("<script>alert('修改成功');location.href='ordinary_message.jsp';</script>");
		}
		else{
			out.println("<script>alert('修改失败，请重试！');location.href='ordinary_message.jsp';</script>");
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
