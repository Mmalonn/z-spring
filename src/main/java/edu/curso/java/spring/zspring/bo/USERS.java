package edu.curso.java.spring.zspring.bo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class USERS {

	@Id
	private String USERNAME;
	private String PASSWORD;
	private String ENABLED;
	
	

	public String getUSERNAME() {
		return USERNAME;
	}
	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public String getENABLED() {
		return ENABLED;
	}
	public void setENABLED(String eNABLED) {
		ENABLED = eNABLED;
	}
	
	
}
