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

	// -----------------------------------------------
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

	// ---------------------------------------------
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

	// ----------------------------------------------
	// #3. 게시글 입력(insert into)
	public void insertBoard(BoardDTO bean) {

		getCon();

		int ref = 0;
		int re_step = 1;
		int re_level = 1;

		try {

			// 먼저 시퀀스 값을 가져와서 num과 ref에 동일하게 사용
			String seqSql = "select board_seq.nextval from dual";
			pstmt = con.prepareStatement(seqSql);
			rs = pstmt.executeQuery();

			int num = 0;
			if (rs.next()) {
				num = rs.getInt(1);
			}
			ref = num; // ref를 num과 동일하게 설정 (최신글이 위로)
			// -------------------------------------------------------------
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

	// -------------------상세정보-----------------------
	// #4. getOneBoard(num)

	public BoardDTO getOneBoard(int num) {

		getCon();
		BoardDTO bean = new BoardDTO();

		try {

			// 게시글을 읽었다는 조회수 증가
			String countsql = "update board set readcount=readcount+1 where num=?";
			pstmt = con.prepareStatement(countsql);

			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			// ----------------------------------------------
			// 상세정보
			String sql = "SELECT * FROM board where num=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);

			rs = pstmt.executeQuery(); // 오라클에서 가져옴

			if (rs.next()) {
				// 오라클에서 데이터를 가져와서 DTO bean에 저장
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
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bean;

	}// getOneBoard

	// -----------------------------------------------
	// #5.조회수 증가하지 않는 업데이트

	public BoardDTO getOneUpdateBoard(int num) {

		getCon();
		BoardDTO bean = new BoardDTO();

		try {

			// 게시글을 읽었다는 조회수 증가
			String sql = "select * from board where num=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				// 오라클에서 데이터를 가져와서 DTO bean에 저장
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
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bean;

	}// getOneUpdateBoard

	// --------------------------------------------------

	public void UpdateBoard(int num, String subject, String content) {

		getCon();

		try {

			String sql = "update board set subject=?, content=? where num=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, subject);
			pstmt.setString(2, content);
			pstmt.setInt(3, num);

			pstmt.executeUpdate();

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}// UpdateBoard

	// ---------------------------------------------------
	// #6. 삭제: deleteBoard

	public void deleteBoard(int num) {

		getCon();

		try {

			// 쿼리준비
			String sql = "delete from board where num=?";
			// 쿼리실행할객체 선언
			pstmt = con.prepareStatement(sql);
			// 쿼리 실행전 ? 값대입
			pstmt.setInt(1, num);
			// 쿼리실행
			pstmt.executeUpdate();
			// 자원반납
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}