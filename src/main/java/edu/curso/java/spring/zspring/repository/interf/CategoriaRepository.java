package edu.curso.java.spring.zspring.repository.interf;

import java.util.List;

import edu.curso.java.spring.zspring.bo.CategoriaBo;

public interface CategoriaRepository {

	public List<CategoriaBo> listarCategorias();
	
	public CategoriaBo obtenerCategoria(Long id);

}
