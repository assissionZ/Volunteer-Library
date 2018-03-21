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
import bean.Book;
import dao.BookDao;

/**
 * Servlet implementation class PreDonateServlet
 */
@WebServlet("/PreDonateServlet")
public class PreDonateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreDonateServlet() {
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
		String donate_book_name= request.getParameter("donate_book_name");
		String donate_book_author= request.getParameter("donate_book_author");
		String donate_book_num= request.getParameter("donate_book_num");
		BookDao Bdao = new BookDao();
		Book book = new Book(donate_book_name, donate_book_author);
		//创建session对象
        HttpSession session = request.getSession();
        Account account = (Account)session.getAttribute("account");
        int n = 0;
		try {
			n = Bdao.preDonate(book, account.getUser_id(), donate_book_num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(n>0){
			out.println("<script>alert('捐书操作成功，需等待管理员审核');location.href='DonateMessage';</script>");
		}
		else{
			out.println("<script>alert('捐书操作失败，请重试！');location.href='DonateMessage';</script>");
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
