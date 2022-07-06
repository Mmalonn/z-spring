package edu.curso.java.spring.zspring.bo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ProveedorBo {

	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	private String telefono;
	@OneToMany
	private List<MaterialBo> materiales = new ArrayList<MaterialBo>();
	
	public List<MaterialBo> getMateriales() {
		return materiales;
	}
	public void setMateriales(List<MaterialBo> materiales) {
		this.materiales = materiales;
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
	public ProveedorBo(Long id, String nombre, String telefono, List<MaterialBo> materiales) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.materiales = materiales;
	}
	
	public ProveedorBo() {}
	
}
