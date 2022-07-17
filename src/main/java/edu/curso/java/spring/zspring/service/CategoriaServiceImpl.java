package edu.curso.java.spring.zspring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import edu.curso.java.spring.zspring.bo.CategoriaBo;
import edu.curso.java.spring.zspring.repository.interf.CategoriaRepository;
import edu.curso.java.spring.zspring.service.interf.CategoriaService;

@Service
@Transactional
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	//@Cacheable("categorias")
	@Override
	public List<CategoriaBo> listarCategorias() {
		return categoriaRepository.listarCategorias();
	}

	@Override
	public CategoriaBo obtenerCategoria(Long id) {
		return categoriaRepository.obtenerCategoria(id);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@Override
	public void nuevaCategoria(CategoriaBo categoria) {
		categoriaRepository.nuevaCategoria(categoria);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@Override
	public void nuevaCategoria(CategoriaBo categoria, Long id) {
		categoriaRepository.editarCategoria(categoria, id);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@Override
	public void eliminarCategoria(Long id) {
		categoriaRepository.eliminarCategoria(id);
	}
	
	@Override
	public void obtenerCategorias(Model model) {
		List<CategoriaBo> categorias = this.listarCategorias();
		model.addAttribute("categorias", categorias);
	}

}
