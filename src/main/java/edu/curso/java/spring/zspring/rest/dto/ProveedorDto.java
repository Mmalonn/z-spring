package edu.curso.java.spring.zspring.rest.dto;

import java.util.ArrayList;
import java.util.List;

import edu.curso.java.spring.zspring.bo.MaterialBo;

public class ProveedorDto {

	private Long id;
	private String nombre;
	private String telefono;
	private List<MaterialBo> materiales = new ArrayList<MaterialBo>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public List<MaterialBo> getMateriales() {
		return materiales;
	}
	public void setMateriales(List<MaterialBo> materiales) {
		this.materiales = materiales;
	}
	public ProveedorDto(Long id, String nombre, String telefono, List<MaterialBo> materiales) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.materiales = materiales;
	}
	public ProveedorDto() {}
	
}
