package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Account;
import dao.AccountDao;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		String user_id = request.getParameter("user_id");
		String user_name = request.getParameter("user_name");
		String password = request.getParameter("password");
		String password_again = request.getParameter("password_again");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		
		AccountDao Adao = new AccountDao();
		int n = 0;
		boolean isuser = false;
		String regex_phone = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
		
		if(user_id==null || user_name==null || password==null || password_again==null || address==null || phone==null){
			out.println("<script> alert(\"页面异常，请重试\");location.href='index.jsp?register_error=1';</script>");
		}
		else{
			if(!user_id.equals("") && !user_name.equals("") && !password.equals("") && !password_again.equals("") && 
					password.equals(password_again) && !address.equals("") && !phone.equals("") && Pattern.matches(regex_phone, phone)){
				try {
					isuser = Adao.isUser(user_id);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(!isuser){
					Account account = new Account(user_id, user_name, password, address, phone);
					try {
						n = Adao.addAccount(account);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(n>0){
						out.println("<script> alert(\"注册成功，请登录\");location.href='index.jsp?login_error=1';</script>");
					}
					else{
						out.println("<script> alert(\"注册失败，请重试\");location.href='index.jsp?register_error=1';</script>");
					}
				}
				else{
					//System.out.println("该学号已被注册，请登录！");
					out.println("<script> alert(\"该学号已被注册，请登录\");location.href='index.jsp?login_error=1';</script>");
				}
			}
			else{
				out.println("<script> alert(\"请按照提示填写完整的信息\");location.href='index.jsp?register_error=1';</script>");
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
