package com.java.run;

public class ThreadRun {
	static long startTime = 0;
	
	public static void main(String[] args) throws Exception {
		ThreadEx5_1 th1 = new ThreadEx5_1();
		th1.start();
		startTime = System.currentTimeMillis();
		
		for ( int i = 0 ; i < 3000 ; i++ ) {
			System.out.print("-");
		}
		
		System.out.println("소요시간1 : " + (System.currentTimeMillis() - ThreadRun.startTime));
	}
	
	static class ThreadEx5_1 extends Thread {
		public ThreadEx5_1() {}
		public void run() {
			for (int i = 0 ; i < 3000 ; i++ ) {
				System.out.print("|");
			}
			
			System.out.print("소요시간2 : " + (System.currentTimeMillis()-ThreadRun.startTime));
		}
		
	}

}
