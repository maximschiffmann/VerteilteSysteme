package Uebung5;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;

public class Client {

	public static void main(String[] args) throws RemoteException, NotBoundException {
		int port = 1111;

		Registry r = LocateRegistry.getRegistry("localhost", port);

		FrüherkennungIF stub = (FrüherkennungIF) r.lookup("Bericht");

		Date aufnahmeVom = new Date();
		String patientenName = "Tom";
		byte[] rawData = { 1, 2, 1, 2 };

		Röntgenbild röntgenbild = new Röntgenbild(aufnahmeVom, patientenName, rawData);
		Bericht berichtVomServer = stub.analysieren(röntgenbild);
		
		System.out.println(berichtVomServer.toString());

	}

}
