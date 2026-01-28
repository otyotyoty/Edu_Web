package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class MemberDAO {

	// 오라클 접속
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "system";
	String pass = "12345";

	Connection con; // 접속 설정
	PreparedStatement pstmt; // String -> Sql 로 형변환
	ResultSet rs; // 데이터 즉 결과값 리턴 받는 객체

	// ---------------------------------------------------

	public void getCon() {
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, pass);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}// getCon

	// ---------------------------1.insert(C)---------------------------
	// 입력
	public void insertMember(MemberDTO mDTO) {

		try {
			// 연동
			getCon();
			// ---------------------------
			String sql = "insert into member values(?,?,?,?,?,?,?,?,?,?,?)";
			// String -> sql
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, mDTO.getId()); // MemberDTO
			pstmt.setString(2, mDTO.getPass1());
			pstmt.setString(3, mDTO.getPass2());
			pstmt.setString(4, mDTO.getEmail());
			pstmt.setString(5, mDTO.getGender());
			pstmt.setString(6, mDTO.getAddress());
			pstmt.setString(7, mDTO.getPhone());
			pstmt.setString(8, mDTO.getHobby());
			pstmt.setString(9, mDTO.getJob());
			pstmt.setString(10, mDTO.getAge());
			pstmt.setString(11, mDTO.getInfo());

			pstmt.executeUpdate(); // 오라클에 데이터 전달. 오라클에서 ctrl+enter 하는거랑 같음
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// --------------2.select(R)-----------------------
	public Vector<MemberDTO> allSelectMember() {

		Vector<MemberDTO> v = new Vector<MemberDTO>();

		try {
			getCon();

			String sql = "select * from member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MemberDTO bean = new MemberDTO();
				bean.setId(rs.getString(1));
				bean.setPass1(rs.getString(2));
				bean.setPass2(rs.getString(3));
				bean.setEmail(rs.getString(4));
				bean.setGender(rs.getString(5));
				bean.setAddress(rs.getString(6));
				bean.setPhone(rs.getString(7));
				bean.setHobby(rs.getString(8));
				bean.setJob(rs.getString(9));
				bean.setAge(rs.getString(10));
				bean.setInfo(rs.getString(11));

				v.add(bean);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return v;

	}// allSelectMember

	// --------------3.select(상세정보)-----------------------
	public MemberDTO oneSelectMember(String id) {

		MemberDTO bean = new MemberDTO();

		try {
			getCon();

			String sql = "select * from member where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				bean.setId(rs.getString(1));
				bean.setPass1(rs.getString(2));
				bean.setPass2(rs.getString(3));
				bean.setEmail(rs.getString(4));
				bean.setGender(rs.getString(5));
				bean.setAddress(rs.getString(6));
				bean.setPhone(rs.getString(7));
				bean.setHobby(rs.getString(8));
				bean.setJob(rs.getString(9));
				bean.setAge(rs.getString(10));
				bean.setInfo(rs.getString(11));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bean;
	}

	// --------------4.비밀번호 일치여부 체크-----------------------

	public String getPass(String id) {

		String pass = "";

		try {
			getCon();

			// 해당 id 회원의 pass1을 select로 받기 => jsp에서 pass2와 같은지 비교

			String sql = "select * from member where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				pass = rs.getString(2);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return pass;

	}// getPass

	// --------------5.업데이트-----------------------

	public void updateMember(MemberDTO bean) {
		try {
			getCon();

			String sql = "update member set email=?, phone=?, address=? where id=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getEmail());
			pstmt.setString(2, bean.getPhone());
			pstmt.setString(3, bean.getAddress());
			pstmt.setString(4, bean.getId());
			
			pstmt.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	// --------------6.삭제하기-----------------------

	public void deleteMember(String id) {
		
		try {
			getCon();
			
			String sql = "delete from member where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
			con.close();
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}//deleteMember

}
