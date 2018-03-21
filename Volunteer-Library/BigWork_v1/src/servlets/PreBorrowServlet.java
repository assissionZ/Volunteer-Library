package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Account;
import bean.Book;
import bean.BorrowBook;
import dao.BookDao;

/**
 * Servlet implementation class PreBorrowServlet
 */
@WebServlet("/PreBorrowServlet")
public class PreBorrowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreBorrowServlet() {
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

		// 获取所有被选择的book_id和number
		String []ids = request.getParameterValues("select_book_id");
		String []pns = request.getParameterValues("preborrow_number");
		String book_name = null;
		String book_author = null;
		String book_residual_number = null;

		HttpSession session = request.getSession();
		BookDao Bdao = new BookDao();

        Account account = (Account)session.getAttribute("account");
		Map<String, BorrowBook> borrowmap = (HashMap<String, BorrowBook>)session.getAttribute("borrowmap");
		if(borrowmap==null){
			borrowmap = new HashMap<String, BorrowBook>();
		}
		int n = 0;
		for(int i=0; i<ids.length; i++){
			int ids_int = Integer.parseInt(ids[i]);
			int pns_int = Integer.parseInt(pns[ids_int]);
			String realId = Integer.toString(ids_int+1);
			if(!pns[ids_int].equals("0")){
				try {
					ResultSet rs = Bdao.queryBookById(realId);
					if(rs.next()){
						book_author = rs.getString("book_author");
						book_name = rs.getString("book_name");
						book_residual_number = rs.getString("book_residual_number");
					}
					BorrowBook borrow_book = null;
					if(borrowmap.containsKey(realId)){
						borrow_book = borrowmap.get(realId);
						String pbn = Integer.toString(Integer.parseInt(borrow_book.getBorrow_book_num()) + pns_int);
						borrow_book.setBorrow_book_num(pbn);
						borrowmap.put(realId, borrow_book);
					}
					else{
						borrow_book = new BorrowBook(realId, book_name, book_author, pns[ids_int]);
						borrowmap.put(realId, borrow_book);
					}
					n = Bdao.preBorrow(borrow_book, book_residual_number, account.getUser_id());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if(n>0){
			session.setAttribute("borrowmap", borrowmap);
			out.println("<script>alert('加入预借清单成功');location.href='BookListServlet?op=1';</script>");
		}
		else{
			out.println("<script='javascript'>alert('加入预借清单失败，请重试！');location.href='BookListServlet?op=1';</script>");
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
