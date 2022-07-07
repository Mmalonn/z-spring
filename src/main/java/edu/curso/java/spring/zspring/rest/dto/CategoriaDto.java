package edu.curso.java.spring.zspring.rest.dto;

import java.util.ArrayList;
import java.util.List;

import edu.curso.java.spring.zspring.bo.MaterialBo;

public class CategoriaDto {

	private Long id;
	private String nombre;
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
	public List<MaterialBo> getMateriales() {
		return materiales;
	}
	public void setMateriales(List<MaterialBo> materiales) {
		this.materiales = materiales;
	}
	public CategoriaDto(Long id, String nombre, List<MaterialBo> materiales) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.materiales = materiales;
	}
	public CategoriaDto() {}
}
