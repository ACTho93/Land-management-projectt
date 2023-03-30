package vn.edu.vinaenter.model.bean;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class Contact {

	private int id;
	
	@NotBlank
	private String fullname;
	
	@NotBlank
	@Email(message = "Chưa đúng định dạng mail!")
	private String emailto;
	
	private String subject;
	
	@NotBlank
	@Email(message = "Chưa đúng định dạng mail!")
	private String email;
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getZalo() {
		return zalo;
	}

	public void setZalo(String zalo) {
		this.zalo = zalo;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	private String zalo;
	
	private String facebook;
	
	
	@NotBlank
	private String content;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmailto() {
		return emailto;
	}

	public void setEmailto(String emailto) {
		this.emailto = emailto;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contact(int id, @NotBlank String fullname, @NotBlank String emailto, String subject, @NotBlank String email,
			String zalo, String facebook, @NotBlank String content) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.emailto = emailto;
		this.subject = subject;
		this.email = email;
		this.zalo = zalo;
		this.facebook = facebook;
		this.content = content;
	}


	

	
	
}
