package Uebung6a;

import java.rmi.RemoteException;
import java.util.Date;

public class FrüherkennungService implements FrüherkennungIF {
	
	@Override
	public BerichtA analysieren(RöntgenbildIF röntgenbild) throws RemoteException {
		Date datum = röntgenbild.getAufnahmeVom();
		String diagnose = "Mord";
		String weiteresVorgehen = "Call 911!";
		BerichtA bericht = new BerichtA(datum, diagnose, weiteresVorgehen);
		return bericht;
	}

}
