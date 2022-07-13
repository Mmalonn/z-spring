package edu.curso.java.spring.zspring.bo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class TrabajadorBo {

	@Id
	@GeneratedValue
	private Long id;
	@NotNull
	private String nombre;
	@NotNull
	private String apellido;
	@NotNull
	private String dni;
	@NotNull
	private Double sueldoPorHora;
	@NotNull
	private String telefono;
	@OneToMany
	private List<TrabajoBo> trabajos = new ArrayList <TrabajoBo>();
	
	
	public List<TrabajoBo> getTrabajos() {
		return trabajos;
	}
	public void setTrabajos(List<TrabajoBo> trabajos) {
		this.trabajos = trabajos;
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Double getSueldoPorHora() {
		return sueldoPorHora;
	}
	public void setSueldoPorHora(Double sueldoPorHora) {
		this.sueldoPorHora = sueldoPorHora;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public TrabajadorBo(Long id, String nombre, String apellido, String dni, Double sueldoPorHora, String telefono,
			List<TrabajoBo> trabajos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.sueldoPorHora = sueldoPorHora;
		this.telefono = telefono;
		this.trabajos = trabajos;
	}
	
	public TrabajadorBo() {}
		
}
