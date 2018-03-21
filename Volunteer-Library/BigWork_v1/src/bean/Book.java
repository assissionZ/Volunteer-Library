package bean;

public class Book {
	String book_id;
	String book_name;
	String book_author;
	String book_residual_number;
	String book_total_number;
	public Book(){}
	public Book(String book_name, String book_author){
		this.book_name = book_name;
		this.book_author = book_name;
	}
	public Book(String book_id, String book_name, String book_author, String book_residual_number, String book_total_number){
		this.book_id = book_id;
		this.book_name = book_name;
		this.book_author = book_author;
		this.book_residual_number = book_residual_number;
		this.book_total_number = book_total_number;
	}
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_author() {
		return book_author;
	}
	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}
	public String getBook_residual_number() {
		return book_residual_number;
	}
	public void setBook_residual_number(String book_residual_number) {
		this.book_residual_number = book_residual_number;
	}
	public String getBook_total_number() {
		return book_total_number;
	}
	public void setBook_total_number(String book_total_number) {
		this.book_total_number = book_total_number;
	}
}
