package Uebung6a;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Uebung5.Bericht;

public interface FrüherkennungIF extends Remote {
	BerichtA analysieren(RöntgenbildIF röntgenbildIf) throws RemoteException;
}
