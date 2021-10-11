package Uebung1a;

public class Parkhaus {
	private int plaetze;
	private int autos = 0;
	
	public Parkhaus(int plaetze) {
		this.plaetze = plaetze;
	}

	public int getPlaetze() {
		return plaetze;
	}

	public void setPlaetze(int plaetze) {
		this.plaetze = plaetze;
	}
	
	public synchronized void einparken(Auto auto) {
		while(this.autos == this.plaetze) {
			try {
				wait();
				System.out.println("Warten an Schranke: " + auto.getAutoName() + " Kapazität: " + this.autos);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.addAuto(auto);
		notify();
	}
	
	public synchronized void ausparken(Auto auto) {
		this.removeAuto(auto);
		notify();
	}
	
	private synchronized void addAuto(Auto auto) {
		this.autos++;
		System.out.println("Einfahrt: " + auto.getAutoName() + " Kapazität: " + this.autos);
	}
	
	private synchronized void removeAuto(Auto auto) {
		this.autos--;
		System.out.println("Ausfahrt: " + auto.getAutoName() + " Kapazität: " + this.autos);
	}
}
