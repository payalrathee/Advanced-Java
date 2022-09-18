package beans;

import javax.persistence.*;

@Entity
public class User {
	@Id
	private String email;
	private String name;
	@Column(nullable=false)
	private String mobile;
	private String pwd;
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User( String name, String email, String mobile, String pwd) {
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
