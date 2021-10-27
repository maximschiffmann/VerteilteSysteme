package Uebung3SimpleSockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		// int PORT = Integer.parseInt(args[0]);
		int PORT = 9999;
		
		try(ServerSocket serverSocket = new ServerSocket(PORT)) {
			while(true) {
				// blockiert bei accept() bis Client::connect
				try {
					System.out.println("Warte auf Verbindungen...");					
					Socket s = serverSocket.accept(); // blockierend
					System.out.println("Neue Verbindung von " + s.getInetAddress().getHostName() + ":" + s.getPort());
					
					// Senden und Empfangen über Streams und Reader/Writer
					InputStream in = s.getInputStream();
					BufferedReader reader = new BufferedReader(new InputStreamReader(in));
					
					OutputStream out = s.getOutputStream();
					PrintWriter writer = new PrintWriter(out);
					
					String eingang = reader.readLine();
					System.out.println(eingang);
					
					writer.println("*" + eingang + "*"); // oder print("Hallo\n");
					writer.flush();
					
					s.close();
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
