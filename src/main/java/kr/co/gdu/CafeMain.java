package kr.co.gdu;

import java.util.Scanner;

public class CafeMain {

	public static void main(String[] args) {
		Cafe t = new Cafe();
		
		int a = 0;
		int l = 0;
		int i = 0;
		int j = 0;
		
		int a_jan=0;
		int l_jan=0;
		
		int total;
		Scanner scan = new Scanner(System.in);
		System.out.println("어서오세요 ^^");

		while (true) {
		while (true) {
			System.out.println("1. Americano or 2. Latte 3. 주문 끝");
			String select = scan.next();
			
			if (select.equals("1")) {
				System.out.println("몇 잔드실?");
				while (true) {
				try { 
					i = scan.nextInt();
					break;
				}catch(Exception e) {
					System.out.println("재입력하세요.");
					
					scan = new Scanner(System.in);
				}
				}
				
				a += t.americano(i);
				a_jan+=i;
				
			} else if (select.equals("2")) {
				System.out.println("몇 잔드실?");
				while (true) {
					try { 
						j = scan.nextInt();
						break;
					}catch(Exception e) {
						System.out.println("재입력하세요.");
						
						scan = new Scanner(System.in);
					}
					}
				
				l += t.latte(j);
				l_jan += j;
				
			} else if (select.equals("3")) {	
				break;

			} else  {
				System.out.println("숫자 잘못 입력!!");	
				continue;
			}

		}
		if (a != 0 || l != 0) { 
			total = t.total(a, l, a_jan, l_jan);
	
			System.out.println("얼마 내실건가요?");
			int pay = scan.nextInt();
			
			t.change(pay, total);

		} else {
			System.out.println("");
		}
		
		System.out.println("더 주문하실건가요? (y)");
		String select = scan.next();
		if (select.equals("y")) {
			continue;
		}
		else {
			System.out.println("안녕히 가세요^^");
			break;
		}
			
	}
		
	}

}
