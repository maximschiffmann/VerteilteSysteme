package Uebung6c;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FrüherkennungIF extends Remote {
	void analysieren(Röntgenbild röntgenbild, BerichtCallbackIF callback) throws RemoteException;
}
