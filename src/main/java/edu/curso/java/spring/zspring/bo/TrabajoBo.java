package edu.curso.java.spring.zspring.bo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


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
	@JsonIgnore
	private TrabajadorBo trabajadorBo;
	@ElementCollection
	private List<String> materiales = new ArrayList<String>();
	@OneToOne
	private UbicacionBo ubicacionBo;
	@OneToOne
	private FacturaBo factura;
 
	public FacturaBo getFactura() {
		return factura;
	}

	public void setFactura(FacturaBo factura) {
		this.factura = factura;
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

	public UbicacionBo getUbicacionBo() {
		return ubicacionBo;
	}

	public void setUbicacionBo(UbicacionBo ubicacionBo) {
		this.ubicacionBo = ubicacionBo;
	}

	public List<String> getMateriales() {
		return materiales;
	}

	public void setMateriales(List<String> materiales) {
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
			TrabajadorBo trabajadorBo, List<String> materiales, UbicacionBo ubicacionBo, FacturaBo factura) {
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
		this.factura = factura;
	}

	public TrabajoBo() {
	}

}
