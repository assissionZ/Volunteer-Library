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
 * Servlet implementation class UpdatePreBorrowList
 */
@WebServlet("/UpdatePreBorrowList")
public class UpdatePreBorrowList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePreBorrowList() {
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

		String id = request.getParameter("id");
		String num = request.getParameter("num");
		BookDao Bdao = new BookDao();
		int n = 0;
		try {
			n = Bdao.returnBook(id, num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(n>0){
			borrowmap.remove(id);
			session.setAttribute("borrowmap", borrowmap);
			out.println("<script>alert('…æ≥˝≥…π¶');location.href='showPreBorrowList.jsp';</script>");
		}
		else{
			out.println("<script>alert('…æ≥˝ ß∞‹£¨«Î÷ÿ ‘');location.href='showPreBorrowList.jsp';</script>");
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
