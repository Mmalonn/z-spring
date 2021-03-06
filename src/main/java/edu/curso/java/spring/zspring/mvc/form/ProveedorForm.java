package edu.curso.java.spring.zspring.mvc.form;

import javax.validation.constraints.NotBlank;

public class ProveedorForm {

	private Long id;
	@NotBlank
	private String nombre;
	@NotBlank
	private String telefono;
	@NotBlank
	private String direccion;
	
	
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
}
