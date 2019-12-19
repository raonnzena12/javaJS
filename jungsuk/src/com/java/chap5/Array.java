package com.java.chap5;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class Array {
	public Array() {}
	
	public void array1() {
		int sum = 0; // 총점을 저장하기 위한 변수
		float average = 0f; // 평균을 저장하기 위한 변수
		
		int [] score = {100,88,100,100,90};
		
		for ( int i = 0 ; i < score.length ; i++ ) {
			sum += score[i];
		}
		average = sum / (float)score.length; 
		System.out.println("총점:" + sum);
		System.out.println("평균:" + average);
	}

	public void array2() {
		int[] score = {79, 88, 91, 33, 100, 55, 95};
		
		int max = score[0];
		int min = score[0];
		for ( int i = 1 ; i < score.length ; i++ ) {
			if ( score[i] > max ) max = score[i];
			if ( score[i] < min ) min = score[i];
		}
		System.out.println("MAX:" + max);
		System.out.println("MIN:" + min);
	}
	
	public void array3() {
		int[] number = new int[10];
		for ( int i = 0 ; i < number.length ; i++ ) {
			number[i] = i;
			System.out.print(i+" ");
		}
		System.out.println();
		
		for ( int i = 0; i < 100 ; i++ ) {
			int n = (int)(Math.random() * 10 );
			int temp = number[0];
			number[0] = number[n];
			number[n] = temp;
		}
		for ( int i = 0; i < number.length; i++ ) {
			System.out.print(number[i] + " ");
		}
	}
	
	public void array4() {
		int[] ball = new int[45];
		
		for ( int i = 0 ; i < ball.length ; i++ ) {
			ball[i] = i+1;
		}
		int tmp = 0;
		int j = 0;
		for ( int i = 0 ; i < 100 ; i++ ) {
			j = (int)(Math.random() * 45 );
			tmp = ball[0];
			ball[0] = ball[j];
			ball[j] = tmp;
		}
		for ( int i = 0 ; i < 6 ; i++ ) {
			System.out.print(ball[i] + " ");
		}
	}
	
	public void array5() {
		int[] number = new int[10];
		
		for ( int i = 0; i < number.length ; i++ ) {
			System.out.print(number[i] = (int)(Math.random() * 10));
			System.out.print(" ");
		}
		System.out.println();
		
		for ( int i = 0 ; i < number.length ; i++ ) {
			boolean changed = false;
			
			for ( int j = 0 ; j < number.length-1-i ; j++ ) {
				if ( number[j] > number[j+1] ) {
					int tmp = number[j];
					number[j] = number[j+1];
					number[j+1] = tmp;
					changed = true;
				}
			}
			if ( !changed ) break;
			
			for ( int k = 0; k < number.length; k++ ) {
				System.out.print(number[k]+" ");
			}
			System.out.println();
		}
	}
	
	public void array6() {
		int[] number = new int[10];
		int[] counter = new int[10];
		
		for( int i = 0 ; i < number.length ; i++ ) {
			System.out.print(number[i] = (int)(Math.random() * 10));
		}
		System.out.println();
		
		for ( int i = 0 ; i < number.length ; i++ ) {
			counter[number[i]]++;
		}
		for ( int i = 0; i < number.length ; i++ ) {
			System.out.println(i+"의 개수 : " + counter[i]);
		}
	}
	
	public void array7() {
		char[] hex = {'C', 'A', 'F', 'E' };
		String[] binary = {"0000", "0001", "0010", "0011",
							"0100", "0101", "0110", "0111",
							"1000", "1001", "1010", "1011",
							"1100", "1101", "1110", "1111" };
		String result = "";
		
		for ( int i = 0 ; i < hex.length ;  i++ ) {
			if ( hex[i] >= '0' && hex[i] <= '9' ) {
				result += binary[hex[i]-'0'];
			} else {
				result += binary[hex[i]-'A' + 10];
			}
		}
		System.out.println("hex:" + new String(hex));
		System.out.println("binary:" + result);
	}
	
	public void array8() {
		String src = "ABCDE";
		
		for ( int i = 0 ; i < src.length() ; i++ ) {
			System.out.println("scr.charAt("+ i +") : " + src.charAt(i));
		}
	}
	
	public void array9() {
		String source = "SOSHELP";
		String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.","--.", "....","..",".---",
							"-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-",
							"..-","...-",".--","-..-","-.--","--.."};
		String result = "";
		
		for ( int i = 0 ; i < source.length() ; i++ ) {
			result += morse[source.charAt(i)-'A'];
		}
		System.out.println("source:" + source);
		System.out.println("morse:" + result);
	}
	
	public void array10() {
		int[][] score = {{ 100,100,100} ,
							{ 20, 20, 20},
							{30, 30, 30},
							{40, 40, 40},
							{50, 50, 50}};
		int korTotal = 0, engTotal = 0, matTotal = 0;
		System.out.println("번호 국어 영어 수학 총점 평균");
		System.out.println("=============================");
		for ( int i = 0 ; i < score.length ; i++ ) {
			int sum = 0;
			korTotal += score[i][0];
			engTotal += score[i][1];
			matTotal += score[i][2];
			System.out.print(" " +(i+1) + " ");
			for ( int j = 0 ; j < score[i].length ; j++ ) {
				sum += score[i][j];
				System.out.print(score[i][j] + " ");
			}
			System.out.println(sum + " " + sum / (float)score[i].length);
		}
	}
	
	public void array11() {
		int[] num = { 1, 2, 3, 4, 5};
		int[] newNum = new int[10];
		for ( int i = 0 ; i < num.length ; i++ ) {
			newNum[i] = num[i];
		}
		System.out.println(Arrays.toString(newNum));
	}
	
	public void array12() {
		char[] abc = { 'A' , 'B' , 'C' , 'D' };
		char[] num = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		System.out.println(new String(abc));
		System.out.println(new String(num));
		
		char[] result = new char[abc.length + num.length];
		System.arraycopy(abc, 0, result, 0, abc.length);
		System.arraycopy(num, 0, result, abc.length, num.length);
		System.out.println(new String(result));
		
		
	}

	public void array16() {
		int answer = (int)(Math.random() * 100 ) + 1;
		int input = 0;
		String temp = "";
		int count = 0;
		
		do {
			count++;
			temp = JOptionPane.showInputDialog("1~100사이의 숫자를 입력하세요.\n끝내려면 -1을 입력하세요");
			if ( temp == null || temp.equals("-1")) break;
			System.out.println("입력값 : " + temp);
			input = Integer.parseInt(temp);
			if ( answer > input ) {
				System.out.println("더 큰 수를 입력하세요");
			} else if ( answer < input ) {
				System.out.println("더 작은 수를 입력하세요");
			} else {
				System.out.println("시도횟수 " + count);
				break;
			}
		} while ( true );
	}
}
