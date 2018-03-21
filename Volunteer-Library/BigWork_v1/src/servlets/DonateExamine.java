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

import bean.BorrowBook;
import bean.DonateBook;
import dao.BookDao;

/**
 * Servlet implementation class DonateExamine
 */
@WebServlet("/DonateExamine")
public class DonateExamine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonateExamine() {
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
		BookDao Bdao = new BookDao();
		ResultSet rs = null;
		List<DonateBook> donatelist = new ArrayList<DonateBook>();
		try {
			rs = Bdao.queryDonateByStatus("…Û∫À÷–");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rs!=null){
			try {
				while(rs.next()){
					String donate_id = rs.getString("donate_id");
					String user_id = rs.getString("user_id");
					String donate_book_name = rs.getString("donate_book_name");
					String donate_book_num = rs.getString("donate_book_num");
					String donate_book_author = rs.getString("donate_book_author");
					String donate_time = rs.getString("donate_time");
					String status = rs.getString("status");
					DonateBook donatebook = new DonateBook(donate_id, user_id, donate_book_name, donate_book_author, donate_book_num, status, donate_time);
					donatelist.add(donatebook);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.setAttribute("donatelist", donatelist);
		request.getRequestDispatcher("/showDonateExamine.jsp").forward(request, response);
					
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
