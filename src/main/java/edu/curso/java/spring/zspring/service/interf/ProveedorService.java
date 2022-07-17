package edu.curso.java.spring.zspring.service.interf;

import java.util.List;

import org.springframework.ui.Model;

import edu.curso.java.spring.zspring.bo.ProveedorBo;


public interface ProveedorService {

	List<ProveedorBo> listarProveedores();

	ProveedorBo obtenerProveedor(Long id);
	
	ProveedorBo nuevoProveedor(ProveedorBo proveedorBo);

	void borrarProveedor(Long id);

	void editarProveedor(ProveedorBo proveedorBo, Long id);
	
	void cargarProveedores(Model model);
}
