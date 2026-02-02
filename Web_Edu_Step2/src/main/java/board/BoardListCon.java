package board;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BoardListCon.do")
public class BoardListCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void reqPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 한 화면에 보여지는 게시글의 페이지 = 10개씩
		int pageSize = 10;
		// 현재 보여지는 페이지 번호
		String pageNum = request.getParameter("pageNum"); // [1][2]
		if (pageNum == null) {
			pageNum = "1"; // 최신글을 가져옴
		}
		// 총 게시글의 갯수를 지정
		int count = 0;
		// 화면에 보여지는 글번호 숫자의 위치
		int number = 0;
		// 페이지의 번호를 형변환
		int currentPage = Integer.parseInt(pageNum);

		// DAO객체
		BoardDAO bdao = new BoardDAO();
		// 총 게시글의 숫자를 가져옴
		count = bdao.getallCount();
		// -------------------------------------

		// 현재 보여질 페이지의 시작번호
		// 1페이지 => 1: (1-1)*10+1
		// 2페이지 =>11: (2-1)*10+1
		// 3페이지 =>21: (3-1)*10+1
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;
		// 최신글 10개 기준으로 게시글을 리턴하는 메소드 호출
		Vector<BoardDTO> v = bdao.getAllBoard(startRow, endRow);
		// ------------------------------------------
		// 9개의 게시글로 가정시 => 9-(1-1)*10 =>9
		// 11개의 게시글로 가정시 => 11-(2-1)*10=>1
		// 23개의 게시글로 가정시 => 23-(3-1)*10=>3
		number = count - (currentPage - 1) * pageSize;

		// 수정/삭제시 비번 일치하지 않았을 경우 메세지
		String msg = (String) request.getAttribute("msg"); // 0
		
		//JSP저장:boardList.jsp에서 사용할 데이터를 저장(request);
		request.setAttribute("number", number); //1
		request.setAttribute("count", count);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("msg", msg);
		request.setAttribute("v", v); //전체 게시글
		
		//JSP로 포워딩
		RequestDispatcher dis=request.getRequestDispatcher("BoardList.jsp");
		dis.forward(request, response);
		
//		이름			의미				JSP에서 하는 역할
//		number		글 번호 시작값		번호 컬럼 출력. 게시글 번호 = 전체 글 개수부터 1까지 감소. 항상 최신 글이 가장 큰 번호
//		count		전체 글 개수		총 글 수, 페이지 계산
//		currentPage	현재 페이지			페이지 표시
//		pageSize	페이지당 글 수(10)	페이징 계산
//		msg			알림 메시지			오류 안내
//		v			게시글 목록	글 		리스트 출력
		
		
		
		
		
	}

}