package edu.curso.java.spring.zspring.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class MaterialBo {

	@Id
	@GeneratedValue
	private Long Id;
	private String nombre;
	private Long cantidad;
	private Double precio;
	@JsonIgnore
	@ManyToOne
	private ProveedorBo proveedorBo;
	@JsonIgnore
	@ManyToOne
	private CategoriaBo categoriaBo;
	
	
	
	public CategoriaBo getCategoriaBo() {
		return categoriaBo;
	}
	public void setCategoriaBo(CategoriaBo categoriaBo) {
		this.categoriaBo = categoriaBo;
	}
	

	public ProveedorBo getProveedorBo() {
		return proveedorBo;
	}
	public void setProveedorBo(ProveedorBo proveedorBo) {
		this.proveedorBo = proveedorBo;
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
	public MaterialBo(Long id, String nombre, Long cantidad, Double precio, ProveedorBo proveedorBo,
			CategoriaBo categoriaBo) {
		super();
		Id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.proveedorBo = proveedorBo;
		this.categoriaBo = categoriaBo;

	}
	
	public MaterialBo() {}
	
	
}
