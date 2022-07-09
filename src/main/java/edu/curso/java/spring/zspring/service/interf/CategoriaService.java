package edu.curso.java.spring.zspring.service.interf;

import java.util.List;

import edu.curso.java.spring.zspring.bo.CategoriaBo;

public interface CategoriaService {

	List<CategoriaBo> listarCategorias();
	
	CategoriaBo obtenerCategoria(Long id);
}
