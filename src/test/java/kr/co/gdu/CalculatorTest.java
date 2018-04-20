package kr.co.gdu;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
	
	//Calculator cal = new Calculator();

	Calculator cal;
	int a, b, result;
	
	@Before
	public void before() {
		System.out.println("before()");
		cal = new Calculator();
		a = 2;
		b = 6;
	}
	
	
	@Test
	public void test() {
		System.out.println("test()");
	
		/*result = cal.add(a, b);
		assertEquals(a+b, result);		
		result = cal.subtract(a, b);
		assertEquals(a-b, result);		
		result = cal.multiply(a, b);
		assertEquals(a*b, result);		
		result = cal.divide(a, b);
		assertEquals(a/b, result);			*/
		
		int add = cal.add(a, b);		// 2+6=8
		int sub = cal.subtract(add, b); // 8-6=2
		int mul = cal.multiply(sub, a); // 2*2=4
		int div = cal.divide(mul,a); 	// 4/2=2
		
		assertEquals(2, div);
		
	}
	
	@After
	public void after() {
		System.out.println("after()");
		
		
	}

}
