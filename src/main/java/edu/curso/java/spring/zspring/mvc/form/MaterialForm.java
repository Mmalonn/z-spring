package edu.curso.java.spring.zspring.mvc.form;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import edu.curso.java.spring.zspring.bo.CategoriaBo;
import edu.curso.java.spring.zspring.bo.ProveedorBo;

public class MaterialForm {

	private Long Id;
	@NotNull
	private Long idCategoria;
	@NotNull
	private Long idProveedor;
	@NotBlank
	private String nombre;
	@NotNull
	@Positive
	private Long cantidad;
	@NotNull
	@Positive
	private Double precio;
	private ProveedorBo proveedorBo;
	private CategoriaBo categoriaBo;
	
	public Long getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}
	public Long getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(Long idProveedor) {
		this.idProveedor = idProveedor;
	}
	
	
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
	
	
	
}
