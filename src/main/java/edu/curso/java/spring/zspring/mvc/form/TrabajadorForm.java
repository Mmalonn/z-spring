package edu.curso.java.spring.zspring.mvc.form;

import java.util.ArrayList;
import java.util.List;

import edu.curso.java.spring.zspring.bo.TrabajoBo;

public class TrabajadorForm {

	private Long id;
	private String nombre;
	private String apellido;
	private String dni;
	private Double sueldoPorHora;
	private String telefono;
	private List<TrabajoBo> trabajos = new ArrayList<TrabajoBo>();
	
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
	public List<TrabajoBo> getTrabajos() {
		return trabajos;
	}
	public void setTrabajos(List<TrabajoBo> trabajos) {
		this.trabajos = trabajos;
	}
	
	
	
}
