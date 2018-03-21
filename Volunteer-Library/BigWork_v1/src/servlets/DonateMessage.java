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
import bean.DonateBook;
import dao.BookDao;

/**
 * Servlet implementation class DonateMessage
 */
@WebServlet("/DonateMessage")
public class DonateMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonateMessage() {
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
		List<DonateBook> donatelist = new ArrayList<DonateBook>();
		ResultSet rs = null;
		try {
			rs = Bdao.getDonateMessage(account.getUser_id());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(rs!=null){
			try {
				while(rs.next()){
					String donate_book_name = rs.getString("donate_book_name");
					String donate_book_author = rs.getString("donate_book_author");
					String donate_book_num = rs.getString("donate_book_num");
					String status = rs.getString("status");
					String donate_time = rs.getString("donate_time");
					
					DonateBook donate_book = new DonateBook(donate_book_name, donate_book_author, donate_book_num, status, donate_time);
					donatelist.add(donate_book);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.setAttribute("donatelist", donatelist);
		request.getRequestDispatcher("/donate_message.jsp").forward(request, response);
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
