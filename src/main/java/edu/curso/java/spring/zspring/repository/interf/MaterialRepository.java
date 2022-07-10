package edu.curso.java.spring.zspring.repository.interf;

import java.util.List;

import edu.curso.java.spring.zspring.bo.MaterialBo;

public interface MaterialRepository {

	public List<MaterialBo> listarMateriales();

	public MaterialBo obtenerMaterial(Long id);

	public void nuevoMaterial(MaterialBo material);

	public void eliminarMaterial(Long id);

	public void editarMaterial(MaterialBo material, Long id);
}
