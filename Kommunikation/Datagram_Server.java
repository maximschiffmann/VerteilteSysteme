package Kommunikation;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.DatagramPacket;

public class Datagram_Server {

	public static void main(String args[]) {
		try {
			// Create DatagramSocket:
			// Port number has to be explicitly given because the number
			// has to be known by the client
			DatagramSocket socket = new DatagramSocket(9999);

			// create Datagram for the receives packet (40 byte buffer)
			DatagramPacket inDatagram = new DatagramPacket(new byte[40], 40);

			while (true) { // Endless loop

				/* Wait for client request: */
				socket.receive(inDatagram);
				// Extract request from the datagram
				byte[] inData = inDatagram.getData();
				int length = inDatagram.getLength();
				String request = new String(inData, 0, length);
				System.out.println("Client says: " + request);

				/* Answer client request: */
				// 1) extract IP address and port of the clients from
				// the recived datagram
				InetAddress clientIP = inDatagram.getAddress();
				int clientPort = inDatagram.getPort();

				// 2) create response datagram
				String response = "Hello Client";
				byte[] content = response.getBytes();
				length = response.length();
				DatagramPacket outDatagram = new DatagramPacket(content, length, clientIP, clientPort);

				// 3) send response datagram
				System.out.println("Send: " + response);
				socket.send(outDatagram);

			} // End of the endless loop
		} catch (Exception e) { // Error handling:
			System.out.println("Error: " + e);
		}
	}
}
