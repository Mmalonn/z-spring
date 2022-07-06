package edu.curso.java.spring.zspring.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class UbicacionBo {

	@Id
	@GeneratedValue
	private Long id;
	private String calle;
	private String numero;
	@OneToOne
	private TrabajoBo trabajoBo;
	
	public TrabajoBo getTrabajoBo() {
		return trabajoBo;
	}
	public void setTrabajoBo(TrabajoBo trabajoBo) {
		this.trabajoBo = trabajoBo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public UbicacionBo(Long id, String calle, String numero, TrabajoBo trabajoBo) {
		super();
		this.id = id;
		this.calle = calle;
		this.numero = numero;
		this.trabajoBo = trabajoBo;
	}
	
	public UbicacionBo() {}
	
}
