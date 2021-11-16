package Uebung6b;

import java.io.Serializable;
import java.util.Date;

public class Röntgenbild implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Date aufnahmeVom;
	private String patientenName;
	private byte[] rowData;
	
	public Röntgenbild() {
		
	}
	
	public Röntgenbild(Date aufnahmeVom, String patientenName, byte[] rowData) {
		this.aufnahmeVom = aufnahmeVom;
		this.patientenName = patientenName;
		this.rowData = rowData;
	}

	public Date getAufnahmeVom(){
		return this.aufnahmeVom;
	}
	
	public String getPatientenName() {
		return this.patientenName;
	}
	
	public byte[] getRowData() {
		return this.rowData;
	}

	public void setAufnahmeVom(Date aufnahmeVom) {
		this.aufnahmeVom = aufnahmeVom;
	}

	public void setPatientenName(String patientenName) {
		this.patientenName = patientenName;
	}

	public void setRowData(byte[] rowData) {
		this.rowData = rowData;
	}
	
	
}
