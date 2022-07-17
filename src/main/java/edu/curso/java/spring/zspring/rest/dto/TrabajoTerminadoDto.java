package edu.curso.java.spring.zspring.rest.dto;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import edu.curso.java.spring.zspring.bo.TrabajoTerminadoBo;

public class TrabajoTerminadoDto {

	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	private Date fecha;
	private String trabajadorBo;
	private String ubicacionBo;
	private LocalDate fechaFinalizacion;
	private String tarea;
	private Double horasEstimadas;
	private Double precioFinal;

	public Long getId() {
		return id;
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

	public String getTrabajadorBo() {
		return trabajadorBo;
	}

	public void setTrabajadorBo(String trabajadorBo) {
		this.trabajadorBo = trabajadorBo;
	}

	public String getUbicacionBo() {
		return ubicacionBo;
	}

	public void setUbicacionBo(String ubicacionBo) {
		this.ubicacionBo = ubicacionBo;
	}

	public LocalDate getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(LocalDate fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

	public TrabajoTerminadoDto(String tarea, Double horasEstimadas, Double precioFinal, Long id, String nombre,
			Date fecha, String trabajadorBo, String ubicacionBo,
			LocalDate fechaFinalizacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
		this.trabajadorBo = trabajadorBo;
		this.ubicacionBo = ubicacionBo;
		this.fechaFinalizacion = fechaFinalizacion;
		this.tarea = tarea;
		this.horasEstimadas = horasEstimadas;
		this.precioFinal= precioFinal;
	}

	public TrabajoTerminadoDto(TrabajoTerminadoBo tTerminado) {
		this.id = tTerminado.getId();
		this.nombre = tTerminado.getNombre();
		this.fecha = tTerminado.getFecha();
		this.trabajadorBo = tTerminado.getTrabajadorBo();
		this.ubicacionBo = tTerminado.getUbicacionBo();
		this.fechaFinalizacion = tTerminado.getFechaFinalizacion();
		this.tarea = tTerminado.getTarea();
		this.horasEstimadas = tTerminado.getHorasEstimadas();
		this.precioFinal= tTerminado.getPrecioFinal();
	}

}
