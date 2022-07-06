package edu.curso.java.spring.zspring.bo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CategoriaBo {

	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
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
	public CategoriaBo(Long id, String nombre, List<MaterialBo> materiales) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.materiales = materiales;
	}
	
	public CategoriaBo() {}

}
