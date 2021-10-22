package Uebung1c;

import java.util.ArrayDeque;
import java.util.Deque;

public class Parkhaus {
	private String name;
	private int plaetze;
	private Deque<Auto> autos = new ArrayDeque<>();

	public Parkhaus(String name, int plaetze) {
		this.name = name;
		this.plaetze = plaetze;
	}

	public synchronized void einparken(Hersteller hersteller, Auto auto) {
		while (this.autos.size() == this.plaetze) {
			try {
				System.out.println("Warten an Schranke: " + auto.getName() + " Kapazität: " + this.autos.size());
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(auto.getName() + " eingeliefert! Bestand: " + this.autos.size());
		this.autos.addLast(auto);
		notify();
	}

	public synchronized void autokauf(Kunde kunde) {
		while (this.autos.isEmpty()) {
			try {
				System.out.println("Keine Autos zum Kaufen verfügbar! Anfrage von: " + kunde.getName());
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Auto auto = this.autos.pollFirst();
		System.out.println("Kunde: " + kunde.getName() + " kauft Fahrzeug: " + auto.getName());
		kunde.kauft(auto);
		notify();
	}
	
	public void autobestand() {
		System.out.println(this.name + " Fahrzeugbestand: " + this.autos.size());
	}
}
