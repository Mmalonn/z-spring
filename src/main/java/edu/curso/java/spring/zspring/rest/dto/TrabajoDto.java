package edu.curso.java.spring.zspring.rest.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import edu.curso.java.spring.zspring.bo.MaterialBo;
import edu.curso.java.spring.zspring.bo.TrabajadorBo;
import edu.curso.java.spring.zspring.bo.TrabajoBo;
import edu.curso.java.spring.zspring.bo.UbicacionBo;

public class TrabajoDto {

	private Long id;
	private String nombre;
	private Date fecha;
	private TrabajadorBo trabajadorBo;
	private List<String> materiales = new ArrayList<String>();
	private UbicacionBo ubicacionBo;
	private String tarea;
	private Double horasEstimadas;
	private Double precioFinal;

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

	public List<String> getMateriales() {
		return materiales;
	}

	public void setMateriales(List<String> materiales) {
		this.materiales = materiales;
	}

	public UbicacionBo getUbicacionBo() {
		return ubicacionBo;
	}

	public void setUbicacionBo(UbicacionBo ubicacionBo) {
		this.ubicacionBo = ubicacionBo;
	}

	public TrabajoDto(String tarea, Double horasEstimadas, Double precioFinal, Long id, String nombre, Date fecha,
			TrabajadorBo trabajadorBo, List<String> materiales, UbicacionBo ubicacionBo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
		this.trabajadorBo = trabajadorBo;
		this.materiales = materiales;
		this.ubicacionBo = ubicacionBo;
		this.tarea = tarea;
		this.horasEstimadas = horasEstimadas;
		this.precioFinal= precioFinal;
	}

	public TrabajoDto(TrabajoBo trabajo) {
		this.id = trabajo.getId();
		this.nombre = trabajo.getNombre();
		this.fecha = trabajo.getFecha();
		this.trabajadorBo = trabajo.getTrabajadorBo();
		this.materiales = trabajo.getMateriales();
		this.ubicacionBo = trabajo.getUbicacionBo();
		this.tarea = trabajo.getTarea();
		this.horasEstimadas = trabajo.getHorasEstimadas();
		this.precioFinal= trabajo.getPrecioFinal();
	}
}
