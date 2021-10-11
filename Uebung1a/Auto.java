package Uebung1a;

import java.util.Random;

public class Auto extends Thread {

	private String name;
	private Parkhaus parkhaus;
	private volatile boolean end = false;

	public Auto(String name, Parkhaus parkhaus) {
		setDaemon(true);
		this.name = name;
		this.parkhaus = parkhaus;
	}

	public String getAutoName() {
		return name;
	}

	public void setAutoName(String name) {
		this.name = name;
	}

	public Parkhaus getParkhaus() {
		return parkhaus;
	}

	public void setParkhaus(Parkhaus parkhaus) {
		this.parkhaus = parkhaus;
	}
	
	public void stopAuto() {
		this.end = true;
	}

	public boolean getEnd() {
		return this.end;
	}
	
	@Override
	public void run() {
		while (true) {
			// Fahren
			try {
				Thread.sleep(new Random().nextInt(10000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Parken
			this.parkhaus.einparken(this);
			try {
				Thread.sleep(new Random().nextInt(10000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Ausparcken
			this.parkhaus.ausparken(this);
		}
	}
}
