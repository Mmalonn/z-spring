package edu.curso.java.spring.zspring.rest.dto;

import java.util.ArrayList;
import java.util.List;

import edu.curso.java.spring.zspring.bo.MaterialBo;
import edu.curso.java.spring.zspring.bo.ProveedorBo;

public class ProveedorDto {

	private Long id;
	private String nombre;
	private String telefono;
	private List<MaterialBo> materiales = new ArrayList<MaterialBo>();
	private String direccion;
	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
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
	public ProveedorDto(Long id, String nombre, String direccion, String telefono, List<MaterialBo> materiales) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.materiales = materiales;
		this.direccion = direccion;
	}
	public ProveedorDto(ProveedorBo proveedor) {
		this.id = proveedor.getId();
		this.nombre = proveedor.getNombre();
		this.telefono = proveedor.getTelefono();
		this.materiales = proveedor.getMateriales();
		this.direccion = proveedor.getDireccion();
	}
	
}
