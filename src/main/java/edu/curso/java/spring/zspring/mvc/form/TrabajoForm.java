package edu.curso.java.spring.zspring.mvc.form;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import edu.curso.java.spring.zspring.bo.MaterialBo;
import edu.curso.java.spring.zspring.bo.TrabajadorBo;
import edu.curso.java.spring.zspring.bo.UbicacionBo;

public class TrabajoForm {

	private Long id;
	@NotBlank
	private String nombre;
	private Date fecha;
	@NotBlank
	private String tarea;
	@NotNull
	@Positive
	private Double horasEstimadas;
	@NotNull
	@Positive
	private Double precioFinal;
	private TrabajadorBo trabajadorBo;
	private MaterialBo material;
	@NotBlank
	private String ubicacionBo;
	private List<MaterialBo> materiales = new ArrayList<MaterialBo>();
	private Long idTrabajador;
	private Long idMaterial;
	private List<Long> idMateriales = new ArrayList<Long>();
	private List<Long> cantidades = new ArrayList<Long>();
	private Long idMaterial1;
	private Long idMaterial2;
	private Long idMaterial3;
	private Long cantidad1;
	private Long cantidad2;
	private Long cantidad3;
	private Long precioT;
	private Long precioM1;
	private Long precioM2;
	private Long precioM3;
	
	
	
	
	
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
	public Long getIdMaterial1() {
		return idMaterial1;
	}
	public void setIdMaterial1(Long idMaterial1) {
		this.idMaterial1 = idMaterial1;
	}
	public Long getIdMaterial2() {
		return idMaterial2;
	}
	public void setIdMaterial2(Long idMaterial2) {
		this.idMaterial2 = idMaterial2;
	}
	public Long getIdMaterial3() {
		return idMaterial3;
	}
	public void setIdMaterial3(Long idMaterial3) {
		this.idMaterial3 = idMaterial3;
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
	public List<Long> getCantidades() {
		return cantidades;
	}
	public void setCantidades(List<Long> cantidades) {
		this.cantidades = cantidades;
	}
	public List<Long> getIdMateriales() {
		return idMateriales;
	}
	public void setIdMateriales(List<Long> idMateriales) {
		this.idMateriales = idMateriales;
	}
	public Long getIdMaterial() {
		return idMaterial;
	}
	public void setIdMaterial(Long idMaterial) {
		this.idMaterial = idMaterial;
	}
	public Long getIdTrabajador() {
		return idTrabajador;
	}
	public void setIdTrabajador(Long idTrabajador) {
		this.idTrabajador = idTrabajador;
	}
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
	public String getUbicacionBo() {
		return ubicacionBo;
	}
	public void setUbicacionBo(String ubicacionBo) {
		this.ubicacionBo = ubicacionBo;
	}
	
	
	
}
