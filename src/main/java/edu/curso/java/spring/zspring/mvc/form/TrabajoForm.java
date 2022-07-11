package edu.curso.java.spring.zspring.mvc.form;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import edu.curso.java.spring.zspring.bo.MaterialBo;
import edu.curso.java.spring.zspring.bo.TrabajadorBo;
import edu.curso.java.spring.zspring.bo.UbicacionBo;

public class TrabajoForm {

	private Long id;
	private String nombre;
	private Date fecha;
	private String tarea;	
	private Double horasEstimadas;
	private Double precioFinal;
	private TrabajadorBo trabajadorBo;
	private MaterialBo material;
	private UbicacionBo ubicacionBo;
	private List<MaterialBo> materiales = new ArrayList<MaterialBo>();
	
	
	
	public List<MaterialBo> getMateriales() {
		return materiales;
	}
	public void setMateriales(List<MaterialBo> materiales) {
		this.materiales = materiales;
	}
	public MaterialBo getMaterial() {
		return material;
	}
	public void setMaterial(MaterialBo material) {
		this.material = material;
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getTarea() {
		return tarea;
	}
	public void setTarea(String tarea) {
		this.tarea = tarea;
	}
	public Double getHorasEstimadas() {
		return horasEstimadas;
	}
	public void setHorasEstimadas(Double horasEstimadas) {
		this.horasEstimadas = horasEstimadas;
	}
	public Double getPrecioFinal() {
		return precioFinal;
	}
	public void setPrecioFinal(Double precioFinal) {
		this.precioFinal = precioFinal;
	}
	public TrabajadorBo getTrabajadorBo() {
		return trabajadorBo;
	}
	public void setTrabajadorBo(TrabajadorBo trabajadorBo) {
		this.trabajadorBo = trabajadorBo;
	}
	public UbicacionBo getUbicacionBo() {
		return ubicacionBo;
	}
	public void setUbicacionBo(UbicacionBo ubicacionBo) {
		this.ubicacionBo = ubicacionBo;
	}
	
	
	
}
