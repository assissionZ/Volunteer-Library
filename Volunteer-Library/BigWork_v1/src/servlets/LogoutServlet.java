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

import bean.BorrowBook;
import dao.BookDao;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
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
		Map<String, BorrowBook> borrowmap = (HashMap<String, BorrowBook>)session.getAttribute("borrowmap");
		int n = 0;
		BookDao Bdao = new BookDao();
		if(borrowmap!=null){
			for (Map.Entry<String, BorrowBook> entry : borrowmap.entrySet()) {
				BorrowBook borrowbook = entry.getValue();
				try {
					n += Bdao.returnBook(borrowbook.getBorrow_id(), borrowbook.getBorrow_book_num());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(n>0){
				session.setAttribute("borrowmap", borrowmap);
				out.println("<script>alert('注销成功');location.href='index.jsp';</script>");
			}
			else{
				out.println("<script>alert('注销失败，请重试');history.back();location.reload();</script>");
			}
		}
		else{
			out.println("<script>alert('已注销');location.href='index.jsp';</script>");
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
