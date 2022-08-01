package Uebung3SimpleSocketChat;

import java.io.IOException;
import java.net.Socket;

public class Client {
	
	public static void main(String[] args) {
		
		try {
			 Socket server = new Socket("localhost", Server.PORT);
			//Socket server = new Socket("im-lamport.oth-regensburg.de", 1213);
			
			Runnable keyboardListener = new KeyboardListener(server);
			new Thread(keyboardListener).start();
			Runnable inputStreamListener = new InputStreamListener(server);
			new Thread(inputStreamListener).start();	
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
