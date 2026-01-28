package model;

public class LoginDAO {

	private String userid;
	private String password;

	// DB로 부터 가져온 아이디 비번이 있다고 가정
	final String _userid = "myuser";
	final String _password = "12345";

	//로그인시 아이디가 회원의 아이디인지 -> 비번 일치
	public boolean checkUser() {
		
		if (userid.isEmpty() || password.isEmpty()) {
			System.out.println("전부 입력해주세요!");
			return false;
		} else if (userid.equals(_userid) && password.equals(_password)) {
			return true;
		} else {
			System.out.println("아이디 혹은 비밀번호가 일치하지 않습니다.");
			return false;
		}
	}
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
