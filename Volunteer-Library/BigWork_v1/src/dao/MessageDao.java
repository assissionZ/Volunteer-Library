package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import bean.Message;

public class MessageDao {
	private Connection conn = null;
	private Statement stmt = null;
	String table = "message";
	String sql = null;
	public void initConnection() throws Exception{
		System.out.println("***MessageDao.initConnection()***");
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/account";
		conn = DriverManager.getConnection(url, "root","123456");
	}
	public void closeConnection() throws Exception{
		System.out.println("***MessageDao.closeConnection()***");
		conn.close();
	}
	public ResultSet getAllMessage() throws Exception{
		ResultSet rs = null;
		this.initConnection();
		stmt = conn.createStatement();
		sql = "select * from "+table+" order by time desc";
		System.out.println("***"+sql+"***");
		rs = stmt.executeQuery(sql);
		return rs;
	}
	public int addMessage(Message mes) throws Exception{
		ResultSet rs = null;
		this.initConnection();
		stmt = conn.createStatement();
		sql = "insert into "+table+"(user_id,content,email,status,time) values('"+mes.getUser_id()+"','"+mes.getContent()+"','"+mes.getEmail()+"','Î´ÔÄ¶Á',now());";
		System.out.println("***"+sql+"***");
		int n = stmt.executeUpdate(sql);
		return n;
	}
	public int updateStatusById(String id) throws Exception{
		this.initConnection();
		stmt = conn.createStatement();
		sql = "update "+table+" set status='"+"ÒÑ¶Á"+"' where message_id="+id;
		System.out.println("***"+sql+"***");
		int n = stmt.executeUpdate(sql);
		return n;
	}
}
