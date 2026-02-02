package board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BoardWriteProcCon.do")
public class BoardWriteProcCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		reqPro(request, response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		request.setCharacterEncoding("utf-8");
		
		//-------------JSP(Front)---------------
		//String writer=request.getParameter("writer");
		String subject=request.getParameter("subject");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String content=request.getParameter("content");
		
		BoardDTO bean=new BoardDTO();
		//------------JAVA(Back)----------------
		bean.setWriter(request.getParameter("writer"));
		bean.setSubject(subject);
		bean.setEmail(email);
		bean.setPassword(password);
		bean.setContent(content);
		
		//------------Modle(Database)-------------------
		BoardDAO bdao=new BoardDAO();
		bdao.insertBoard(bean);
		
		//글쓰기 완료 후 글번호 처리 ("BoardListCon.do")로 이동
		response.sendRedirect("BoardListCon.do");
		
		
	}

}