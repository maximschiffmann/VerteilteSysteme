package Uebung4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MessengingService {

	public static void main(String[] args) {
		int PORT = 7777;
		
		int cpuCount = Runtime.getRuntime().availableProcessors();
		ExecutorService executor = Executors.newFixedThreadPool(cpuCount);
		MessageStore messageStore = new MessageStore();
		
		try(ServerSocket serverSocket = new ServerSocket(PORT)) {
			System.out.println("Server gestartet!");
			
			while(true) {
				Socket client = serverSocket.accept();
				//System.out.println("Neue Verbindung von " + client.getInetAddress().getHostName() + ":" + client.getPort());
				Runnable clientRequest = new ClientRequest(client, messageStore);
				executor.execute(clientRequest);
			}
		} catch(IOException e) {
			System.err.println("Can't start server!");
		}
		

	}

}
