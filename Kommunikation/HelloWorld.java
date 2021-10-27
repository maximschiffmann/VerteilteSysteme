package Kommunikation;

public class HelloWorld {

	public static void main(String[] args) {
		// Create two HelloWorldThread instances
		Thread eins = new HelloWorldThread("Thread Eins");
		Thread zwei = new HelloWorldThread("Thread Zwei");
		// Start both threads
		eins.start();
		zwei.start();
		// Endless loop
		while (true) {
			System.out.println("Prozess");
		}
	}
}

// Definition of the HelloWorldThread class.
// Threads have to be derived (�extends�) from the class
// Thread

class HelloWorldThread extends Thread {
	String name;

	// Constructor
	HelloWorldThread(String aName) {
		name = aName;
	}

	// following routine will be called by start()
	// and will be quasi-parallel executed
	public void run() {
		// endless output
		while (true) {
			System.out.println(name);

		}
	}
}
