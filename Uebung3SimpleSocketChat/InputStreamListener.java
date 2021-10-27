package Uebung3SimpleSocketChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class InputStreamListener implements Runnable {
	
	private Socket socket;
	
	public InputStreamListener(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		// Inputstream lesen
		InputStream in;
		try {
			in = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			
			String input; 
			
			// auf Konsole ausgeben
			do {
				input = reader.readLine(); // blockierend
				System.out.println(input);
			} while(input != null && !input.equalsIgnoreCase(Server.END_STRING));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
