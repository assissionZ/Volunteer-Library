package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Account;
import dao.AccountDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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

		String user_id = request.getParameter("user_id_login");
		String password = request.getParameter("password_login");
		String save = request.getParameter("save");
		
		Account account = new Account(user_id, password);
		AccountDao Adao = new AccountDao();
		PrintWriter out = response.getWriter();
		ResultSet rs = null;
		String type = null;
		
		//System.out.println(user_id);
        
		if(user_id!=null && !user_id.equals("")){
			try {
				rs = Adao.tryLogin(account);
				if(rs.next()){
					if(rs.getString("password").equals(password)){
						if(save!=null){
							Cookie c_user_id = new Cookie("user_id", user_id);
							c_user_id.setMaxAge(604800);
					        response.addCookie(c_user_id);
					        Cookie c_password = new Cookie("password", password);
					        c_password.setMaxAge(604800);
					        response.addCookie(c_password);
						}
						
						//创建session对象
			            HttpSession session = request.getSession();
			            //把用户数据保存在session域对象中
			            //session.setAttribute("user_id", user_id);
			            //session.setAttribute("password", password);
			            String user_name = rs.getString("user_name");
						type = rs.getString("type");
			            //session.setAttribute("type", type);
			            String address = rs.getString("address");
			            //session.setAttribute("address", address);
			            String phone = rs.getString("phone");
			            account.setUser_name(user_name);
			            account.setType(type);
			            account.setAddress(address);
			            account.setPhone(phone);
			            
			            session.setAttribute("account", account);
			            
			            //session.setAttribute("phone", phone);
			            
						Adao.closeConnection();
						if(type.equals("manager")){
				            //跳转到用户主页
				            out.println("<script> alert(\"登录成功！\");location.href='ordinary_page.jsp';</script>");
						}
						else if(type.equals("volunteer")){
				            //跳转到用户主页
				            out.println("<script> alert(\"登录成功！\");location.href='ordinary_page.jsp';</script>");
						}
						else if(type.equals("ordinary")){
				            //跳转到用户主页
				            out.println("<script> alert(\"登录成功！\");location.href='ordinary_page.jsp';</script>");
						}
					}
					else {
						Adao.closeConnection();
						out.println("<script> alert(\"帐号或密码错误！\");location.href='index.jsp?login_error=1';</script>");
						return ;
					}
				}
				else {
					Adao.closeConnection();
					out.println("<script> alert(\"帐号或密码错误！\");location.href='index.jsp?login_error=1';</script>");
					return ;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			out.println("<script> alert(\"学号不能为空\");location.href='index.jsp?login_error=1';</script>");
			return ;
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
