package com.java.chap2;

public class Variable {
	public Variable() { }
	
	public void charToCode2_1() {
		char ch = 'A';
		int code = (int)ch;
		
		System.out.println(ch);
		System.out.println(code);
	}
	
	public void charToCode2_2() {
		int code = 65; // 또는 int code = 0x0041;
		char ch = (char)code;
		
		System.out.println(code);
		System.out.println(ch);
	}
	
	public void charToCodeTest() {
		for ( int i = 0 ; i < 65536 ; i++ ) {
			System.out.print((char)i);
			System.out.print(' ');
			if ( i%20 == 0 && i != 0 ) System.out.println();
		}
	}
	
	public void specialChar() {
		char single = '\'';
		String dblQuote = "\"Hello\"";
		String root = "c:\\";
		
		System.out.println(single);
		System.out.println(dblQuote);
		System.out.println(root);
	}
	
	public void stringTest() {
		String a = 7 + " ";
		String b = " " + 7;
		String c = 7 + "";
		String d = "" + 7;
		String e = "" + "";
		String f = 7 + 7 + "";
		String g = "" + 7 + 7;
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		System.out.println(g);
	}
	
	public void byteOverFlow() {
		byte b = 0; // byte형 변수 b를 선언하고 0으로 초기화
		int i = 0;
		
		//반복문을 이용해서 b의 값을 1씩, 0부터 270까지 증가시킨다.
		for ( int x = 0; x <= 270 ; x++ ) {
			System.out.print(b++);
			System.out.print('\t');
			System.out.println(i++);
		}
	}
	
	public void precisionTest() {
		float f = 1.2345678901234567890f;
		double d = 1.2345678901234567890;
		float f2 = 0.100000001f;
		double d2 = 0.100000001;
		double d3 = 0.1000000000000001;
		
		System.out.println(f);
		System.out.println(d);
		System.out.println(f2);
		System.out.println(d2);
		System.out.println(d3);
	}
	
	public void castingEx1() {
		double d = 100.0;
		int i = 100;
		int result = i + (int)d;
		System.out.println("d="+d);
		System.out.println("i="+i);
		System.out.println("result="+result);
	}
	
	public void castingEx2() {
		byte b = 10;
		int i = (int)b;
		System.out.println("i="+i);
		System.out.println("b="+b);
		
		int i2 = 300;
		byte b2 = (byte)i2;
		System.out.println("i2="+i2);
		System.out.println("b2="+b2);
	}
	
	public void testtest() {
		System.out.println("1" + "2");
		System.out.println(true + "");
		System.out.println('A' + 'B');
		System.out.println('1' + 2);
		System.out.println('1' + '2');
		System.out.println('J'+"ava");
		System.out.println("" + true + null);
	}
}
