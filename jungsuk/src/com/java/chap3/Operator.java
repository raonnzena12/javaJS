package com.java.chap3;

public class Operator {
	
	public Operator() {}
	
	public void operatorEx1() {
		int i = 5;
		i++; // i = i + 1;과 같은 의미이다. ++i로 바꿔 써도 결과는 같다.
		System.out.println(i);
		i = 5;
		++i;
		System.out.println(i);
	}
	
	public void operatorEx2() {
		int i = 5;
		int j = 0;
		j = i++;
		System.out.println("j=i++; 실행 후, i="+i+", j="+j);
		
		i = 5;
		j = 0;
		j = ++i;
		System.out.println("j=++i; 실행 후, i="+i+", j="+j);
	}
	
	public void operatorEx3() {
		int i = 5, j = 5;
		System.out.println(i++);
		System.out.println(++j);
		System.out.println("i="+i+", j="+j);
	}
	
	public void operatorEx4() {
		int i = -10;
		i = +i;
		System.out.println(i);
		i = -10;
		i = -i;
		System.out.println(i);
	}
	
	public void operatorEx5() {
		byte b = 10;
		System.out.println("b="+b);
		System.out.println("~b="+~b);
		System.out.println("~b+1="+(~b+1));
	}
	
	public void operatorEx6() {
		byte b = 10;
//		byte result = ~b;
		byte result = (byte)~b;
		
		System.out.println("b="+b+", ~b="+result);
	}
	
	public void operatorEx7() {
		boolean power = false;
		System.out.println(power);
		power = !power;
		System.out.println(power);
		power = !power;
		System.out.println(power);
	}
	
	public void operatorEx8() {
		byte a = 10;
		byte b = 20;
		byte c = (byte)(a+b);
		System.out.println(c);
	}
	
	public void operatorEx9() {
		byte a = 10;
		byte b = 30;
		byte c = (byte)(a*b);
		System.out.println(c);
	}
	
	public void operatorEx10() {
		int a = 1000000;
		int b = 2000000;
		long c = a*b;
		System.out.println(c);
	}
	
	public void operatorEx11() {
		long a = 1000000 * 1000000;
		long b = 1000000 * 1000000L;
		System.out.println(a);
		System.out.println(b);
	}
	
	public void operatorEx12() {
		int a = 1000000 * 1000000 / 1000000;
		int b = 1000000 / 1000000 * 1000000;
		System.out.println(a);
		System.out.println(b);
	}
	
	public void operatorEx13() {
		char c1 = 'a';
		char c2 = c1;
		char c3 = ' ';
		
		int i = c1 + 1;
		
		c3 = (char)(c1 + 1);
		c2++;
		c2++;
		
		System.out.println("i=" + i);
		System.out.println("c2=" + c2);
		System.out.println("c3=" + c3);
	}
	
	public void operatorEx14() {
		char c1 = 'a';
//		char c2 = c1 + 1;
		char c2 = 'a' + 1;
		System.out.println(c2);
	}
	
	public void operatorEx15() {
		char c = 'a';
		for ( int i = 0; i < 26 ; i++ ) {
			System.out.print(c++);
		}
		System.out.println();
		c = 'A';
		for ( int i = 0 ; i < 26 ; i++ ) {
			System.out.print(c++);
		}
		System.out.println();
		c = '0';
		for ( int i = 0 ; i < 10 ; i++ ) {
			System.out.print(c++);
		}
		System.out.println();
	}
	
	public void operatorEx16() {
		char lowerCase = 'a';
		char upperCase = (char)(lowerCase - 32);
		System.out.println(upperCase);
	}
	
	public void operatorEx17() {
		float pi = 3.141592f;
		float shortPi = (int)(pi*1000)/1000f;
		System.out.println(shortPi);
	}
	
	public void operatorEx18() {
		float pi = 3.141592f;
		float shortPi = Math.round(pi*1000) / 1000f;
		System.out.println(shortPi);
	}
	
	public void operatorEx19() {
		int share = 10 / 8;
		int remain = 10 % 8;
		System.out.println("10을 8로 나누면, ");
		System.out.println("몫은 " + share + "이고, 나머지는 " + remain + "입니다.");
	}
	
	public void operatorEx20() {
		for ( int i = 1 ; i <= 50 ; i++ ) {
			if ( i%3 == 0 ) System.out.print(i+" ");
		}
	}
	
	public void operatorEx21() {
		System.out.println(-10%8);
		System.out.println(10%-8);
		System.out.println(-10%-8);
	}
}
