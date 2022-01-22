package org.hunting.synchronize;

public class JavaObjectLock {

	public static void main(String[] args) {

		JavaObjectLock obj = new JavaObjectLock();

		Thread3 t1 = new Thread3(obj);
		Thread4 t2 = new Thread4(obj);

		t1.start();
		t2.start();

	}

	public synchronized void m1() {
		System.out.println("m1 thread starting ");
		//synchronized (this) {
			try {
				System.out.println("enterd m1 block");
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	//	}

		System.out.println("m1 thread releasing ");
	}

	public synchronized void m2() {
		System.out.println("m2 thread starting ");
		//synchronized (this) {
			try {
				System.out.println("enterd m2 block");
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//}

		System.out.println("m2 thread releasing ");
	}

}

class Thread3 extends Thread {
	JavaObjectLock obj;

	public Thread3(JavaObjectLock obj) {
		this.obj = obj;

	}

	@Override
	public void run() {
		obj.m1();
	}

}

class Thread4 extends Thread {

	JavaObjectLock obj;

	public Thread4(JavaObjectLock obj) {
		this.obj = obj;
	}

	@Override
	public void run() {
		obj.m2();
	}

}

