package Uebung6c;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BerichtCallbackIF extends Remote {
    public void uebertrageBericht(Bericht bericht) throws RemoteException;
}
