package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Account;
import dao.AccountDao;

/**
 * Servlet implementation class RegisterCheckIdServlet
 */
@WebServlet("/RegisterCheckIdServlet")
public class RegisterCheckIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterCheckIdServlet() {
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
		String user_id = request.getParameter("user_id");
		//System.out.println(user_id);
		AccountDao Adao = new AccountDao();
		PrintWriter out = response.getWriter();
		boolean isuser = false;
		if(!user_id.equals("")){
			try {
				isuser = Adao.isUser(user_id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!isuser){
				//System.out.println("��ѧ�ſ���ע��");
				out.println("��ѧ�ſ���ע��");
			}
			else{
				//System.out.println("��ѧ���ѱ�ע�ᣬ���¼��");
				out.println("��ѧ���ѱ�ע�ᣬ���¼��");
			}
		}
		else{
			//System.out.println("ѧ�Ų���Ϊ�գ�");
			out.println("ѧ�Ų���Ϊ�գ�");
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
