package edu.curso.java.spring.zspring.mvc.form;

import javax.validation.constraints.NotBlank;

public class UsuarioForm {

	@NotBlank
	private String USERNAME;
	@NotBlank
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
