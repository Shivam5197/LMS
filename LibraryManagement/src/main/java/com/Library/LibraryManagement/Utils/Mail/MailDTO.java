package com.Library.LibraryManagement.Utils.Mail;

public class MailDTO {

	private String FROM;
	private String PASSWORD;
	private String SMTP_HOST;
	private String MESSAGE;
	private String SUBJECT;
	private String TO;
	public MailDTO() {

	}

	public MailDTO(String fROM, String pASSWORD, String sMTP_HOST, String mESSAGE, String sUBJECT, String tO) {
		super();
		FROM = fROM;
		PASSWORD = pASSWORD;
		SMTP_HOST = sMTP_HOST;
		MESSAGE = mESSAGE;
		SUBJECT = sUBJECT;
		TO = tO;
	}


	public String getFROM() {
		return FROM;
	}
	public void setFROM(String fROM) {
		FROM = fROM;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public String getSMTP_HOST() {
		return SMTP_HOST;
	}
	public void setSMTP_HOST(String sMTP_HOST) {
		SMTP_HOST = sMTP_HOST;
	}
	public String getMESSAGE() {
		return MESSAGE;
	}

	public void setMESSAGE(String mESSAGE) {
		MESSAGE = mESSAGE;
	}

	public String getSUBJECT() {
		return SUBJECT;
	}

	public void setSUBJECT(String sUBJECT) {
		SUBJECT = sUBJECT;
	}

	
	
	public String getTO() {
		return TO;
	}


	public void setTO(String tO) {
		TO = tO;
	}


	@Override
	public String toString() {
		return "{\"FROM\":\"" + FROM + "\", \"PASSWORD\":\"" + PASSWORD + "\", \"SMTP_HOST\":\"" + SMTP_HOST
				+ "\", \"MESSAGE\":\"" + MESSAGE + "\", \"SUBJECT\":\"" + SUBJECT + "\", \"TO\":\"" + TO + "\"}";
	}

	
}
