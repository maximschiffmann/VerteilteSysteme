package Kommunikation;

import java.io.*;
import java.net.*;

public class Server1 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9999); // Bind Application to port 9999

        while (true) {
            Socket client = null;

            try {
                client = server.accept(); // Wait for client connection
                handleConnection(client); // Communication is done within the method handleConection
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (client != null)
                    try {
                        client.close();
                    } catch (IOException e) {
                    }
            }
        }
    }

    private static void handleConnection(Socket client) throws IOException {
        DataInputStream in = new DataInputStream(client.getInputStream());
        DataOutputStream out = new DataOutputStream(client.getOutputStream());

        long factor1 = in.readLong(); // read the numbers received from the client
        long factor2 = in.readLong();

        out.writeLong(factor1 * factor2); // business method and output
        System.out.println("Ergebnis = " + factor1 * factor2);
        in.close();
        out.close();
    }
}