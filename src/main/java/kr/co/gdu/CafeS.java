package kr.co.gdu;

import static org.mockito.Mockito.mockitoSession;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CafeS extends HttpServlet {

	Cafe cafe = new Cafe();
	int ame, latte;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet()");
		
		try {
			if (Integer.parseInt(request.getParameter("ame")) > 0 || Integer.parseInt(request.getParameter("latte")) > 0 ) {
				ame = Integer.parseInt(request.getParameter("ame"));
				latte = Integer.parseInt(request.getParameter("latte"));
				action(request, response);
			}
			if (request.getParameter("pay") != null ) {
				action2(request, response);
			}
			
			//if (Integer.parseInt(request.getParameter("ame")) == 0 && Integer.parseInt(request.getParameter("latte")) == 0) {
			//	response.sendRedirect("indexCafe.html");
			//}
			
			

		} catch (Exception e) {
			if (request.getParameter("ame") == null)
				ame = 0;
			if (request.getParameter("latte") == null)
				latte = 0;
			
			/*
			if (ame == 0 && latte == 0) {
				response.sendRedirect("indexCafe.html");
			}
			*/
			action2(request, response);	
			
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost()");
	}

	void action(HttpServletRequest request, HttpServletResponse response) {

		
		System.out.println("아메리카노 : " + ame + " 라떼: " + latte);

		try {
		
			int result = 0;
			int total =cafe.total(cafe.americano(ame), cafe.latte(latte), ame, latte);

			response.setContentType("text/html; charset=UTF-8");			
			request.setAttribute("total", total);
				
			System.out.println(total);
			RequestDispatcher rd = request.getRequestDispatcher("resultCafe.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally { // catch를 다 끝나면!
			System.out.println("종료");

		}

	}

	void action2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int total = Integer.parseInt(request.getParameter("total"));
		int pay = Integer.parseInt(request.getParameter("pay"));
		
	//	System.out.println(">???"+total+pay);
		String change = cafe.change(pay, total);
		
		request.setAttribute("total", total);
		request.setAttribute("change", change);
		RequestDispatcher rd2 = request.getRequestDispatcher("resultCafe.jsp");
		rd2.forward(request, response);

	}

}
