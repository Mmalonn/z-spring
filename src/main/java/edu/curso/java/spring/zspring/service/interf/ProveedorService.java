package edu.curso.java.spring.zspring.service.interf;

import java.util.List;

import edu.curso.java.spring.zspring.bo.ProveedorBo;


public interface ProveedorService {

	List<ProveedorBo> listarProveedores();

	ProveedorBo obtenerProveedor(Long id);
}
