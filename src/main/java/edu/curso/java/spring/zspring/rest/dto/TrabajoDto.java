package edu.curso.java.spring.zspring.rest.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import edu.curso.java.spring.zspring.bo.MaterialBo;
import edu.curso.java.spring.zspring.bo.TrabajadorBo;
import edu.curso.java.spring.zspring.bo.UbicacionBo;

public class TrabajoDto {

	private Long id;
	private String nombre;
	private Date fecha;
	private TrabajadorBo trabajadorBo;
	private List<MaterialBo> materiales = new ArrayList<MaterialBo>();
	private UbicacionBo ubicacionBo;
	
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public TrabajadorBo getTrabajadorBo() {
		return trabajadorBo;
	}
	public void setTrabajadorBo(TrabajadorBo trabajadorBo) {
		this.trabajadorBo = trabajadorBo;
	}
	public List<MaterialBo> getMateriales() {
		return materiales;
	}
	public void setMateriales(List<MaterialBo> materiales) {
		this.materiales = materiales;
	}
	public UbicacionBo getUbicacionBo() {
		return ubicacionBo;
	}
	public void setUbicacionBo(UbicacionBo ubicacionBo) {
		this.ubicacionBo = ubicacionBo;
	}
	public TrabajoDto(Long id, String nombre, Date fecha, TrabajadorBo trabajadorBo, List<MaterialBo> materiales,
			UbicacionBo ubicacionBo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
		this.trabajadorBo = trabajadorBo;
		this.materiales = materiales;
		this.ubicacionBo = ubicacionBo;
	}
	public TrabajoDto() {}
}
