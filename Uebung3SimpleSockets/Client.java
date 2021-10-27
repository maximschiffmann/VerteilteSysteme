package Uebung3SimpleSockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int SERVER_PORT = 9999;
		try {
			System.out.println("Bitte geben Sie eine Nachricht ein: ");
			String eingabe = sc.nextLine();
			
			Socket s = new Socket("localhost", SERVER_PORT);
			InputStream in = s.getInputStream();
			BufferedReader reader = new BufferedReader( new InputStreamReader(in));
			
			OutputStream out = s.getOutputStream();
			PrintWriter writer = new PrintWriter(out);
			
			
			writer.println(eingabe);
			writer.flush();
			
			String eingang = reader.readLine();
			
			System.out.println("Antwort von Server: " + eingang);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
