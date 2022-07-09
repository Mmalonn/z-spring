package edu.curso.java.spring.zspring.service.interf;

import java.util.List;

import edu.curso.java.spring.zspring.bo.TrabajoBo;

public interface TrabajoService {
	
	List<TrabajoBo> listarTrabajos();
	
	TrabajoBo obtenerTrabajo(Long id);

}
