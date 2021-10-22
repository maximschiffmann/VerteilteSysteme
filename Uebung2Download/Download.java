package Uebung2Download;


import java.util.Random;
import java.util.concurrent.CountDownLatch;

import javax.swing.JProgressBar;

// aktive Klasse
public class Download implements Runnable {
	
	private final JProgressBar balken;
    // weitere Attribute zur Synchronisation hier definieren
	private CountDownLatch start;
	private CountDownLatch finish;
    
	public Download(JProgressBar balken, CountDownLatch start, CountDownLatch finish) {
		this.balken = balken;
		this.start = start;
		this.finish = finish;
    }

	@Override
	public void run() {
		/*  hier die Methode definieren, die jeweils den Balken weiterschiebt
		 *  Mit balken.getMaximum() bekommt man den Wert fuer 100 % gefuellt
		 *  Mit balken.setValue(...) kann man den Balken einstellen (wieviel gefuellt) dargestellt wird
		 *  Setzen Sie den value jeweils und legen Sie die Methode dann für eine zufaellige Zeit schlafen
		 */
		try {
			start.await();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		while(balken.getValue() < balken.getMaximum()) {
			try {
				Thread.sleep(new Random().nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int valueCurrent = this.balken.getValue();
			int value = new Random().nextInt(10);
			this.balken.setValue(valueCurrent + value);
		}
		finish.countDown();
	}
}
