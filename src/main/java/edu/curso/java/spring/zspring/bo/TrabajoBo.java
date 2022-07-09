package edu.curso.java.spring.zspring.bo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class TrabajoBo {

	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	private Date fecha;
	private String tarea;	
	private Double horasEstimadas;
	private Double precioFinal;
	@ManyToOne
	private TrabajadorBo trabajadorBo;
	@OneToMany
	private List<MaterialBo> materiales = new ArrayList<MaterialBo>();
	@OneToOne
	private UbicacionBo ubicacionBo;

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

	public UbicacionBo getUbicacionBo() {
		return ubicacionBo;
	}

	public void setUbicacionBo(UbicacionBo ubicacionBo) {
		this.ubicacionBo = ubicacionBo;
	}

	public List<MaterialBo> getMateriales() {
		return materiales;
	}

	public void setMateriales(List<MaterialBo> materiales) {
		this.materiales = materiales;
	}

	public TrabajadorBo getTrabajadorBo() {
		return trabajadorBo;
	}

	public void setTrabajadorBo(TrabajadorBo trabajadorBo) {
		this.trabajadorBo = trabajadorBo;
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

	public TrabajoBo(String tarea, Double horasEstimadas, Double precioFinal, Long id, String nombre, Date fecha,
			TrabajadorBo trabajadorBo, List<MaterialBo> materiales, UbicacionBo ubicacionBo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
		this.trabajadorBo = trabajadorBo;
		this.materiales = materiales;
		this.ubicacionBo = ubicacionBo;
		this.horasEstimadas = horasEstimadas;
		this.precioFinal = precioFinal;
		this.tarea = tarea;
	}

	public TrabajoBo() {
	}

}
