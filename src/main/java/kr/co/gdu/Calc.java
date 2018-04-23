package kr.co.gdu;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//숫자+문자 => 문자열로 변환 가능
// response.getWriter().append("result = " + result); -> 콘솔이 아닌 화면에 출력하도록 보내주는 것

public class Calc extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet()");

		// 아래 만든 action 의 함수 실행
		action(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost()");
	}

	void action(HttpServletRequest request, HttpServletResponse response) {
		String a = request.getParameter("a");
		String b = request.getParameter("b");
		String key = request.getParameter("key");

		boolean check = true;
		System.out.println("a : " + a + " b : " + b + " key : " + key);

		try {
			Calculator calc = new Calculator();
			int result = 0;
			// Integer.parseInt(a) => 문자를 숫자로 변경하기

//			switch (key) {
//			case "add":
//				result = calc.add(Integer.parseInt(a), Integer.parseInt(b));
//				break;
//			case "subtract":
//				result = calc.subtract(Integer.parseInt(a), Integer.parseInt(b));
//				break;
//			case "multiply":
//				result = calc.multiply(Integer.parseInt(a), Integer.parseInt(b));
//				break;
//			case "divide":
//				result = calc.divide(Integer.parseInt(a), Integer.parseInt(b));
//				break;
//
//			default:
//				check = false;
//				break;
//			}
			
			if (key.equals("add")) {
				result = calc.add(Integer.parseInt(a), Integer.parseInt(b));				
			}else if(key.equals("subtract")) {
				result = calc.subtract(Integer.parseInt(a), Integer.parseInt(b));
			}else if(key.equals("multiply")) {
				result = calc.subtract(Integer.parseInt(a), Integer.parseInt(b));
			}else if(key.equals("divide")) {
				result = calc.subtract(Integer.parseInt(a), Integer.parseInt(b));
			}
			
			

			System.out.println("result : " + result);

			response.setContentType("text/html; charset=UTF-8");

			String html = "<h1>결과 값 : " + result + " </h1>";
			html += "<a href = 'index.html'> 계산기로 이동!</a>";
			response.getWriter().append(html);

			// if(check) {
			// 내가 보내고자하는 속성 값!
			// 값까지 해서 처리해서 보낼거야!
			// request.setAttribute("result", result);

			// RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
			// rd.forward(request, response); //전달한다!
			// }else {
			// 해당 화면을 다시 보내기?
			// 내가 일 처리 못하겠어!!! 튕겨낼거야!!!! 저기 페이지로 가!!
			// response.sendRedirect("index.html");
			// }

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { // catch를 다 끝나면!
			System.out.println("종료");

		}

	}
}
