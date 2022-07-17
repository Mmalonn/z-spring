package edu.curso.java.spring.zspring.service.interf;

import java.util.List;

import org.springframework.ui.Model;

import edu.curso.java.spring.zspring.bo.CategoriaBo;

public interface CategoriaService {

	List<CategoriaBo> listarCategorias();
	
	CategoriaBo obtenerCategoria(Long id);

	void nuevaCategoria(CategoriaBo categoria);

	void nuevaCategoria(CategoriaBo categoria, Long id);

	void eliminarCategoria(Long id);
	
	void obtenerCategorias(Model model);
}
