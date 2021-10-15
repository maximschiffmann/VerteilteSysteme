package Uebung1b;

public class Simulation {

	public static void main(String[] args) throws InterruptedException {
		Parkhaus parkhaus = new Parkhaus(10);
		
		for(int i = 1; i <= 20; i++) {
//			new Thread(new Auto("R-FH " + i, parkhaus)).start();
			Auto thread = new Auto("R-FH " + i, parkhaus);
			thread.start();
		}
	
		Thread.sleep(30000);
		System.out.println(">>> Ende der Simulation!");
	}
	
}
