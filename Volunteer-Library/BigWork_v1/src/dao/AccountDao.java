package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.Account;

public class AccountDao {
	private Connection conn = null;
	private Statement stmt = null;
	String table = "account";
	String sql = null;
	public void initConnection() throws Exception{
		System.out.println("***AccountDao.initConnection()***");
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/account";
		conn = DriverManager.getConnection(url, "root","123456");
	}
	public void closeConnection() throws Exception{
		System.out.println("***AccountDao.closeConnection()***");
		conn.close();
	}
	public boolean isUser(String user_id) throws Exception{
		//String user_id = account.getUser_id();
		ResultSet rs = null;
		this.initConnection();
		stmt = conn.createStatement();
		if(user_id!=null && !user_id.equals("")){
			sql = "select * from "+table+" where user_id='" + user_id + "'";
			System.out.println("***"+sql+"***");
			rs = stmt.executeQuery(sql);
		}
		try {
			if(rs != null && rs.next()){
				this.closeConnection();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.closeConnection();
		return false;
	}
	public int addAccount(Account account) throws Exception{
		//String user_id = account.getUser_id();
		//ResultSet rs = null;
		int n = 0;
		this.initConnection();
		stmt = conn.createStatement();
		sql = "insert into "+table+"(user_id,user_name,password,address,phone,type)values('"+account.getUser_id()
				+"','"+account.getUser_name()+"','"+account.getPassword()+"','"+account.getAddress()+"','"
				+account.getPhone()+"','"+account.getType()+"');";
		System.out.println("***"+sql+"***");
		n = stmt.executeUpdate(sql);
		this.closeConnection();
		return n;
	}
	public ResultSet tryLogin(Account account) throws Exception{
		String user_id = account.getUser_id();
		int n = 0;
		this.initConnection();
		stmt = conn.createStatement();
		sql = "select * from "+table+" where user_id='" + user_id + "'";
		System.out.println("***"+sql+"***");
		ResultSet rs = stmt.executeQuery(sql);
		return rs;
	}
	public int updateUser(Account account) throws Exception {
		// TODO Auto-generated method stub
		this.initConnection();
		stmt = conn.createStatement();
		sql = "update "+table+" set user_name='"+account.getUser_name()+"',password='"+account.getPassword()+"',phone='"+account.getPhone()+"',address='"+account.getAddress()+"' where user_id='"+account.getUser_id()+"'";
		System.out.println("***"+sql+"***");
		int n = stmt.executeUpdate(sql);
		return n;
	}
	public ResultSet getAllUser() throws Exception{
		this.initConnection();
		stmt = conn.createStatement();
		sql = "select * from "+table;
		System.out.println("***"+sql+"***");
		ResultSet rs = stmt.executeQuery(sql);
		return rs;
	}
	public int updateTypeById(String id, String newtype) throws Exception{

		this.initConnection();
		stmt = conn.createStatement();
		sql = "update "+table+" set type='"+newtype+"' where user_id='"+id+"'";
		int n = stmt.executeUpdate(sql);
		return n;
		
		
	}
}
