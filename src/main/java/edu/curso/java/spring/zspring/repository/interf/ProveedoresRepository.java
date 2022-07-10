package edu.curso.java.spring.zspring.repository.interf;

import java.util.List;

import edu.curso.java.spring.zspring.bo.MaterialBo;
import edu.curso.java.spring.zspring.bo.ProveedorBo;

public interface ProveedoresRepository {

	public List<ProveedorBo> listarProveedores();

	public ProveedorBo obtenerProveedor(Long id);
	
	public ProveedorBo nuevoProveedor(ProveedorBo proveedorBo);

	public void borrarProveedor(Long id);

	public void editarProveedor(ProveedorBo proveedorBo, Long id);
	
	public List<MaterialBo> obtenerMaterialesProveedor(ProveedorBo proveedorBo);
}
