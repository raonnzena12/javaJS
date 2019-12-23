package com.java.chap10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class Coll {
	public Coll() {}
	
	public void print(ArrayList list1, ArrayList list2) {
		System.out.println("list1 : " + list1);
		System.out.println("list2 : " + list2);
		System.out.println();
	}
	
	public void print(Vector v) {
		System.out.println(v);
		System.out.println("size : " + v.size());
		System.out.println("capacity : " + v.capacity());
	}
	
	public void arraylist1() {
		ArrayList list1 = new ArrayList(10);
		list1.add(new Integer(5));
		list1.add(new Integer(4));
		list1.add(new Integer(2));
		list1.add(new Integer(0));
		list1.add(new Integer(1));
		list1.add(new Integer(3));
		
		ArrayList list2 = new ArrayList(list1.subList(1, 4));
		print(list1, list2);
		
		Collections.sort(list1);
		Collections.sort(list2);
		print(list1, list2);
		
		System.out.println("list1.containsAll(list2) : " + list1.containsAll(list2));
		
		list2.add("B");
		list2.add("C");
		list2.add(3, "A");
		print(list1, list2);
		
		list2.set(3, "AA");
		print(list1, list2);
		
		System.out.println("list1.retainAll(list2) : " +list1.retainAll(list2));
		print(list1, list2);
		
		for ( int i = list2.size() - 1 ; i >= 0 ; i-- ) {
			if ( list1.contains(list2.get(i)) ) {
				list2.remove(i);
			}
		}
		print(list1, list2);
	}
	
	public void arrayList2() {
		final int LIMIT = 10;
		String source = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int length = source.length();
		
		List list = new ArrayList (length/LIMIT + 10 ) ;
		
		for ( int i = 0 ; i < length; i+= LIMIT ) {
			if ( i + LIMIT < length ) {
				list.add(source.substring(i, i+LIMIT));
			} else {
				list.add(source.substring(i));
			}
		}
		
		for ( int i = 0 ; i < list.size(); i++ ) {
			System.out.println(list.get(i));
		}
	}

	public void vector1() {
		Vector v = new Vector(5);
		v.add("1");
		v.add("2");
		v.add("3");
		print(v);
		
		v.trimToSize();
		System.out.println("=== after trimToSize() ===");
		print(v);
		
		v.ensureCapacity(6);
		System.out.println("=== after ensureCapacity(6) ===");
		print(v);
		
		v.setSize(7);
		System.out.println("=== after setSize(7) ===");
		print(v);
		
		v.clear();
		System.out.println("=== after clear() ===");
		print(v);
	}
	
	public void copyTest() {
		int[] data = {0, 1, 2, 3, 4};
		int[] sCopy = null;
		int[] dCopy = null;
		
		sCopy = shallowCopy(data);
		dCopy = deepCopy(data);
		
		System.out.println("Original:" + Arrays.toString(data));
		System.out.println("Shallow:" + Arrays.toString(sCopy));
		System.out.println("Deep:" + Arrays.toString(dCopy));
		System.out.println();
		
		data[0] = 5;
		System.out.println("Original:" + Arrays.toString(data));
		System.out.println("Shallow:" + Arrays.toString(sCopy));
		System.out.println("Deep:" + Arrays.toString(dCopy));
	}
	
	public int[] shallowCopy(int[] arr) {
		return arr;
	}
	
	public int[] deepCopy(int[] arr) {
		if ( arr == null ) return null;
		int[] result = new int[arr.length];
		
		System.arraycopy(arr, 0, result, 0, arr.length);
		return result;
	}
	
	public void arrayListAndLinkedList() {
		ArrayList al = new ArrayList(1000000);
		LinkedList ll = new LinkedList();
		
		System.out.println("=== 순차적으로 추가하기 ===");
		System.out.println("ArrayList : " + add1(al));
		System.out.println("LinkedList : " + add1(ll));
		System.out.println();
		System.out.println("=== 중간에 추가하기 ===");
		System.out.println("ArrayList : " + add2(al));
		System.out.println("LinkedList : " + add2(ll));
		System.out.println();
		System.out.println("=== 중간에서 삭제하기 ===");
		System.out.println("ArrayList : " + remove2(al));
		System.out.println("LinkedList : " + remove2(ll));
		System.out.println();
		System.out.println("=== 순차적으로 삭제하기 ===");
		System.out.println("ArrayList : " + remove1(al));
		System.out.println("LinkedList : " + remove1(ll));
	}
	
	public long add1(List list) {
		long start = System.currentTimeMillis();
		for ( int i = 0 ; i < 100000 ; i++ ) list.add(i+"");
		long end = System.currentTimeMillis();
		return end-start;
	}
	
	public long add2(List list) {
		long start = System.currentTimeMillis();
		for ( int i = 0 ; i < 1000 ; i++ ) list.add(500, "x");
		long end = System.currentTimeMillis();
		return end-start;
	}
	
	public long remove1(List list) {
		long start = System.currentTimeMillis();
		for (int i = list.size()-1 ; i > 0 ; i-- ) list.remove(i);
		long end = System.currentTimeMillis();
		return end-start;
	}
	
	public long remove2(List list) {
		long start = System.currentTimeMillis();
		for ( int i = 0 ; i < 1000 ; i++ ) list.remove(i);
		long end = System.currentTimeMillis();
		return end - start;
	}
	
	public Stack back = new Stack();
	public Stack forward = new Stack();
	public void stackex1() {
		
		goURL("1.네이트");
		goURL("2.야후");
		goURL("3.네이버");
		goURL("4.다음");
		
		printStatus();
		
		goBack();
		System.out.println("=== 뒤로가기 버튼을 누른 후 ===");
		printStatus();
		
		goBack();
		System.out.println("=== '뒤고' 버튼을 누른 후 ===");
		printStatus();
		
		goForward();
		System.out.println("=== '앞으로'버튼을 누른 후 === ");
		printStatus();
		
		goURL("javachobo.com");
		System.out.println("=== 새로운 주소로 이동 후 ===");
		printStatus();
	}
	
	public void printStatus() {
		System.out.println("back:" + back);
		System.out.println("forward:" + forward);
		System.out.println("현재화면은'"+back.peek()+"'입니다.");
		System.out.println();
	}
	
	public void goURL(String url) {
		back.push(url);
		if ( !forward.empty() ) {
			forward.clear();
		}
	}
	
	public void goForward() {
		if ( !forward.empty() ) {
			back.push(forward.pop());
		}
	}
	
	public void goBack() {
		if ( !back.empty() ) {
			forward.push(back.pop());
		}
	}
}
