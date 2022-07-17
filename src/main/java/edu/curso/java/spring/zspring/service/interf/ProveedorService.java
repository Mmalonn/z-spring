package edu.curso.java.spring.zspring.service.interf;

import java.util.List;

import org.springframework.ui.Model;

import edu.curso.java.spring.zspring.bo.ProveedorBo;
import edu.curso.java.spring.zspring.mvc.form.ProveedorForm;


public interface ProveedorService {

	List<ProveedorBo> listarProveedores();

	ProveedorBo obtenerProveedor(Long id);
	
	ProveedorBo nuevoProveedor(ProveedorForm proveedorForm);

	void borrarProveedor(Long id);

	void editarProveedor(ProveedorBo proveedorBo, Long id);
	
	void cargarProveedores(Model model);

	void nuevoProveedor(ProveedorBo proveedor);
}
