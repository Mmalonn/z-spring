package edu.curso.java.spring.zspring.bo;

import java.sql.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FacturaBo {

	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	private Date fecha;
	private String tarea;	
	private Double horasEstimadas;
	private Double precioFinal;
	private String trabajadorBo;
	private String ubicacionBo;
	private String Material1;
	private String Material2;
	private String Material3;
	private Long cantidad1;
	private Long cantidad2;
	private Long cantidad3;
	private Long precioT;
	private Long precioM1;
	private Long precioM2;
	private Long precioM3;
	
	
	
	public FacturaBo(Long id, String nombre, Date fecha, String tarea, Double horasEstimadas, Double precioFinal,
			String trabajadorBo, String ubicacionBo, String material1, String material2, String material3,
			Long cantidad1, Long cantidad2, Long cantidad3, Long precioT, Long precioM1, Long precioM2, Long precioM3) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
		this.tarea = tarea;
		this.horasEstimadas = horasEstimadas;
		this.precioFinal = precioFinal;
		this.trabajadorBo = trabajadorBo;
		this.ubicacionBo = ubicacionBo;
		Material1 = material1;
		Material2 = material2;
		Material3 = material3;
		this.cantidad1 = cantidad1;
		this.cantidad2 = cantidad2;
		this.cantidad3 = cantidad3;
		this.precioT = precioT;
		this.precioM1 = precioM1;
		this.precioM2 = precioM2;
		this.precioM3 = precioM3;
	}
	public Long getPrecioT() {
		return precioT;
	}
	public void setPrecioT(Long precioT) {
		this.precioT = precioT;
	}
	public Long getPrecioM1() {
		return precioM1;
	}
	public void setPrecioM1(Long precioM1) {
		this.precioM1 = precioM1;
	}
	public Long getPrecioM2() {
		return precioM2;
	}
	public void setPrecioM2(Long precioM2) {
		this.precioM2 = precioM2;
	}
	public Long getPrecioM3() {
		return precioM3;
	}
	public void setPrecioM3(Long precioM3) {
		this.precioM3 = precioM3;
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
	public String getMaterial1() {
		return Material1;
	}
	public void setMaterial1(String material1) {
		Material1 = material1;
	}
	public String getMaterial2() {
		return Material2;
	}
	public void setMaterial2(String material2) {
		Material2 = material2;
	}
	public String getMaterial3() {
		return Material3;
	}
	public void setMaterial3(String material3) {
		Material3 = material3;
	}
	public Long getCantidad1() {
		return cantidad1;
	}
	public void setCantidad1(Long cantidad1) {
		this.cantidad1 = cantidad1;
	}
	public Long getCantidad2() {
		return cantidad2;
	}
	public void setCantidad2(Long cantidad2) {
		this.cantidad2 = cantidad2;
	}
	public Long getCantidad3() {
		return cantidad3;
	}
	public void setCantidad3(Long cantidad3) {
		this.cantidad3 = cantidad3;
	}
	
	public FacturaBo() {}
	
}	