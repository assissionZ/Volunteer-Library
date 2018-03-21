package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import dao.BookDao;

/**
 * Servlet implementation class BookListServlet
 */
@WebServlet("/BookListServlet")
public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookListServlet() {
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
		//PrintWriter out = response.getWriter();
		String op = request.getParameter("op");
		
		BookDao Bdao = new BookDao();
		List<Book> list = new ArrayList<Book>();
		ResultSet rs = null;
		try {
			rs = Bdao.allBooks();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); throw new RuntimeException("");
		}
		
		if(rs!=null){
			try {
				while(rs.next()){
					String book_id = rs.getString("book_id");
					String book_name = rs.getString("book_name");
					String book_author = rs.getString("book_author");
					String book_residual_number = rs.getString("book_residual_number");
					String book_total_number = rs.getString("book_total_number");
					Book book = new Book(book_id, book_name, book_author, book_residual_number, book_total_number);
					list.add(book);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.setAttribute("list", list);
		if(op.equals("0"))
			request.getRequestDispatcher("/showBookList.jsp").forward(request, response);
		else
			request.getRequestDispatcher("/showBookList_login.jsp").forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
