package bean;

public class DonateBook {
	String donate_id;
	String user_id;
	String donate_book_name;
	String donate_book_author;
	String donate_book_num;
	String status;
	String donate_time;
	public DonateBook(){}
	public DonateBook(String donate_book_name, String donate_book_author, String donate_book_num, String status, String donate_time){

		this.donate_book_name = donate_book_name;
		this.donate_book_author = donate_book_author;
		this.donate_book_num = donate_book_num;
		this.status = status;
		this.donate_time = donate_time;
	}
	public DonateBook(String donate_id, String user_id, String donate_book_name, String donate_book_author, String donate_book_num, String status, String donate_time){

		this.donate_id = donate_id;
		this.user_id = user_id;
		this.donate_book_name = donate_book_name;
		this.donate_book_author = donate_book_author;
		this.donate_book_num = donate_book_num;
		this.status = status;
		this.donate_time = donate_time;
	}
	public String getDonate_book_name() {
		return donate_book_name;
	}
	public void setDonate_book_name(String donate_book_name) {
		this.donate_book_name = donate_book_name;
	}
	public String getDonate_book_author() {
		return donate_book_author;
	}
	public void setDonate_book_author(String donate_book_author) {
		this.donate_book_author = donate_book_author;
	}
	public String getDonate_book_num() {
		return donate_book_num;
	}
	public void setDonate_book_num(String donate_book_num) {
		this.donate_book_num = donate_book_num;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDonate_time() {
		return donate_time;
	}
	public void setDonate_time(String donate_time) {
		this.donate_time = donate_time;
	}
	public String getDonate_id() {
		return donate_id;
	}
	public void setDonate_id(String donate_id) {
		this.donate_id = donate_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
}
