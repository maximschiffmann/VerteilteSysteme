package Uebung6b;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FrüherkennungIF extends Remote {
	BerichtIF analysieren(Röntgenbild röntgenbild) throws RemoteException;
}
