package model;

public class Member {
	
	private String name;
	private String email;
	
	public Member() {
		name="솔데스크";
		email="soldesk@soldesk.net";
	}

	public Member(String name, String email) {
		super();
		this.name = name;
		this.email = email;
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
	
	

}
