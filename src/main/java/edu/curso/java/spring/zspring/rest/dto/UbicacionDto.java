package edu.curso.java.spring.zspring.rest.dto;

import edu.curso.java.spring.zspring.bo.TrabajoBo;
import edu.curso.java.spring.zspring.bo.UbicacionBo;

public class UbicacionDto {

	private Long id;
	private String direccion;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public UbicacionDto(Long id, String direccion, TrabajoBo trabajoBo) {
		super();
		this.id = id;
		this.direccion = direccion;
	}
	public UbicacionDto(UbicacionBo ubicacion) {
		this.id = ubicacion.getId();
		this.direccion = ubicacion.getDireccion();
	}
}
