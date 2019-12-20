package com.java.chap9;

public class ClassEx {
	public ClassEx() {}
	
	public void wrapper1() {
		Integer i = new Integer(100);
		Integer i2 = new Integer(100);
		
		System.out.println("i==i2? " + (i==i2));
		System.out.println("i.equals(i2)? " + (i.equals(i2)));
		System.out.println("i.toString()= " + i.toString());
		
		System.out.println("MAX_VALUE= " + Integer.MAX_VALUE);
		System.out.println("MIN_VALUE= " + Integer.MIN_VALUE);
		System.out.println("SIZE= " + Integer.SIZE + "bits");
		System.out.println("TYPE= " + Integer.TYPE);
	} 
	
	public void wrapper2() {
		int i = new Integer("100").intValue();
		int i2 = Integer.parseInt("100");
		Integer i3 = Integer.valueOf("100");
		System.out.println(i + "/"+i2+"/"+i3);
		
		int i4 = Integer.parseInt("100",2);
		int i5 = Integer.parseInt("100", 8);
		int i6 = Integer.parseInt("100", 16);
		int i7 = Integer.parseInt("Ff", 16);
		System.out.println(i4+"/"+i5+"/"+i6+"/"+i7);
		
		Integer i9 = Integer.valueOf("100",2);
		Integer i10 = Integer.valueOf("100",8);
		Integer i11 = Integer.valueOf("100",16);
		System.out.println(i9 + "/"+i10+"/"+i11);
	}
	
	public void wrapper3() {
		int i = 10;
		
		Integer intg = (Integer)i;
		Object obj = (Object)i;
		
		Long lng = 100L;
		
		int i2 = intg + 10; // 참조형과 기본형간의 연산 가능
		long l = intg + lng; // 참조형간의 덧셈도 가능
		
		Integer intg2 = new Integer(20);
		int i3 = (int) intg2; // 참조형을 기본형으로 형변환(형변환 생략가능)
		
		System.out.println("i : " + i);
		System.out.println("intg : " + intg);
		System.out.println("obj : " + obj);
		System.out.println("lng : " + lng);
		System.out.println("intg+10 : " + i2);
		System.out.println("intg+lng : " + l);
		System.out.println("i3 : " + i3);
	}
}
