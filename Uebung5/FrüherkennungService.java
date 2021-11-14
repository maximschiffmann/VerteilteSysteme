package Uebung5;

import java.rmi.RemoteException;
import java.util.Date;

public class FrüherkennungService implements FrüherkennungIF {
	
	@Override
	public Bericht analysieren(Röntgenbild röntgenbild) throws RemoteException {
		Date datum = röntgenbild.getAufnahmeVom();
		String diagnose = "Mord";
		String weiteresVorgehen = "Call 911!";
		Bericht bericht = new Bericht(datum, diagnose, weiteresVorgehen);
		return bericht;
	}

}
