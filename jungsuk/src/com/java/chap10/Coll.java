package com.java.chap10;

import java.io.File;
import java.text.ChoiceFormat;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
		
		// month의 경우 0 부터 시작하기 때문에 8월인 경우, 7로 지정해야 한다.
		date1.set(2019, 7, 15);
		System.out.println("date1은 " + toString(date1) + DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)]+"요일이고,");
		System.out.println("오늘(date2)은 " + toString(date2) + DAY_OF_WEEK[date2.get(Calendar.DAY_OF_WEEK)] + "요일 입니다.");
		// 두 날짜간의 차이를 얻으려면, getTimeInMillis()를 이용해서 천분의 일초 단위로 변환해야 한다.
		long difference = (date2.getTimeInMillis() - date1.getTimeInMillis())/1000;
		System.out.println("그 날 (date1) 부터 지금 (date2)까지 " + difference +"초가 지났습니다");
		System.out.println("일(day)로 계산하면 "+ difference/(24*60*60)+"일 입니다.");
	}
	
	public String toString(Calendar date) {
		return date.get(Calendar.YEAR)+"년 " + (date.get(Calendar.MONTH)+ 1)+"월 " + date.get(Calendar.DATE) + "일";
	}
	
	public void calendar4() {
		Scanner scan = new Scanner(System.in);
		
		int year = scan.nextInt();
		scan.nextLine();
		int month = scan.nextInt();
		scan.nextLine();
		
		int START_DAY_OF_WEEK = 0;
		int END_DAY = 0;
		
		Calendar sDay = Calendar.getInstance();
		Calendar eDay = Calendar.getInstance();
		
		// 월의 경우 0부터 11까지의 값을 가지므로 1을 빼주어야 한다.
		// 예를 들어, 2004년 11월 1 일은 sDay.set(2004, 10, 1)과 같이 해줘야 한다.
		sDay.set(year, month-1, 1);
		eDay.set(year, month, 1);
		
		// 다음달의 첫날에서 하루를 빼면 현재달의 마지막 날이 된다.
		// 12월 1일에서 하루를 빼면 11월 30일이 된다.
		eDay.add(Calendar.DATE, -1);
		
		// 첫 번째 요일이 무슨 요일인지 알아낸다.
		START_DAY_OF_WEEK = sDay.get(Calendar.DAY_OF_WEEK);
		// eDay에 지정된 날짜를 얻어온다.
		END_DAY = eDay.get(Calendar.DATE);
		
		System.out.println("=== "+year+"년 "+month+"월 ===");
		System.out.println(" SU MO TU WE TH FR SA ");
		
		// 해당 월의 1일이 어느 요일인지에 따라서 공백을 출력한다.
		// 만일 1일이 수요일이라면 공백을 세번 찍는다.(일요일부터 시작)
		for ( int i = 1 ; i < START_DAY_OF_WEEK ; i++ ) {
			System.out.print("   ");
		}
		
		for ( int i = 1 , n = START_DAY_OF_WEEK ; i <= END_DAY ; i++, n++ ) {
			System.out.print((i<10)? "  " + i : " " + i);
			if ( n%7 == 0 ) System.out.println();
		}
	}
	
	public void calendar7() {
		Scanner scan = new Scanner(System.in);
		
		int year = scan.nextInt();
		scan.nextLine();
		int month = scan.nextInt();
		scan.nextLine();
		
		Calendar sDay = Calendar.getInstance();
		Calendar eDay = Calendar.getInstance();
		
		sDay.set(year, month-1, 1);
		// 입력월의 말일로 설정한다.
		eDay.set(year, month-1, sDay.getActualMaximum(Calendar.DATE));
		
		// 1일이 속한 주의 일요일로 날짜 설정
		sDay.add(Calendar.DATE, -sDay.get(Calendar.DAY_OF_WEEK) + 1);
		
		// 말일이 속한 주의 토요일로 날짜 설정
		eDay.add(Calendar.DATE, 7-eDay.get(Calendar.DAY_OF_WEEK));
		
		System.out.println("=== "+year+"년 "+month+"월 ===");
		System.out.println(" SU MO TU WE TH FR SA ");

		// 시작일과 마지막일까지(sDay <= eDay) 1일씩 증가시켜가면서 일(Calendar.DATE)을 출력한다.
		for ( int n = 1 ; sDay.before(eDay) || sDay.equals(eDay) ; sDay.add(Calendar.DATE, 1)) {
			int day = sDay.get(Calendar.DATE);
			System.out.print((day<10)? "  " + day : " " + day);
			if ( n++%7 == 0 ) System.out.println();
		}
	}
	
	public void random1() {
		Random rand = new Random(1);
		Random rand2 = new Random(1);
		
		System.out.println(" === rand ===");
		for (int i = 0 ; i < 5 ; i++ )
			System.out.println(i + " : " + rand.nextInt() );
		
		System.out.println();
		System.out.println("=== rand2 ===");
		for ( int i = 0 ; i < 5 ; i++ ) 
			System.out.println(i + " : " + rand2.nextInt());
	}
	
	public void random2() {
		Random rand = new Random();
		int[] number = new int[100];
		int[] counter = new int[10];
		
		for ( int i = 0 ; i < number.length ; i++ ) {
			// 0<= x < 10 범위의 정수 x를 반환한다.
			System.out.print(number[i] = rand.nextInt(10));
		}
		System.out.println();
		
		for ( int i = 0 ; i < number.length ; i++ ) {
			counter[number[i]]++;
		}
		
		for ( int i = 0 ; i < counter.length ; i++ ) {
			System.out.println(i+"의 갯수 : " + printBar('#', counter[i]) + " " + counter[i]);
		}
	}
	
	public void random3() {
		for ( int i = 0 ; i < 10 ; i++ ) {
			System.out.print(getRand(5,10) + ",");
		}
		System.out.println();
		
		int[] result = fillRand(new int[10], new int[] {2, 3, 7, 5});
		System.out.println(Arrays.toString(result));
		
		String[] result2 = fillDistinctRand(new String[3], new String[] {"a","b","c","d","e"});
		System.out.println(Arrays.toString(result2));
	}
	
	public int[] fillRand(int[] arr, int from, int to) {
		for ( int i = 0 ; i < arr.length ; i++ ) {
			arr[i] = getRand(from, to);
		}
		return arr;
	}
	
	public int[] fillRand(int[] arr, int[] data) {
		for (int i = 0 ; i < arr.length ; i++ ) {
			arr[i] = data[getRand(0, data.length -1)];
		}
		return arr;
	}
	
	public int getRand(int from, int to) {
		return (int)(Math.random() * (Math.abs(to-from) +1)) + Math.min(from, to);
	}
	
	public String[] fillDistinctRand(String[] arr, String[] data) {
		if ( arr.length <= 0 || data.length <= 0) return arr;
		
		HashSet hs = new HashSet(arr.length);
		
		while(hs.size() < Math.min(arr.length, data.length)) {
			hs.add(data[getRand(0,data.length-1)]);
		}
		Object[] tmp = hs.toArray();
		
		for ( int i = 0 ; i < tmp.length ; i++ ) {
			arr[i] = (String)tmp[i];
		}
		
		return arr;
	}
	
	final int RECODE_NUM = 10;
	final String TABLE_NAME = "TEST_TABLE";
	final String[] CODE1 = {"010", "011", "017", "018", "019"};
	final String[] CODE2 = {"남자", "여자"};
	final String[] CODE3 = {"10대", "20대", "30대", "40대", "50대"};
	
	public void random4() {
		for ( int i = 0 ; i < RECODE_NUM ; i++ ) {
			System.out.println("INSERT INTO " + TABLE_NAME + " VALUES ("
								+ " '" + getRandArr(CODE1) + "' "
								+ ", '" + getRandArr(CODE2) + "' "
								+ ", '" + getRandArr(CODE3) + "' "
								+ ", " + getRand(100,200) + "); ");
		}
	}
	
	public String getRandArr(String[] arr) {
		return arr[getRand(arr.length-1)];
	}
	
	public int getRand(int n) {
		return getRand(0, n);
	}
	
	public void random5() {
		String[] data = { "a", "a", "b", "c"};
		
		HashMap map = new HashMap();
		
		for ( int i = 0 ; i < 100 ; i++ ) {
			String temp = getRandArr(data);
			if ( map.containsKey(temp)) {
				Integer value = (Integer)map.get(temp);
				map.put(temp, new Integer(value.intValue()+ 1));
			} else {
				map.put(temp, new Integer(1));
			}
		}
		
		Iterator it = map.keySet().iterator();
		while(it.hasNext()) {
			String key = (String)it.next();
			Integer value = (Integer)map.get(key);
			int intValue = value.intValue();
			System.out.println(key + " : " + printBar('#', intValue) + intValue);
		}
	}
	
	public void regular1() {
		String[] data = { "bat", "baby", "bonus", "cA", "ca", "co","c.","c0","car","combat","count","date","disc"};
		Pattern p = Pattern.compile("c[a-z]*");
		
		for ( int i = 0 ; i < data.length ; i++ ) {
			Matcher m = p.matcher(data[i]);
			if ( m.matches() ) {
				System.out.print(data[i] + ", ");
			}
		}
	}
	
	public void regular2() {
		String[] data = {"bat","baby","bonus","c","cA","va","co","c.","c0","c#","car","combat","count","date","disc"};
		String[] pattern = { ".*", "c[a-z]*","c[a-z]", "c[a-zA-Z]","c[a-zA-Z0-9]"
							,"c.","c.*","c\\.","c\\w","c\\d","c.*t","[b|c].*",".*a.*",".*a.+","[b|c].{2}"};
		for ( int x = 0 ; x < pattern.length ; x++ ) {
			Pattern p = Pattern.compile(pattern[x]);
			System.out.print("Pattern " + pattern[x] + " 결과 : ");
			for ( int i = 0 ; i < data.length ; i ++ ) {
				Matcher m = p.matcher(data[i]);
				if ( m.matches() ) {
					System.out.print(data[i]+", ");
				}
			}
			System.out.println();
		}
	}
	
	public void regular3() {
		String source = "HP: 011-1111-1111, HOME: 02-999-9999";
		String pattern = "(0\\d{1,2})-(\\d{3,4})-(\\d{4})";
		
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(source);
		
		int i = 0 ;
		while(m.find()) {
			System.out.println(++i + ": " + m.group() + " -> " + m.group(1) + ", " + m.group(2) + ", " + m.group(3));
		}
	}
	
	public void regular4() {
		String source = "A broken hand works, but not a broken heart.";
		String pattern = "broken";
		StringBuffer sb = new StringBuffer();
		
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(source);
		System.out.println("source : " + source);
		
		int i = 0;
		while(m.find()) {
			System.out.println(++i+"번째 매칭 : " + m.start() + "~" + m.end());
			// broken을 drunken으로 치환하여 sb에 저장한다.
			m.appendReplacement(sb, "drunken");
		}
		
		m.appendTail(sb);
		System.out.println("Replacement count : " + i);
		System.out.println("result : " + sb.toString());
	}
	
	public void scanner1() {
		Scanner scan = new Scanner(System.in); // Scanner(InputStrean source)
		String input = "";
		do {
			System.out.println("원하는 값을 입력하세요. 입력을 마치려면 Q를 입력하세요 >");
			input = scan.nextLine();
			System.out.println("입력하신 값은 " + input + "입니다.");
		} while(!input.equalsIgnoreCase("Q"));
		
		System.out.println("프로그램 종료");
	}
	
	public void scanner2() throws Exception {
		Scanner sc = new Scanner(new File("data2.txt"));
		int sum = 0;
		int cnt = 0;
		
		while ( sc.hasNextInt()) {
			sum += sc.nextInt();
			cnt++;
		}
		System.out.println("sum = " + sum);
		System.out.println("acerage = " + (double)sum/cnt);
	}
	
	public void scanner3() throws Exception {
		Scanner sc = new Scanner(new File("data3.txt"));
		int cnt = 0;
		int totalSum = 0;
		
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			Scanner sc2 = new Scanner(line).useDelimiter(",");
			int sum = 0;
			while ( sc.hasNextLine()) {
				sum += sc2.nextInt();
			}
			System.out.println(line + ", sum = " + sum);
			totalSum += sum;
			cnt++;
		}
		System.out.println("Line : " + cnt + ", Total : " + totalSum);
	}
	
	public void st1() {
		String source = "100,200,300,400";
		StringTokenizer st = new StringTokenizer(source, ",");
		while ( st.hasMoreTokens() ) {
			System.out.println(st.nextToken());
		}
	}
	
	public void st2() {
		String expression = "x=100*(200+300)/2";
		StringTokenizer st = new StringTokenizer(expression, "+-*/=()", true);
		
		while ( st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}
	
	public void st3() {
		String source = "1,김천재,100,100,100|2,박수재,95,80,90|3,김자바,80,90,90";
		StringTokenizer st = new StringTokenizer(source, "|");
		while ( st.hasMoreTokens()) {
			String token = st.nextToken();
			StringTokenizer st2 = new StringTokenizer(token,",");
			while(st2.hasMoreTokens()) {
				System.out.println(st2.nextToken());
			}
			System.out.println("=== === ===");
		}
	}
	
	public void st4() {
		String input = "삼십만삼천백십오";
		System.out.println(input);
		System.out.println(hangulToNum(input));
	}
	
	public long hangulToNum(String input) {
		long result = 0;
		long tmpResult = 0;
		long num = 0;
		
		final String NUMBER = "영일이삼사오육칠팔구";
		final String UNIT = "십백천만억조";
		final long[] UNIT_NUM = { 10, 100, 1000, 10000, (long)Math.pow(10, 8), (long)Math.pow(10, 12) };
		StringTokenizer st = new StringTokenizer(input, UNIT, true);
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			// 숫자인지, 단위(UNIT)인지 확인한다.
			int check = NUMBER.indexOf(token);
			if ( check == -1 ) {
				if ("만억조".indexOf(token) == -1 ) {
					tmpResult += ( num != 0 ? num : 1 ) * UNIT_NUM[UNIT.indexOf(token)];
				} else {
					tmpResult += num;
					result += (tmpResult != 0 ? tmpResult : 1 ) * UNIT_NUM[UNIT.indexOf(token)];
					tmpResult = 0;
				}
				num = 0;
			} else {
				num = check;
			}
		}
		return result + tmpResult + num;
	}
	
	public void st5() {
		String data = "100,,,200,300,400,,500";
		String[] result = data.split(",");
		StringTokenizer st = new StringTokenizer(data,",");
		for ( int i = 0 ; i < result.length ; i++ ) {
			System.out.print(result[i] + "|");
		}
		System.out.println("개수 : " + result.length);
		
		int i = 0;
		for (;st.hasMoreTokens(); i++) {
			System.out.print(st.nextToken()+"|");
		}
		System.out.println("개수 : " + i);
	}
	
	public void dateformat3() {
		DateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일");
		DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");
		
		try {
			Date d = df.parse("2019년 12월 30일");
			System.out.println(df2.format(d));
		} catch (Exception e) {
		}
	}
	
	public void choice1() {
		double[] limits = { 60, 70, 80, 90 };
		String[] grades = { "D", "C", "B", "A" };
		int[] scores = { 100, 95, 88, 70, 52, 60 ,70 };
		ChoiceFormat form = new ChoiceFormat(limits, grades);
		
		for ( int i = 0 ; i < scores.length ; i++ ) {
			System.out.println(scores[i] + ":" + form.format(scores[i]));
		}
	}
	
	public void choice2() {
		String pattern = "60#D|70#C|80<B|90#A";
		int[] scores = { 91, 90, 80, 88, 70, 52, 60 };
		ChoiceFormat form = new ChoiceFormat(pattern);
		
		for( int i = 0 ; i <scores.length ; i++ ) {
			System.out.println(scores[i] + ":" + form.format(scores[i]));
		}
			
	}
	
	public void message1() {
		String msg = "NAME: {0} \nTEL: {1} \nAGE: {2} \nBIRTH: {3}";
		Object[] args = { "이자바", "02-123-1234", "27", "07-09" };
		String result = MessageFormat.format(msg, args);
		System.out.println(result);
	}
}
