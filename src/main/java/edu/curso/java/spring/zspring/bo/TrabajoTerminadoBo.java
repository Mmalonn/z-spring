package edu.curso.java.spring.zspring.bo;

import java.sql.Date;
import javax.persistence.Entity;

@Entity
public class TrabajoTerminadoBo extends TrabajoBo {

	private Date fechaFinalizacion;

	public TrabajoTerminadoBo() {}
	
	public TrabajoTerminadoBo(Date fechaFinalizacion) {
		super();
		this.fechaFinalizacion = fechaFinalizacion;
	}

	public Date getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(Date fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}
	
	
}
