package org.hunting.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {

	private final Lock displayQueueLock = new ReentrantLock();

	private final Lock readQueueLock = new ReentrantLock();

	public static void main(String[] args) {

		LockExample example = new LockExample();

		LockThread thread = new LockThread(example, "thread 1 ");
		thread.start();

		LockThread1 thread1 = new LockThread1(example, "thread 2 ");
		thread1.start();

	}

	public void m1(String str) {
		System.out.println("enterd " + str);
		System.out.println("Lock started " + str);
		try {
			boolean b = displayQueueLock.tryLock();
			System.out.println(str + " lock status " + b);
			if (b) {
				displayQueueLock.lock();
			}
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			displayQueueLock.unlock();
		}
		System.out.println(str + " released");
	}

	public void m2(String str) {
		System.out.println("enterd " + str);
		System.out.println("Lock started " + str);
		try {
			boolean b = readQueueLock.tryLock();
			System.out.println(str + " lock status " + b);
			if (b) {
				readQueueLock.lock();
			}
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			readQueueLock.unlock();
		}
		System.out.println(str + " released");
	}

}

class LockThread extends Thread {
	LockExample obj;
	String str;

	public LockThread(LockExample obj, String str) {
		this.obj = obj;
		this.str = str;
	}

	@Override
	public void run() {
		obj.m1(str);
	}

}

class LockThread1 extends Thread {
	LockExample obj;
	String str;

	public LockThread1(LockExample obj, String str) {
		this.obj = obj;
		this.str = str;
	}

	@Override
	public void run() {
		obj.m2(str);
	}

}
