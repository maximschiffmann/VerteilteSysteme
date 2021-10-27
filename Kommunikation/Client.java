package Kommunikation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost", 9999);
			InputStream in = s.getInputStream();
			BufferedReader reader = new BufferedReader( new InputStreamReader(in));
			
			OutputStream out = s.getOutputStream();
			PrintWriter writer = new PrintWriter(out);
			
			String eingang = reader.readLine();
			
			writer.println("Ich habe empfangen: " + eingang);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
