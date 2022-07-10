package edu.curso.java.spring.zspring.repository.interf;

import java.util.List;

import edu.curso.java.spring.zspring.bo.CategoriaBo;
import edu.curso.java.spring.zspring.bo.MaterialBo;
import edu.curso.java.spring.zspring.bo.ProveedorBo;

public interface CategoriaRepository {

	public List<CategoriaBo> listarCategorias();
	
	public CategoriaBo obtenerCategoria(Long id);

	public void nuevaCategoria(CategoriaBo categoria);

	public void editarCategoria(CategoriaBo categoria, Long id);

	public List<MaterialBo> obtenerMaterialesCategoria(CategoriaBo categoria);

}
