package Uebung6b;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

interface BerichtIF extends Remote {
	Date getDatum() throws RemoteException;
	String getDiagnose() throws RemoteException;
	String getWeitersVorgehen() throws RemoteException;
}
