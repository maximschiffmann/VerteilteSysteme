package Uebung5;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FrüherkennungIF extends Remote {
	Bericht analysieren(Röntgenbild röntgenbild) throws RemoteException;
}
