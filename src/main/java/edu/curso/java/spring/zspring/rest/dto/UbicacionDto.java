package edu.curso.java.spring.zspring.rest.dto;

import edu.curso.java.spring.zspring.bo.TrabajoBo;
import edu.curso.java.spring.zspring.bo.UbicacionBo;

public class UbicacionDto {

	private Long id;
	private String calle;
	private String numero;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}

	public UbicacionDto(Long id, String calle, String numero, TrabajoBo trabajoBo) {
		super();
		this.id = id;
		this.calle = calle;
		this.numero = numero;
	}
	public UbicacionDto(UbicacionBo ubicacion) {
		this.id = ubicacion.getId();
		this.calle = ubicacion.getCalle();
		this.numero = ubicacion.getNumero();
	}
}
