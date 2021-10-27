package Kommunikation;

import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Date;

public class ServerThread {

    public static void main(String args[]) {
        try {
            // creates an server on port 9999
            ServerSocket ss = new ServerSocket(9999);
            System.out.println("Server running");

            while (true) { // endless loop
                // wait for client request
                Socket client_request = ss.accept();
                System.out.println("Client is connected!");

                // Handle Client request within an own thread:
                // 1. Create thread
                Thread worker = new Worker(client_request);
                // 2. Start Thread
                worker.start();
                System.out.println("Worker is running");

            }
        } catch (IOException e) {
            // I/O-Error:
            System.out.println("Error: " + e);
        }
    }

}

// The worker class that handles all communication with the client. One instance
// per client.
class Worker extends Thread {
    Socket mySocket;

    // Constructor
    Worker(Socket request) {
        mySocket = request;
    }

    public void run() {
        try {
            // get actual time = start time
            Date now = new Date();

            // Streams initialisieren:
            InputStream in = mySocket.getInputStream();
            OutputStream out = new BufferedOutputStream(mySocket.getOutputStream(), 128);

            // receive "Hello Server"
            byte[] message = new byte[1024];
            in.read(message);
            System.out.println("Client says: " + new String(message));

            // Wait 10000 Millisecods = 10 Seconds
            sleep(10000); // to simulate an hard working server

            // Send "Hello Client" and the start time
            System.out.println("send: Hello Client! " + now);
            out.write(("Hello Client! " + now).getBytes());
            out.flush();

            // Close Connection:
            in.close();
            out.close();
            mySocket.close();

        } catch (Exception e) {
            // I/O-Error:
            System.out.println("Error: " + e);
        }
    }
}
