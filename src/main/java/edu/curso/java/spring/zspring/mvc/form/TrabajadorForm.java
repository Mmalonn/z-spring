package edu.curso.java.spring.zspring.mvc.form;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.web.multipart.MultipartFile;

import edu.curso.java.spring.zspring.bo.TrabajoBo;

public class TrabajadorForm {

	private Long id;
	@NotBlank
	private String nombre;
	@NotBlank
	private String apellido;
	@NotBlank
	private String dni;
	@NotNull
	@Positive
	private Double sueldoPorHora;
	private String telefono;
	private List<TrabajoBo> trabajos = new ArrayList<TrabajoBo>();
	private MultipartFile foto;
	
	
	public MultipartFile getFoto() {
		return foto;
	}
	public void setFoto(MultipartFile foto) {
		this.foto = foto;
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
	public List<TrabajoBo> getTrabajos() {
		return trabajos;
	}
	public void setTrabajos(List<TrabajoBo> trabajos) {
		this.trabajos = trabajos;
	}
	
	
	
}
