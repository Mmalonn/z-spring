package edu.curso.java.spring.zspring.service.interf;

import java.util.List;

import edu.curso.java.spring.zspring.bo.CategoriaBo;

public interface CategoriaService {

	List<CategoriaBo> listarCategorias();
	
	CategoriaBo obtenerCategoria(Long id);

	void nuevaCategoria(CategoriaBo categoria);

	void nuevaCategoria(CategoriaBo categoria, Long id);

	void eliminarCategoria(Long id);
}
