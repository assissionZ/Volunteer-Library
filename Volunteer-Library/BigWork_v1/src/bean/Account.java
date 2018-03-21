package bean;

public class Account {
	String user_id;
	String user_name;
	String password;
	String address;
	String phone;
	String type = "ordinary";//ƒ¨»œ∆’Õ®’Àªß
	public Account(){}
	public Account(String user_id, String password){
		this.user_id = user_id;
		this.password = password;
	}
	public Account(String user_id, String user_name, String password, String address, String phone){
		this.user_id = user_id;
		this.user_name = user_name;
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.type = "ordinary";
	}
	public Account(String user_id, String user_name, String password, String address, String phone, String type){
		this.user_id = user_id;
		this.user_name = user_name;
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.type = type;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
