package edu.curso.java.spring.zspring.rest.dto;

import edu.curso.java.spring.zspring.bo.TrabajoBo;

public class UbicacionDto {

	private Long id;
	private String calle;
	private String numero;
	private TrabajoBo trabajoBo;
	
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
	public TrabajoBo getTrabajoBo() {
		return trabajoBo;
	}
	public void setTrabajoBo(TrabajoBo trabajoBo) {
		this.trabajoBo = trabajoBo;
	}
	public UbicacionDto(Long id, String calle, String numero, TrabajoBo trabajoBo) {
		super();
		this.id = id;
		this.calle = calle;
		this.numero = numero;
		this.trabajoBo = trabajoBo;
	}
	public UbicacionDto() {}
}
