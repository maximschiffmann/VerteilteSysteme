package Uebung2Leberkas;

import java.util.Random;

import Uebung1c.Auto;

public class Waiter implements Runnable{
	private KitchenCounter theke;
	private String name;
	
	public Waiter(KitchenCounter theke, String name) {
		this.theke = theke;
		this.name = name;
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(new Random().nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			this.theke.put();
		}
	}

}
