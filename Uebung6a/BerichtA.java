package Uebung6a;

import java.io.Serializable;
import java.util.Date;

public class BerichtA implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Date datum;
	private String diagnose;
	private String weitersVorgehen;

	public BerichtA() {
	}

	public BerichtA(Date datum, String diagnose, String weitersVorgehen) {
		this.datum = datum;
		this.diagnose = diagnose;
		this.weitersVorgehen = weitersVorgehen;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getDiagnose() {
		return diagnose;
	}

	public void setDiagnose(String diagnose) {
		this.diagnose = diagnose;
	}

	public String getWeitersVorgehen() {
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
