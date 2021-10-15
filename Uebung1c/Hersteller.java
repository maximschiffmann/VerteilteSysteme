package Uebung1c;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Hersteller extends Thread {
	private Parkhaus parkhaus;
	private static int autonummer = 0;
	private List<String> namen = Arrays.asList("S", "3", "X", "Y");
	
	public Hersteller(String name, Parkhaus parkhaus) {
		super(name);
		setDaemon(true);
		this.parkhaus = parkhaus;
	}

	public Parkhaus getParkhaus() {
		return parkhaus;
	}

	public void setParkhaus(Parkhaus parkhaus) {
		this.parkhaus = parkhaus;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(new Random().nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			Auto neuesAuto = new Auto(this.getName() + " Model - " + namen.get(new Random().nextInt(namen.size())) + " Fahrzeug-Nr. " + 	autonummer++);
			this.parkhaus.einparken(this, neuesAuto);
		}
	}
}
