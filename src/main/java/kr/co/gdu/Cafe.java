package kr.co.gdu;

import java.util.ArrayList;
import java.util.List;

public class Cafe{

	public int americano(int a) {
		int result = 1800 * a;
		System.out.println("아메리카노 " + a + "잔 " + result + "원");
		return result;

	}
	

	public int latte(int a) {

		int result = 2300 * a;
		System.out.println("라떼 " + a + "잔 " + result + "원");
		return result;

	}

	public int total(int a, int b, int c, int d) {
		int result = a + b;
		System.out.println("아메리카노: "+ c + "잔, 라떼: " + d+ "잔");
		System.out.println("총 금액" + result + "원 입니다.");
		return result;
	}

	
	public String change(int pay, int price) {
		int change =  pay - price;
		
		int[] coin = {10000,5000,1000,500,100};
		int[] count = {0,0,0,0,0};
	
		int a = 0;
		if (pay == price) {
			System.out.println("금액을 딱 맞게 받았습니다.");
		}
		else if (pay > price) {
			for (int i =0; i < coin.length; i ++) {
				if (change >= coin[i]) {
					a = change % coin[i];
					count[i] = (change-a) / coin[i];
					change -= coin[i] * count[i];
				}
			}
			 
			String result="[거스름돈]<br> 10000원" + count[0] + "개<br>";
			result += "5000원" + count[1] + "개<br>";
			result +="1000원" + count[2] + "개<br>";
			result +="500원" + count[3] + "개<br>";
			result +="100원" + count[4] + "개<br>";
			
			return result;
		}
		else {
			String result = "돈이 부족합니다.";
			return result;
		}
		return null;
		
	}

}
