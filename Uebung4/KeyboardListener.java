package Uebung4;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class KeyboardListener implements Runnable {

	private Socket socket;
	
	public KeyboardListener(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		OutputStream out;
		try {
			out = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(out);
			
			Scanner keyboard = new Scanner(System.in);
			String input = null;
			
			do {
				input = keyboard.nextLine(); // blockierend
				
				writer.println(input);
				writer.flush();
			} while(input != null);
			
			keyboard.close();
			socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
