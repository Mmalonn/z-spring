package edu.curso.java.spring.zspring.service.interf;

import java.util.List;

import edu.curso.java.spring.zspring.bo.MaterialBo;


public interface MaterialService {

	List<MaterialBo> listarMateriales();

	MaterialBo obtenerMaterial(Long id);

	void nuevoMaterial(MaterialBo material);

	void eliminarMaterial(Long id);

	void editarMaterial(MaterialBo material, Long id);
}
