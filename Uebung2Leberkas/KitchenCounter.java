package Uebung2Leberkas;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class KitchenCounter {
	private int counter;
	private int capacity;
	
	Lock monitor = new ReentrantLock();
	Condition student = monitor.newCondition();
	Condition waiter = monitor.newCondition();
	
	public KitchenCounter(int capacity) {
		this.capacity = capacity;
	}
	
	public void put() {
		monitor.lock();
		try {
			while(counter >= capacity) {
				try {
					System.out.println("Platzieren: Theke voll! Kapaziteat: " + this.counter);
					waiter.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Platzieren: Noch Platz auf theke! Kapaziteat: " + this.counter);
			counter++;
			student.signal();
		} finally {
			monitor.unlock();
		}
	}
	
	public void get() {
		monitor.lock();
		try {
			while(counter <= 0) {
				try {
					System.out.println("Holen: Keine mehr da! Kapaziteat: " + this.counter);
					student.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Holen: Welche da! Kapaziteat: " + this.counter);
			counter--;
			waiter.signal();
		} finally {
			monitor.unlock();
		}
	}
}
