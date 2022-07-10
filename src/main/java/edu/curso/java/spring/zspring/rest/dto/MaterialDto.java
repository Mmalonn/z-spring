package edu.curso.java.spring.zspring.rest.dto;

import edu.curso.java.spring.zspring.bo.CategoriaBo;
import edu.curso.java.spring.zspring.bo.MaterialBo;
import edu.curso.java.spring.zspring.bo.ProveedorBo;

public class MaterialDto {

	private Long Id;
	private String nombre;
	private Long cantidad;
	private Double precio;
	private ProveedorBo proveedorBo;
	private CategoriaBo categoriaBo;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getCantidad() {
		return cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public ProveedorBo getProveedorBo() {
		return proveedorBo;
	}
	public void setProveedorBo(ProveedorBo proveedorBo) {
		this.proveedorBo = proveedorBo;
	}
	public CategoriaBo getCategoriaBo() {
		return categoriaBo;
	}
	public void setCategoriaBo(CategoriaBo categoriaBo) {
		this.categoriaBo = categoriaBo;
	}
	public MaterialDto(Long id, String nombre, Long cantidad, Double precio, ProveedorBo proveedorBo, CategoriaBo categoriaBo) {
		super();
		Id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.proveedorBo = proveedorBo;
		this.categoriaBo = categoriaBo;
	}
	public MaterialDto(MaterialBo material) {
		this.Id = material.getId();
		this.nombre = material.getNombre();
		this.cantidad = material.getCantidad();
		this.precio = material.getPrecio();
		this.proveedorBo = material.getProveedorBo();
		this.categoriaBo = material.getCategoriaBo();
	}
}
