package Uebung1c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Simulation {

	public static void main(String[] args) {
		Parkhaus parkhaus = new Parkhaus("Abstellplatz", 10);
		Hersteller hersteller = new Hersteller("Tesla", parkhaus);
		hersteller.start();
		
		List<String> namen = Arrays.asList("Ost", "West", "Nord", "Süd", "Zwielichtiger Schuppen");
		Collections.shuffle(namen);
		List<Kunde> kunden = new ArrayList<>();
		for(int i = 0; i < 5; i++) {
			Kunde kunde = new Kunde(namen.get(i), parkhaus);
			kunde.start();
			kunden.add(kunde);
		}
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
		}
		System.out.println("\n\n>>>Wochenbericht<<<");
		parkhaus.autobestand();
		for(Kunde k : kunden) {
			System.out.println(k.getName() + " hat folgende Fahrzeuge gekauft: ");
			k.getGekauft();
		}
	}

}
