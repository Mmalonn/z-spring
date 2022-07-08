package edu.curso.java.spring.zspring.repository.interf;

import java.util.List;

import edu.curso.java.spring.zspring.bo.ProveedorBo;

public interface ProveedoresRepository {

	public List<ProveedorBo> listarProveedores();

	public ProveedorBo obtenerProveedor(Long id);
}
