package edu.curso.java.spring.zspring.rest.dto;

import edu.curso.java.spring.zspring.bo.CategoriaBo;
import edu.curso.java.spring.zspring.bo.ProveedorBo;
import edu.curso.java.spring.zspring.bo.TrabajoBo;

public class MaterialDto {

	private Long Id;
	private String nombre;
	private Long cantidad;
	private Double precio;
	private ProveedorBo proveedorBo;
	private TrabajoBo trabajoBo;
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
	public TrabajoBo getTrabajoBo() {
		return trabajoBo;
	}
	public void setTrabajoBo(TrabajoBo trabajoBo) {
		this.trabajoBo = trabajoBo;
	}
	public CategoriaBo getCategoriaBo() {
		return categoriaBo;
	}
	public void setCategoriaBo(CategoriaBo categoriaBo) {
		this.categoriaBo = categoriaBo;
	}
	public MaterialDto(Long id, String nombre, Long cantidad, Double precio, ProveedorBo proveedorBo,
			TrabajoBo trabajoBo, CategoriaBo categoriaBo) {
		super();
		Id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.proveedorBo = proveedorBo;
		this.trabajoBo = trabajoBo;
		this.categoriaBo = categoriaBo;
	}
	public MaterialDto() {}
}
