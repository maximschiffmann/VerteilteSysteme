package Uebung6b;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class FrüherkennungService implements FrüherkennungIF {
	
	@Override
	public BerichtIF analysieren(Röntgenbild röntgenbild) throws RemoteException {
		Date datum = röntgenbild.getAufnahmeVom();
		String diagnose = "Mord";
		String weiteresVorgehen = "Call 911!";
		BerichtB bericht = new BerichtB(datum, diagnose, weiteresVorgehen);
		BerichtIF berichtStub = (BerichtIF) UnicastRemoteObject.exportObject(bericht, 0);
		return berichtStub;
	}

}
