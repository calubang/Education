package com.kitri.thread;

public class ThreadTest {
	public static void main(String[] args) {
		Thread t1 = new ThreadExt("��");
		Thread t2 = new ThreadExt("��");
		Thread t3 = new ThreadExt("!!!");
		//Thread t4 = new threadExt("");
		
		//t1.run();
		//t2.run();
		//t3.run();
		//t4.run();
		
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println("���α׷� ����!!!");
	}
}
