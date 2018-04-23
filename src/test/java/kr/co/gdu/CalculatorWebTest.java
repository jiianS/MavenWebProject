package kr.co.gdu;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class CalculatorWebTest {

	// @mock은 하나당 하나!!
	@Mock
	HttpServletRequest request;

	@Mock
	HttpServletResponse response;

	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test() throws ServletException, IOException {
		when(request.getParameter("a")).thenReturn("3");
		when(request.getParameter("b")).thenReturn("6");
		when(request.getParameter("key")).thenReturn("add");
		
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		
		when(response.getWriter()).thenReturn(pw);
		
		Calc calc = new Calc();
		calc.doGet(request, response);
		
		System.out.println(sw);
	}
	

	@After
	
	public void after() {

	}

}
