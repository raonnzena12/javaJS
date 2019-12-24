package com.java.chap10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
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
	
	public void treeSetLotto() {
		Set<Integer> set = new TreeSet();
		
		for ( int i = 0 ; set.size() < 6 ; i++ ) {
			int num = (int)(Math.random() * 45) +1;
			set.add(new Integer(num));
		}
		System.out.println(set);
	}
	
	public void treeset1() {
		TreeSet set = new TreeSet();
		
		String from = "b";
		String to = "d";
		
		set.add("abc");
		set.add("alien");
		set.add("bat");
		set.add("car");
		set.add("Car");
		set.add("disc");
		set.add("dance");
		set.add("dZZZZ");
		set.add("dzzzz");
		set.add("elephant");
		set.add("selevator");
		set.add("fan");
		set.add("flower");
		
		System.out.println(set);
		System.out.println("range search : from " + from +" to "+ to);
		System.out.println("result1 : " + set.subSet(from, to));
		System.out.println("result2 : " + set.subSet(from, to+"zzz"));
	}
	
	public void asciiprint() {
		char ch = ' ';
		// 공백 이후의 문자들을 출력한다.
		for ( int i = 0 ; i < 95 ; i++ ) {
			System.out.print(ch++);
		}
	}
	
	public void treeset2() {
		TreeSet set = new TreeSet();
		int[] score = { 80, 95, 50, 35, 45, 65, 10, 100 };
		
		for ( int i = 0 ; i < score.length ; i++ ) {
			set.add(new Integer(score[i]));
		}
		System.out.println("50보다 작은 값 : " + set.headSet(new Integer(50)));
		System.out.println("50보다 큰 값 : " + set.tailSet(new Integer(50)));
	}
	
	public void comparator1() {
		TreeSet set1 = new TreeSet();
		TreeSet set2 = new TreeSet(new Descending());
		
		int [] score = { 20, 50, 30, 10, 40, 1, 500, 204, 034, 57};
		
		for ( int i = 0 ; i < score.length ; i++ ) {
			set1.add(new Integer(score[i]));
			set2.add(new Integer(score[i]));
		}
		
		System.out.println("Set1 : " + set1);
		System.out.println("Set2 : " + set2);
	}
	
	class Descending implements Comparator {
		public Descending() {}
		
		public int compare(Object o1, Object o2) {
			if ( o1 instanceof Comparable && o2 instanceof Comparable) {
				Comparable c1 = (Comparable)o1;
				Comparable c2 = (Comparable)o2;
				return c1.compareTo(c2) * -1;
			}
			return -1;
		}
	}
	
	public void hashmap2() {
		HashMap map = new HashMap();
		map.put("김자바", new Integer(90));
		map.put("김자바", new Integer(100));
		map.put("이자바", new Integer(100));
		map.put("강자바", new Integer(80));
		map.put("안자바", new Integer(90));
		
		Set set = map.entrySet();
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();
			System.out.println("이름 : " + e.getKey() +", 점수 : " + e.getValue());
		}
		
		set = map.keySet();
		System.out.println("참가자 명단 : " + set);
		
		Collection values = map.values();
		it = values.iterator();
		
		int total = 0;
		
		while ( it.hasNext() ) {
			Integer i = (Integer)it.next();
			total += i.intValue();
		}
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + (float)total/set.size());
		System.out.println("최고점수 : " + Collections.max(values));
	}
	
	public HashMap phoneBook = new HashMap();
	
	public void hashmap3() {
		addPhoneNo("친구", "이자바", "0101111111");
		addPhoneNo("친구", "김자바", "0102222222");
		addPhoneNo("친구", "김자바", "0103333333");
		addPhoneNo("회사", "김대리", "0104444444");
		addPhoneNo("회사", "김대리", "0105555555");
		addPhoneNo("회사", "박대리", "0106666666");
		addPhoneNo("회사", "이과장", "0107777777");
		addPhoneNo("세탁", "0108888888");
		
		printList();
	}
	
	public void addGroup(String groupName) {
		if ( !phoneBook.containsKey(groupName) ) {
			phoneBook.put(groupName, new HashMap());
		}
	}
	
	public void addPhoneNo(String groupName, String name, String tel) {
		addGroup(groupName);
		HashMap group = (HashMap)phoneBook.get(groupName);
		group.put(tel, name);
	}
	
	public void addPhoneNo(String name, String tel) {
		addPhoneNo("기타", name, tel);
	}
	
	public void printList() {
		Set set = phoneBook.entrySet();
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();
			
			Set subSet = ((HashMap)e.getValue()).entrySet();
			Iterator subIt = subSet.iterator();
			
			System.out.println(" * " + e.getKey() + "["+subSet.size()+"]");
			while(subIt.hasNext()) {
				Map.Entry subE = (Map.Entry)subIt.next();
				String telNo = (String)subE.getKey();
				String name = (String)subE.getValue();
				System.out.println(name + " " + telNo);
			}
			System.out.println();
		}
	}
	
	public void hashmap4() {
		String[] data = { "a", "k", "a","k","d","k","a","k","k","k","z","d" };
		HashMap map = new HashMap();
		
		for (int i = 0 ; i < data.length ; i++ ) {
			if ( map.containsKey(data[i])) {
				Integer value = (Integer)map.get(data[i]);
				map.put(data[i], new Integer(value.intValue()+1));
			} else {
				map.put(data[i], new Integer(1));
			}
		}
		
		Iterator it = map.entrySet().iterator();
		
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			int value = ((Integer)entry.getValue()).intValue();
			System.out.println(entry.getKey() + " : " + printBar('#', value) + " " + value);
		}
	}
	
	public String printBar(char ch, int value) {
		char[] bar = new char[value];
		
		for ( int i = 0 ; i < bar.length ; i++ ) {
			bar[i] = ch;
		}
		return new String(bar);
	}
	
	public void calendar1() {
		Calendar today = Calendar.getInstance();
		System.out.println("이 해의 년도 : " + today.get(Calendar.YEAR));
		System.out.println("월 ( 0~11 ) : " + today.get(Calendar.MONTH));
		System.out.println("이 해의 몇쨰주 : " + today.get(Calendar.WEEK_OF_YEAR));
		System.out.println("이 달의 몇째주 : " + today.get(Calendar.WEEK_OF_MONTH));
		System.out.println("이 달의 몇 일 : " + today.get(Calendar.DATE));
		System.out.println("이 달의 몇 일 : " + today.get(Calendar.DAY_OF_MONTH));
		System.out.println("이 해의 몇 일 : " + today.get(Calendar.DAY_OF_YEAR));
		System.out.println("요일 ( 1~7 ) : " + today.get(Calendar.DAY_OF_WEEK));
		System.out.println("이 달의 몇째 요일 : " + today.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		System.out.println("오전_오후(0오전 1오후) : " + today.get(Calendar.AM_PM));
		System.out.println("시간 (0 ~ 11) : " + today.get(Calendar.HOUR));
		System.out.println("시간 (0 ~ 23) : " + today.get(Calendar.HOUR_OF_DAY));
		System.out.println("분 (0 ~ 59) : " + today.get(Calendar.MINUTE));
		System.out.println("초 (0 ~ 59) : " + today.get(Calendar.SECOND));
		System.out.println("1000분의 1초(0~999) : " + today.get(Calendar.MILLISECOND));
		System.out.println("TimeZone(-12 ~ +12) : " + today.get(Calendar.ZONE_OFFSET)/(60*60*1000));
		System.out.println("이 달의 마지막날 : " + today.getActualMaximum(Calendar.DATE));
	}
	
	public void calendar2() {
		// 요일은 1 부터 시작하기 때문에 DAY_OF_WEEK[0]을 비워둠
		final String[] DAY_OF_WEEK = { "", "일", "월" ,"화", "수", "목", "금", "토" };
		Calendar date1 = Calendar.getInstance();
		Calendar date2 = Calendar.getInstance();
		
		// month의 경우 0 부터 시작하기 때문에 8월인 경우, 7ㄹㅗ 지정해야 한다.
		date1.set(2019, 7, 15);
		System.out.println("date1은 " + toString(date1) + DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)]+"요일이고,");
	}
}
