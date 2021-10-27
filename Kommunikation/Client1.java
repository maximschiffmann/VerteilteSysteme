package Kommunikation;

import java.net.Socket;
import java.util.Scanner;
import java.io.*; //InputStream, OutputStream, DataStream etc.

public class Client1 {
	public static void main(String args[]) {
		Socket server = null; // Reference to Server
		Scanner sc = new Scanner(System.in);
		long output = 0;
		while (output > -1) {
			try {
				server = new Socket("localhost", 9999); // builds up a connection to the server socket

				// Get input and output stream:
				DataOutputStream out = new DataOutputStream(server.getOutputStream());
				DataInputStream in = new DataInputStream(server.getInputStream());

				// Communication
				// out.write(4); // send one byte (first number) to the server
				// out.write(20); // send one byte (second number) to the server
				// int result = in.read(); // read one byte (the result) from the input stream
				// System.out.println(result); // Print the result on the system console

				output = sc.nextInt();
				out.writeLong(output);
				output = sc.nextInt();
				out.writeLong(output);
				long result = in.readLong();
				System.out.println(result);

			} catch (IOException e) {// error handling, see later
				e.printStackTrace(); // print the error on the system console
			} finally { // close connection
				if (server != null)
					try {
						server.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
		}
	}
}
