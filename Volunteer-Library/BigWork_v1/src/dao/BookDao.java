package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.Book;
import bean.BorrowBook;

public class BookDao {
	private Connection conn = null;
	private Statement stmt = null;
	String table = "book";
	String donate_table = "donate";
	String borrow_table = "borrow";
	String sql = null;
	public void initConnection() throws Exception{
		System.out.println("***BookDao.initConnection()***");
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/account";
		conn = DriverManager.getConnection(url, "root","123456");
	}
	public void closeConnection() throws Exception{
		System.out.println("***BookDao.closeConnection()***");
		conn.close();
	}
	public ResultSet allBooks() throws Exception{
		ResultSet rs = null;
		this.initConnection();
		stmt = conn.createStatement();
		sql = "select * from "+table;
		System.out.println("***"+sql+"***");
		rs = stmt.executeQuery(sql);
		return rs;
	}
	public ResultSet queryBookById(String book_id) throws Exception{
		ResultSet rs = null;
		this.initConnection();
		stmt = conn.createStatement();
		sql = "select * from "+table+" where book_id='"+book_id+"'";
		System.out.println("***"+sql+"***");
		rs = stmt.executeQuery(sql);
		return rs;
	}
	public int realBorrow(BorrowBook borrow_book, String user_id) throws Exception{

		this.initConnection();
		stmt = conn.createStatement();
		
		String borrow_book_num = borrow_book.getBorrow_book_num();
		String borrow_book_name = borrow_book.getBorrow_book_name();	
		String borrow_book_author = borrow_book.getBorrow_book_author();
		
		sql = "insert into "+borrow_table+"(user_id,borrow_book_name,borrow_book_author,borrow_book_num,status,borrow_time) values('"+user_id+"','"+borrow_book_name+"','"+borrow_book_author+"','"+borrow_book_num+"','…Û∫À÷–',now());";
		System.out.println("***"+sql+"***");
		int n = stmt.executeUpdate(sql);
		return n;
	}
	public int returnBook(String book_id, String num) throws Exception{
		this.initConnection();
		stmt = conn.createStatement();

		sql = "select * from "+table+" where book_id='"+book_id+"'";
		System.out.println("***"+sql+"***");
		ResultSet rs = stmt.executeQuery(sql);
		String book_residual_number = null;
		if(rs.next()){
			book_residual_number = rs.getString("book_residual_number");
		}
		book_residual_number = Integer.toString((Integer.parseInt(book_residual_number) + Integer.parseInt(num)));
		sql = "update "+table+" set book_residual_number='"+book_residual_number+"' where book_id="+book_id;
		System.out.println("***"+sql+"***");
		int n = stmt.executeUpdate(sql);
		return n;
	
	}
	public int preBorrow(BorrowBook borrow_book, String book_residual_number, String user_id) throws Exception{
		
		String borrow_book_id = borrow_book.getBorrow_id();
		String borrow_book_num = borrow_book.getBorrow_book_num();
		
		book_residual_number = Integer.toString(Integer.parseInt(book_residual_number) - Integer.parseInt(borrow_book_num));
		sql = "update "+table+" set book_residual_number='"+book_residual_number+"' where book_id="+borrow_book_id;
		System.out.println("***"+sql+"***");
		int n = stmt.executeUpdate(sql);
		return n;
	}
	public int preDonate(Book book, String user_id, String donate_book_num) throws Exception{
		this.initConnection();
		stmt = conn.createStatement();
		sql = "insert into "+donate_table+"(user_id,donate_book_name,donate_book_author,donate_book_num,status,donate_time) values('"+user_id+"','"+book.getBook_name()+"','"+book.getBook_author()+"','"+donate_book_num+"','…Û∫À÷–',now());";
		System.out.println("***"+sql+"***");
		int n = stmt.executeUpdate(sql);
		return n;
	}
	public ResultSet getDonateMessage(String user_id) throws Exception{
		this.initConnection();
		stmt = conn.createStatement();
		sql = "select * from "+donate_table+" where user_id='"+user_id+"'";
		System.out.println("***"+sql+"***");
		ResultSet rs = stmt.executeQuery(sql);
		return rs;
	}
	public ResultSet getBorrowMessage(String user_id) throws Exception{
		this.initConnection();
		stmt = conn.createStatement();
		sql = "select * from "+borrow_table+" where user_id='"+user_id+"'";
		System.out.println("***"+sql+"***");
		ResultSet rs = stmt.executeQuery(sql);
		return rs;
	}
	public ResultSet queryBorrowByStatus(String status) throws Exception{
		this.initConnection();
		stmt = conn.createStatement();
		sql = "select * from "+borrow_table+" where status='"+status+"'";
		System.out.println("***"+sql+"***");
		ResultSet rs = stmt.executeQuery(sql);
		return rs;
	}
	public ResultSet queryDonateByStatus(String status) throws Exception{
		this.initConnection();
		stmt = conn.createStatement();
		sql = "select * from "+donate_table+" where status='"+status+"'";
		System.out.println("***"+sql+"***");
		ResultSet rs = stmt.executeQuery(sql);
		return rs;
	}
	public int updateBorrowStatusById(String id, String newstatus) throws Exception{
		this.initConnection();
		stmt = conn.createStatement();
		sql = "update "+borrow_table+" set status='"+newstatus+"' where borrow_id="+id;
		System.out.println("***"+sql+"***");
		int n = stmt.executeUpdate(sql);
		return n;
	}
	public int updateDonateStatusById(String id, String newstatus) throws Exception{
		this.initConnection();
		stmt = conn.createStatement();
		sql = "update "+donate_table+" set status='"+newstatus+"' where donate_id="+id;
		System.out.println("***"+sql+"***");
		int n = stmt.executeUpdate(sql);
		return n;
	}
}
