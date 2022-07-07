package edu.curso.java.spring.zspring.rest.dto;

import java.sql.Date;
import java.util.List;

import edu.curso.java.spring.zspring.bo.MaterialBo;
import edu.curso.java.spring.zspring.bo.TrabajadorBo;
import edu.curso.java.spring.zspring.bo.TrabajoBo;
import edu.curso.java.spring.zspring.bo.UbicacionBo;

public class TrabajoTerminadoDto extends TrabajoBo {

	private Date fechaFinalizacion;

	public Date getFechaFinalizacion() {
		return fechaFinalizacion;
	}
	public void setFechaFinalizacion(Date fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}
	public TrabajoTerminadoDto(Long id, String nombre, Date fecha, TrabajadorBo trabajadorBo,
			List<MaterialBo> materiales, UbicacionBo ubicacionBo, Date fechaFinalizacion) {
		super(id, nombre, fecha, trabajadorBo, materiales, ubicacionBo);
		this.fechaFinalizacion = fechaFinalizacion;
	}
	public TrabajoTerminadoDto() {}
	
}
