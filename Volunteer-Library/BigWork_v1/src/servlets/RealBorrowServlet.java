package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Account;
import bean.BorrowBook;
import dao.BookDao;

/**
 * Servlet implementation class RealBorrowServlet
 */
@WebServlet("/RealBorrowServlet")
public class RealBorrowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RealBorrowServlet() {
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
		
		HttpSession session = request.getSession();
        Account account = (Account)session.getAttribute("account");
		Map<String, BorrowBook> borrowmap = (HashMap<String, BorrowBook>)session.getAttribute("borrowmap");
		BorrowBook borrow_book = new BorrowBook();
		BookDao Bdao = new BookDao();
		int n = 0;
		for (Map.Entry<String, BorrowBook> entry : borrowmap.entrySet()) {
			BorrowBook borrowbook = entry.getValue();
			try {
				n += Bdao.realBorrow(borrowbook, account.getUser_id());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(n==borrowmap.size()){
			session.setAttribute("borrowmap", null);
			out.println("<script>alert('…Í«Î≥…π¶£¨«Îµ»¥˝π‹¿Ì‘±…Û∫À');location.href='BorrowMessage';</script>");
		}
		else{
			out.println("<script>alert('…Í«Î ß∞‹£¨«Î÷ÿ ‘');history.back();location.reload();</script>");
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
