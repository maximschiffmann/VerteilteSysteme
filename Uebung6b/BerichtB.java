package Uebung6b;

import java.rmi.RemoteException;
import java.util.Date;

public class BerichtB implements BerichtIF {
	
	private Date datum;
	private String diagnose;
	private String weitersVorgehen;

	public BerichtB() {
	}

	public BerichtB(Date datum, String diagnose, String weitersVorgehen) {
		this.datum = datum;
		this.diagnose = diagnose;
		this.weitersVorgehen = weitersVorgehen;
	}

	@Override
	public Date getDatum() throws RemoteException {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}
	
	@Override
	public String getDiagnose() throws RemoteException {
		return diagnose;
	}

	public void setDiagnose(String diagnose) {
		this.diagnose = diagnose;
	}
	
	@Override
	public String getWeitersVorgehen() throws RemoteException {
		return weitersVorgehen;
	}

	public void setWeitersVorgehen(String weitersVorgehen) {
		this.weitersVorgehen = weitersVorgehen;
	}

	@Override
	public String toString() {
		return "Bericht [datum=" + datum + ", diagnose=" + diagnose + ", weitersVorgehen=" + weitersVorgehen + "]";
	}

}
