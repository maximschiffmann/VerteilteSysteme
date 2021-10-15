package Uebung1c;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Random;

public class Kunde extends Thread {
	// private List<Auto> gekauft = new ArrayList<>();
	private Deque<Auto> gekauft = new ArrayDeque<>();
	private Parkhaus parkhaus;
	
	public Kunde(String name, Parkhaus parkhaus) {
		super(name);
		setDaemon(true);
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
			this.parkhaus.autokauf(this);
		}
	}

	public void kauft(Auto auto) {
		this.gekauft.add(auto);
	}

	public void getGekauft() {
		for(Auto auto : this.gekauft) {
			System.out.println("\t" + auto.getName());
		}
	}
	
}
