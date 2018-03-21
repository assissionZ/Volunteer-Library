package bean;

public class Message {
	String message_id;
	String status;
	String time;
	String user_id;
	String content;
	String email;
	public Message(){}
	public Message(String user_id, String email, String content){
		this.user_id = user_id;
		this.content = content;
		this.email = email;
	}
	public Message(String message_id, String user_id, String content, String email, String status, String time){
		this.user_id = user_id;
		this.content = content;
		this.email = email;
		this.message_id = message_id;
		this.status = status;
		this.time = time;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage_id() {
		return message_id;
	}
	public void setMessage_id(String message_id) {
		this.message_id = message_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
