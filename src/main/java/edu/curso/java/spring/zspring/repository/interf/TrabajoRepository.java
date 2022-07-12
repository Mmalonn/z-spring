package edu.curso.java.spring.zspring.repository.interf;

import java.util.List;

import edu.curso.java.spring.zspring.bo.TrabajoBo;

public interface TrabajoRepository {

	public List<TrabajoBo> listarTrabajos();
	
	public TrabajoBo obtenerTrabajo(Long id);

	public void agregarTrabajo(TrabajoBo trabajo);

	public void borrarTrabajo(Long id);

	public void editarTrabajo(TrabajoBo trabajoBo, Long id);
}
