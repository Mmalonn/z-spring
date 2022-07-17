package edu.curso.java.spring.zspring.service.interf;

import java.util.List;

import org.springframework.ui.Model;

import edu.curso.java.spring.zspring.bo.TrabajoBo;

public interface TrabajoService {
	
	List<TrabajoBo> listarTrabajos();
	
	TrabajoBo obtenerTrabajo(Long id);

	void agregarTrabajo(TrabajoBo trabajo, Long id);

	void eliminarTrabajo(Long id);

	void editarTrabajo(TrabajoBo trabajo, Long id2);

	void enviarCorreoFactura(String emailCliente, String titulo, String mensaje);

	void cargarTrabajos(Model model);
}
