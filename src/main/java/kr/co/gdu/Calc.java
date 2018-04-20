package kr.co.gdu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Calc extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()");
		String a = request.getParameter("a");
		String b = request.getParameter("b");
		String key=  request.getParameter("key");
		System.out.println("a : " + a+ " b : "+b+" key : "+key);
		
		Calculator calc = new Calculator();
		int result=0;
		//Integer.parseInt(a) => 문자를 숫자로 변경하기
	
		switch (key) {
		case "add" :
			 result = calc.add(Integer.parseInt(a) ,Integer.parseInt(b));
			break;
		case "subtract" :
			 result = calc.subtract(Integer.parseInt(a) ,Integer.parseInt(b));
			break;
		case "multiply" :
			 result = calc.multiply(Integer.parseInt(a) ,Integer.parseInt(b));
			break;
		case "divide" :
			 result = calc.divide(Integer.parseInt(a) ,Integer.parseInt(b));
			break;

		default:
			break;
		}
		
		
		System.out.println("result : "+result);
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()");
	}

}
