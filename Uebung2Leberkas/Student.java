package Uebung2Leberkas;

import java.util.Random;

public class Student implements Runnable {
	private KitchenCounter theke;
	private String name;
	
	public Student(KitchenCounter theke, String name) {
		this.theke = theke;
		this.name = name;
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(new Random().nextInt(3000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			this.theke.get();
		}
	}
}
