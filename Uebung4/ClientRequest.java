package Uebung4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientRequest implements Runnable {

	private Socket client;
	private MessageStore messageStore;

	public ClientRequest(Socket client, MessageStore messageStore) {
		this.client = client;
		this.messageStore = messageStore;
	}

	@Override
	public void run() {
		try {
			InputStream in = client.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));

			OutputStream out = client.getOutputStream();
			PrintWriter writer = new PrintWriter(out, true);

			while (true) {
				String message = reader.readLine();
				System.out.println(message);
				processMessage(message, writer);
				reader.close();
				writer.close();
			}
		} catch (IOException e) {
			// System.err.println("Lost connection to client!");
		} finally {
			try {
				this.client.close();
			} catch (IOException e) {
				System.out.println("Can't close the client!");
				e.printStackTrace();
			}
		}
	}

	private void processMessage(String message, PrintWriter writer) throws IOException {
		if (message.length() < 3) {
			System.err.println("Wrong input");
			writer.println("Wrong input!");
			return;
		}

		String command = message.substring(0, 3);
		String data = message.substring(3, message.length());
		// System.err.println("command: " + command);

		if (!command.equals("REG") && !command.equals("SND") && !command.equals("RCV")) {
			System.err.println("No command found!");
			writer.println("Command missing!");
			return;
		}
		String from = data.split("#")[0].trim();

		if (command.equals("REG")) {
			String result = this.messageStore.addUser(from);
			writer.println(result);
		}

		if (command.equals("SND")) {
			try {
				String to = data.split("#")[1].trim();
				String text = data.split("#")[2].trim();
				String snd = this.messageStore.sendMessage(from, to, text);
				writer.println(snd);
			} catch (Exception e) {
				writer.println("Not enought parameters exception!");
			}
		}

		if (command.equals("RCV")) {
			writer.println(from + " messages:");
			try {
				ArrayList<String> messages = this.messageStore.printMessages(from);
				for (String s : messages) {
					writer.println(s);
				}
			} catch (Exception e) {
				writer.println("RCV Error!");
			}
		}
	}

}
