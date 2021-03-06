package edu.curso.java.spring.zspring.repository.interf;

import java.util.List;

import edu.curso.java.spring.zspring.bo.TrabajoTerminadoBo;

public interface TrabajoTerminadoRepository {

	List<TrabajoTerminadoBo> listarTrabajosTerminados();

	public TrabajoTerminadoBo obtenerTerminado(Long id);

	void nuevoTerminado(TrabajoTerminadoBo trabajo);
}
