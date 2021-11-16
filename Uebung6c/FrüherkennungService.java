package Uebung6c;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FrüherkennungService implements FrüherkennungIF {
	
	private static int nummerLetzerBericht = 0;
	
	@Override
	public void analysieren(Röntgenbild röntgenbild, BerichtCallbackIF callback) throws RemoteException {
        
        System.out.println("Roentgenbild vom " + röntgenbild.getAufnahmeVom() + " wird analysiert! Dauert ca. 10 Sekunden...");
        
        // langsame Verarbeitung muss wegen sleep in Thread erfolgen, sonst returnt diese Methode nicht sofort!
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(10);

                    System.out.println("...bin mit Analyse fertig, Bericht wird jetzt ueber den Callback-Stub an Client uebertragen!");
                    Bericht antwort = new Bericht( new Date(), "alles okay [Bericht Nr. " + ++nummerLetzerBericht + "]", "Neue Vorsorgeuntersuchung in 2 Jahren erbeten");
                    callback.uebertrageBericht(antwort);
                } catch (RemoteException | InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
        
	}

}
