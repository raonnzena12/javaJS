package com.java.chap4;

public class Flow {
	public Flow() {}
	
	public void flow21() {
		int i = 10;
		while ( i >= 0 ) {
			System.out.println(i--);
		}
	}
	
	public void flow22() {
		int i = 2;
		while ( i <= 9 ) {
			int j = 1;
			while ( j <= 9 ) {
				System.out.println(i+"*"+j+"="+i*j);
				j++;
			}
			i++;
		}
	}
	
	public void flow23() {
		int sum = 0;
		int i = 0;
		while ( sum + i <= 100 ) {
			sum += ++i;
			System.out.println(i + "-" + sum);
		}
	}
	
	public void flow24() throws Throwable {
		int input = 0;
		System.out.println("문장을 입력하세요");
		System.out.println("입력을 마치려면 x를 입력하세요");
		do {
			input = System.in.read();
			System.out.println((char)input);
		} while ( input != -1 && input != 'x');
	}
	
	public void flow25() {
		int sum = 0;
		int i = 0;
		while(true) {
			if ( sum > 100 ) break;
			++i;
			sum += i;
		}
		System.out.println("i = " + i);
		System.out.println("sum = " + sum);
	}
	
	public void flow26() {
		for ( int i = 0; i <= 10 ; i++ ) {
			if ( i%3 == 0 ) continue;
			System.out.println(i);
		}
	}
	
	public void flow27() {
		Loop1 : for ( int i = 2; i <= 9 ; i++ ) {
			for ( int j = 1; j <= 9; j++ ) {
				if ( j == 5 ) 
					break Loop1;
//					break;
//					continue Loop1;
//					continue;
				System.out.println(i+"*"+j+"="+i*j);
			}
			System.out.println();
		}
	}
}
