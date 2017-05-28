package com.learningJava8.chap1;

public class RunnableByLambda{
	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello world");
			}
		});
		
		Thread thread2 = new Thread(()-> System.out.println("Hello world!!!"));	
		thread2.start();
	}
}
