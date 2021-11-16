package Uebung6a;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface RöntgenbildIF extends Remote {	
	Date getAufnahmeVom() throws RemoteException;
	String getPatientenName() throws RemoteException;
	byte[] getRowData() throws RemoteException;
}
