package com.java.chap12;

public class ThreadTest {
	public ThreadTest() {}
	
	public void thread21() {
		RunnableImpl r = new RunnableImpl();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		
		t1.start();
		t2.start();
	}
	
	class RunnableImpl implements Runnable {
		int iv = 0;
		@Override
		public void run() {
			int lv = 0;
			String name = Thread.currentThread().getName();
			
			while(lv < 3) {
				System.out.println(name + " Local Var : " + ++lv);
				System.out.println(name + " Instance Var : " + ++iv);
				System.out.println();
			}
			
		}
	}
	
	public void thread22() {
		Data d = new Data();
		MyThread22 t1 = new MyThread22(d);
		MyThread22 t2 = new MyThread22(d);
		
		t1.start();
		t2.start();
	}
	
	class Data {
		int iv = 0;
	}
	
	class MyThread22 extends Thread {
		Data d;
		
		MyThread22(Data d) {
			this.d = d;
		}
		
		public void run() {
			int lv = 0;
			
			while (lv < 3) {
				System.out.println(getName() + " Local var : " + ++ lv);
				System.out.println(getName() + " Instance var : " + ++d.iv);
				System.out.println();
			}
		}
	}
	
	public void thread23() {
		MyThread23 t1 = new MyThread23();
		MyThread23 t2 = new MyThread23();
		
		t1.start();
		t2.start();
	}
	
	class MyThread23 extends Thread {
		int iv = 0;
		
		public void run() {
			int lv = 0;
		
			while(lv < 3) {
				System.out.println(getName() + " LV: " + ++lv);
				System.out.println(getName() + " IV: " + ++iv);
				System.out.println();
			}
		}
	}
	
	public void thread24() {
		Runnable r = new Runnable24();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		
		t1.start();
		t2.start();
	}
	
	class Account24 {
		int balance = 1000;
		public void withdraw(int money) {
			if ( balance >= money ) {
				try { Thread.sleep(1000); } catch ( Exception e ) {}
				balance -= money;
			}
		}
	}
	
	class Runnable24 implements Runnable {
		Account24 acc = new Account24();
		
		public void run() {
			while(acc.balance > 0 ) {
				int money = (int)(Math.random() * 3 + 1) *100;
				acc.withdraw(money);
				System.out.println("balance : " + acc.balance);
			}
		}
	}
	
	public void thread25() {
		Runnable r = new Runnable25();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		
		t1.start();
		t2.start();
	}
	
	class Account25 {
		int balance = 1000;
		
		public synchronized void withdraw(int money) {
			if ( balance >= money ) {
				try { Thread.sleep(1000); } catch (Exception e) {}
				balance -= money;
			}
		}
	}
	
	class Runnable25 implements Runnable {
		Account25 acc = new Account25();
		
		public void run() {
			while(acc.balance > 0 ) {
				int money = (int)(Math.random() * 3 + 1 ) *100;
				acc.withdraw(money);
				System.out.println("balance: " + acc.balance);
			}
		}
	}
}
