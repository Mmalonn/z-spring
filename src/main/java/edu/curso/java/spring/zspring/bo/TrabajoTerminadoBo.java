package edu.curso.java.spring.zspring.bo;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class TrabajoTerminadoBo {

	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	private String tarea;
	private Double horasEstimadas;
	private Double precioFinal;
	private Date fecha;
	private String trabajadorBo;
	private String ubicacionBo;
	private LocalDate fechaFinalizacion;

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

	public TrabajoTerminadoBo(String tarea, Double horasEstimadas, Double precioFinal, Long id, String nombre,
			Date fecha, String trabajadorBo, List<String> materiales, String ubicacionBo,
			LocalDate fechaFinalizacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
		this.trabajadorBo = trabajadorBo;
		this.ubicacionBo = ubicacionBo;
		this.fechaFinalizacion = fechaFinalizacion;
		this.horasEstimadas = horasEstimadas;
		this.precioFinal = precioFinal;
		this.tarea = tarea;
	}

	public TrabajoTerminadoBo() {
	}

}
