package javaapi;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalendarServlet")
public class CalendarServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 현재 날짜 정보
		Calendar today = Calendar.getInstance();

		// 파라미터로 연도/월이 넘어오면 해당 날짜, 아니면 오늘
		String yearParam = request.getParameter("year");
		String monthParam = request.getParameter("month");

		int year = yearParam != null ? Integer.parseInt(yearParam) : today.get(Calendar.YEAR);
		int month = monthParam != null ? Integer.parseInt(monthParam) : (today.get(Calendar.MONTH) + 1);

		// 선택된 날짜 (클릭한 날짜)
		String selectedDay = request.getParameter("day");

		// 달력 계산
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, 1); // month는 0부터 시작

		int firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1(일) ~ 7(토)
		int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		// 이전달/다음달 계산
		int prevYear = year;
		int prevMonth = month - 1;
		if (prevMonth < 1) {
			prevMonth = 12;
			prevYear--;
		}

		int nextYear = year;
		int nextMonth = month + 1;
		if (nextMonth > 12) {
			nextMonth = 1;
			nextYear++;
		}

		// 오늘 날짜
		int todayYear = today.get(Calendar.YEAR);
		int todayMonth = today.get(Calendar.MONTH) + 1;
		int todayDay = today.get(Calendar.DATE);

		// JSP로 데이터 전달
		request.setAttribute("year", year);
		request.setAttribute("month", month);
		request.setAttribute("firstDayOfWeek", firstDayOfWeek);
		request.setAttribute("daysInMonth", daysInMonth);
		request.setAttribute("prevYear", prevYear);
		request.setAttribute("prevMonth", prevMonth);
		request.setAttribute("nextYear", nextYear);
		request.setAttribute("nextMonth", nextMonth);
		request.setAttribute("todayYear", todayYear);
		request.setAttribute("todayMonth", todayMonth);
		request.setAttribute("todayDay", todayDay);
		
		if (selectedDay != null) {
            request.setAttribute("selectedDay", selectedDay);
            request.setAttribute("selectedDate", year + "년 " + month + "월 " + selectedDay + "일");
        }
        
        request.getRequestDispatcher("calendar.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }
		
		


}
