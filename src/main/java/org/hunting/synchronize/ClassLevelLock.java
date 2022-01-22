package org.hunting.synchronize;

public class ClassLevelLock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();

		t1.start();
		t2.start();

	}

	public static synchronized void m1(String str) {
		System.out.println(str + " thread starting ");
		try {
			System.out.println(" enterd block " + str);
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("m1 thread releasing ");
	}

	public static synchronized void m2(String str) {
		System.out.println("thread starting " + str);
		try {
			System.out.println("enterd  block " + str);
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("m2 thread releasing ");
	}
}

class Thread1 extends Thread {

	@Override
	public void run() {
		ClassLevelLock obj=new ClassLevelLock();
		obj.m1("threD1");
	}

}

class Thread2 extends Thread {
	@Override
	public void run() {
		ClassLevelLock obj=new ClassLevelLock();
		obj.m1("thread2");
	}

}
