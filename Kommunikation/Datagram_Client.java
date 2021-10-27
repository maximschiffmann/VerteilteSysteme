package Kommunikation;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.DatagramPacket;

public class Datagram_Client {

	public static void main(String args[]) {
		try {
			// Create UDP Socket and bind it to an arbitrary port:
			DatagramSocket socket = new DatagramSocket();

			// IP-Address of the server
			InetAddress serverIP = InetAddress.getByName("localhost");

			/* send "Hello Server" */
			// ? create Datagram containing the message and address
			// - Because a Datagram expects a byte array the String
			// �Hello Server� has to be converted into a byte array
			String message = "Hello Server";
			byte[] content = message.getBytes();
			int contentLength = message.length();
			DatagramPacket packet = new DatagramPacket(content, contentLength, serverIP, 9999);
			System.out.println("Send: Hello Server"); // console
			socket.send(packet);

			/* receive "Hello Client" */
			// create empty Datagram.
			// Buffer size is set to generous 1024 bytes.
			packet = new DatagramPacket(new byte[1024], 1024);
			socket.receive(packet);
			// Take message from the received datagram
			byte[] inData = packet.getData();
			int length = packet.getLength();
			// Convert message into a String
			String response = new String(inData, 0, length);
			System.out.println("Server response: " + response);

			/* Hier w�rde die Uhrzeit-Sequenz folgen */

			socket.close();

		} catch (Exception e) {// Error:
			System.out.println("Error: " + e);
		}
	}

}
