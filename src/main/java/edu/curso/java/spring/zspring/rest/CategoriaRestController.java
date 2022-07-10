package edu.curso.java.spring.zspring.rest;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.curso.java.spring.zspring.bo.CategoriaBo;
import edu.curso.java.spring.zspring.rest.dto.CategoriaDto;
import edu.curso.java.spring.zspring.service.interf.CategoriaService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CategoriaRestController {
	
	private static Logger log = LoggerFactory.getLogger(CategoriaRestController.class);
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/materiales/categorias")
	public List<CategoriaDto> listarCategorias(){
		List<CategoriaBo> categorias = categoriaService.listarCategorias();
		List<CategoriaDto> categoriasDto = new ArrayList<CategoriaDto>();
		for(CategoriaBo categoria: categorias) {
			categoriasDto.add(new CategoriaDto(categoria));
		}
		log.info("mostrando categorias");
		return categoriasDto ;
	}
	
	@GetMapping("/materiales/categorias/{id}")
	public CategoriaDto obtenerCategoria(@PathVariable Long id) {
		CategoriaBo categoria = categoriaService.obtenerCategoria(id);
		CategoriaDto cateogoriaDto = new CategoriaDto(categoria);
		return cateogoriaDto;
	}
	
	@PostMapping("/materiales/categorias")
	public ResponseEntity<CategoriaDto> nuevaCategoria(@RequestBody CategoriaDto categoriaDto){
		CategoriaBo categoria = new CategoriaBo();
		categoria.setNombre(categoriaDto.getNombre());
		categoria.setMateriales(categoriaDto.getMateriales());
		categoriaService.nuevaCategoria(categoria);
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaDto);
	}
	
	@PutMapping("/materiales/categorias/{id}")
	public ResponseEntity<CategoriaDto> editarCategoria(@RequestBody CategoriaDto categoriaDto, @PathVariable Long id){
		CategoriaBo categoria = new CategoriaBo();
		categoria.setNombre(categoriaDto.getNombre());
		categoria.setMateriales(categoriaDto.getMateriales());
		categoriaService.nuevaCategoria(categoria, id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(categoriaDto);

	}
}
