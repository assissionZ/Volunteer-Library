package bean;

public class BorrowBook {
	
	String user_id;
	String borrow_id;
	String borrow_book_name;
	String borrow_book_author;
	String borrow_book_num;
	String status;
	String borrow_time;
	public BorrowBook(){}
	public BorrowBook(String borrow_id, String borrow_book_name, String borrow_book_author, String borrow_book_num){

		this.borrow_id = borrow_id;
		this.borrow_book_name = borrow_book_name;
		this.borrow_book_author = borrow_book_author;
		this.borrow_book_num = borrow_book_num;
	}
	public BorrowBook(String borrow_id, String borrow_book_name, String borrow_book_author, String borrow_book_num, String status, String borrow_time){

		this.borrow_id = borrow_id;
		this.borrow_book_name = borrow_book_name;
		this.borrow_book_author = borrow_book_author;
		this.borrow_book_num = borrow_book_num;
		this.status = status;
		this.borrow_time = borrow_time;
	}
	public BorrowBook(String user_id, String borrow_id, String borrow_book_name, String borrow_book_author, String borrow_book_num, String status, String borrow_time){

		this.user_id = user_id;
		this.borrow_id = borrow_id;
		this.borrow_book_name = borrow_book_name;
		this.borrow_book_author = borrow_book_author;
		this.borrow_book_num = borrow_book_num;
		this.status = status;
		this.borrow_time = borrow_time;
	}
	public String getBorrow_id() {
		return borrow_id;
	}
	public void setBorrow_id(String borrow_id) {
		this.borrow_id = borrow_id;
	}
	public String getBorrow_book_name() {
		return borrow_book_name;
	}
	public void setBorrow_book_name(String borrow_book_name) {
		this.borrow_book_name = borrow_book_name;
	}
	public String getBorrow_book_author() {
		return borrow_book_author;
	}
	public void setBorrow_book_author(String borrow_book_author) {
		this.borrow_book_author = borrow_book_author;
	}
	public String getBorrow_book_num() {
		return borrow_book_num;
	}
	public void setBorrow_book_num(String borrow_book_num) {
		this.borrow_book_num = borrow_book_num;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBorrow_time() {
		return borrow_time;
	}
	public void setBorrow_time(String borrow_time) {
		this.borrow_time = borrow_time;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
}
