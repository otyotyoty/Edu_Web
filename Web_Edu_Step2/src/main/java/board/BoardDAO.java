package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class BoardDAO {

	// 오라클 접속
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "member";
	String pass = "12345";

	Connection con; // 접속 설정
	PreparedStatement pstmt; // String -> Sql 로 형변환
	ResultSet rs; // 데이터 즉 결과값 리턴 받는 객체

	// ------------------------------------------------

	public void getCon() {
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, pass);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}// getCon

	// ----------------------------------------------------------------------------------
	// #1 전체 게시글 개수
	public int getallCount() {

		getCon();
		int count = 0;

		try {

			// 쿼리
			String sql = "select count(*) from board";
			pstmt = con.prepareStatement(sql); // sql

			// 쿼리 결과 받기
			rs = pstmt.executeQuery(); // sql 결과

			if (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}

	// ----------------------------------------------------------------------------------
	// #2. 전체 게시글 가져오기
	public Vector<BoardDTO> getAllBoard(int startRow, int endRow) {

		getCon();
		Vector<BoardDTO> v = new Vector<BoardDTO>();

		try {
			// Rownum : 오라클에만 존재
			String sql = "SELECT * FROM (SELECT A.* ,Rownum Rnum FROM (SELECT * FROM board ORDER BY ref desc, re_step asc) A) WHERE Rnum >= ? and Rnum <= ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// 오라클에서 데이터를 가져와서 DTO에 저장
				BoardDTO bean = new BoardDTO();
				bean.setNum(rs.getInt(1));
				bean.setWriter(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setSubject(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setReg_date(rs.getDate(6).toString());
				bean.setRef(rs.getInt(7));
				bean.setRe_step(rs.getInt(8));
				bean.setRe_level(rs.getInt(9));
				bean.setReadcount(rs.getInt(10));
				bean.setContent(rs.getString(11));
				// 저장된 객체를 벡터배열방에 담기
				v.add(bean);
			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return v;
	}// getAllBoard

	// ----------------------------------------------------------------------------------
	// #3. 게시글 입력(insert into)
	public void insertBoard(BoardDTO bean) {

		getCon();

		int ref = 0;
		int re_step = 1;
		int re_level = 1;

		try {
			String sql = "insert into board values(board_seq.nextval,?,?,?,?,sysdate,?,?,?,0,?)";
			pstmt = con.prepareStatement(sql);

			// ?
			pstmt.setString(1, bean.getWriter());
			pstmt.setString(2, bean.getEmail());
			pstmt.setString(3, bean.getSubject());
			pstmt.setString(4, bean.getPassword());
			pstmt.setInt(5, ref);
			pstmt.setInt(6, re_step);
			pstmt.setInt(7, re_level);
			pstmt.setString(8, bean.getContent());

			pstmt.executeUpdate();

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}// insertBoard

}
