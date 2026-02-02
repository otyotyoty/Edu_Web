package board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BoardUpdateProcCon.do")
public class BoardUpdateProcCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int num = Integer.parseInt(request.getParameter("num"));
		String pass=request.getParameter("pass"); //오라클에 등록되어 있는 게시글 비번
		String password=request.getParameter("password"); //jsp에서 넘어온 비번
		String subject=request.getParameter("subject"); 
		String content=request.getParameter("content"); 
		
		if(pass.equals(password)) {
			BoardDAO bdao=new BoardDAO();
			bdao.UpdateBoard(num, subject, content); //update board set subject=?, content=? where num=?
			
			response.sendRedirect("BoardListCon.do");
		}else {
			request.setAttribute("msg", "0");
			
			RequestDispatcher dis = request.getRequestDispatcher("BoardListCon.do");
            dis.forward(request, response);
		}
		
		
		
		
	}

}




