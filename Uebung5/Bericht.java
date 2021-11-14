package Uebung5;

import java.io.Serializable;
import java.util.Date;

public class Bericht implements Serializable {

	private Date datum;
	private String diagnose;
	private String weitersVorgehen;

	public Bericht() {
	}

	public Bericht(Date datum, String diagnose, String weitersVorgehen) {
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
