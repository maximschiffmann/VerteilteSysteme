package Uebung3SimpleSocketChat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static String END_STRING = "Bye";
	public static int PORT = 1212;
	
	public static void main(String[] args) {
		
		try(ServerSocket serverSocket = new ServerSocket(PORT)) {
			System.out.println("Server gestartet, warte auf Verbindung...");
			Socket client = serverSocket.accept();
			System.out.println("Verbindung etabliert " + client.toString());
			
			Runnable keyboardListener = new KeyboardListener(client);
			new Thread(keyboardListener).start();
			Runnable inputStreamListener = new InputStreamListener(client);
			new Thread(inputStreamListener).start();			
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
