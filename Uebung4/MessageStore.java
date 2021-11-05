package Uebung4;

import java.util.ArrayList;
import java.util.HashMap;

public class MessageStore {

	private HashMap<String, ArrayList<String>> messages = new HashMap<String, ArrayList<String>>();

	public synchronized String addUser(String from) {
		String result;
		if (!messages.containsKey(from)) {
			messages.put(from, new ArrayList<String>());
			result = "New User: " + from;
			System.out.println(result);
		} else {
			result = "User already exist!";
			System.out.println(result);
		}
		return result;
	}

	public synchronized String sendMessage(String from, String to, String text) {
		String message = " ";
		String error = "Can't find user!";
		if (messages.containsKey(from) && messages.containsKey(to)) {
			message = "SND" + from + "#" + to + "#" + text;
			messages.get(from).add(message);
			messages.get(to).add(message);
		} else {
			System.err.println(error);
			message = error;
		}
		return message;
	}

	public synchronized ArrayList<String> printMessages(String from) {
		ArrayList<String> tmpMessages = new ArrayList<String>();

		if (messages.containsKey(from)) {
			System.out.println(from + " messages:");
			for (String s : messages.get(from)) {
				System.out.println(s);
				tmpMessages.add(s);
			}
		} else {
			tmpMessages.add("No messages!");
		}
		return tmpMessages;
	}

}
