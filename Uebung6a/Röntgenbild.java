package Uebung6a;

import java.rmi.RemoteException;
import java.util.Date;

public class Röntgenbild implements RöntgenbildIF {
	
	private Date aufnahmeVom;
	private String patientenName;
	private byte[] rowData;
	
	public Röntgenbild() {
		
	}
	
	public Röntgenbild(Date aufnahmeVom, String patientenName, byte[] rowData) {
		super();
		this.aufnahmeVom = aufnahmeVom;
		this.patientenName = patientenName;
		this.rowData = rowData;
	}

	@Override
	public Date getAufnahmeVom() throws RemoteException {
		return this.aufnahmeVom;
	}
	
	@Override
	public String getPatientenName() throws RemoteException {
		return this.patientenName;
	}
	
	@Override
	public byte[] getRowData() throws RemoteException {
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
