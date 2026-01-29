package board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardWriteProcCon
 */
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
		
		//---------------JSP(Front)---------------
		
		String writer=request.getParameter("writer");
		String subject=request.getParameter("subject");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String content=request.getParameter("content");
		
		BoardDTO bean=new BoardDTO();
		//---------------JAVA(Back)---------------
		bean.setWriter(writer);
		bean.setSubject(subject);
		bean.setEmail(email);
		bean.setPassword(password);
		bean.setContent(content);
		
		//---------------Model(Database)---------------
		BoardDAO bdao=new BoardDAO();
		bdao.insertBoard(bean);
		
		//글번호 처리("BoardListCon.do")
		RequestDispatcher dis = request.getRequestDispatcher("BoardListCon.do");
		dis.forward(request, response); // 정보 다가져감
		
	}
}
