package Uebung4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		String message = "";
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.print("Input: ");
			message = scanner.nextLine();
			try {
				Socket server = new Socket("localhost", 7777);
				// System.out.println("Connection!");
				InputStream in = server.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(in));

				OutputStream out = server.getOutputStream();
				PrintWriter writer = new PrintWriter(out);

				writer.println(message);
				writer.flush();

				for(String getServerMessage = reader.readLine(); getServerMessage != null; getServerMessage = reader.readLine()) {
					System.out.println(getServerMessage);
				}
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("Can't establish connection!");
			}
		} while (!message.equals("exit"));
		scanner.close();
	}
}
