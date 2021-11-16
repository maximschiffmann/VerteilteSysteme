package Uebung6a;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {

	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		int port = 1111;
		Registry r = LocateRegistry.createRegistry(port);
		
		FrüherkennungIF früherkennung = new FrüherkennungService();
		FrüherkennungIF skeleton = (FrüherkennungIF)UnicastRemoteObject.exportObject(früherkennung, 0);
		r.bind("Bericht", skeleton);
		
		System.out.println("Server started!");
	}

}
