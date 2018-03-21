package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class BorrowMessage
 */
@WebServlet("/BorrowMessage")
public class BorrowMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrowMessage() {
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
		//PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        Account account = (Account)session.getAttribute("account");
        
		BookDao Bdao = new BookDao();
		List<BorrowBook> borrowlist = new ArrayList<BorrowBook>();
		ResultSet rs = null;
		try {
			rs = Bdao.getBorrowMessage(account.getUser_id());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(rs!=null){
			try {
				while(rs.next()){
					String borrow_id = rs.getString("borrow_id");
					String borrow_book_name = rs.getString("borrow_book_name");
					String borrow_book_author = rs.getString("borrow_book_author");
					String borrow_book_num = rs.getString("borrow_book_num");
					String status = rs.getString("status");
					String borrow_time = rs.getString("borrow_time");
					
					BorrowBook borrow_book = new BorrowBook(borrow_id, borrow_book_name, borrow_book_author, borrow_book_num, status, borrow_time);
					borrowlist.add(borrow_book);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.setAttribute("borrowlist", borrowlist);
		request.getRequestDispatcher("/borrow_message.jsp").forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
