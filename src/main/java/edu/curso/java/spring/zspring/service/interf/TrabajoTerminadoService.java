package edu.curso.java.spring.zspring.service.interf;

import java.util.List;

import org.springframework.ui.Model;

import edu.curso.java.spring.zspring.bo.TrabajoBo;
import edu.curso.java.spring.zspring.bo.TrabajoTerminadoBo;

public interface TrabajoTerminadoService {

	List<TrabajoTerminadoBo> listarTrabajosTerminados();
	
	TrabajoTerminadoBo obtenerTerminado(Long id);

	void nuevoTerminado(TrabajoBo trabajo);

	void nuevoTerminado(TrabajoTerminadoBo trabajo);

	void cargarTerminados(Model model);
}
