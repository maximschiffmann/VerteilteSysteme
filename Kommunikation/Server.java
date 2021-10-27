package Kommunikation;

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
		
		try {
			ServerSocket serverSocket = new ServerSocket(9999);
			while(true) {
				// blockiert bei accept() bis Client::connect
				try {
					Socket s = serverSocket.accept();
					// Senden und Empfangen über Streams und Reader/Writer
					InputStream in = s.getInputStream();
					BufferedReader reader = new BufferedReader(new InputStreamReader(in));
					
					OutputStream out = s.getOutputStream();
					PrintWriter writer = new PrintWriter(out);
					
					writer.println("Hallo"); // oder print("Hallo\n");
					writer.flush();
					
					String antwort = reader.readLine();
					System.out.println("Server: Antwort der Gegenseite: " + antwort);					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
