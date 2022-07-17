package edu.curso.java.spring.zspring.mvc;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.curso.java.spring.zspring.bo.CategoriaBo;
import edu.curso.java.spring.zspring.bo.ProveedorBo;
import edu.curso.java.spring.zspring.mvc.form.CategoriaForm;
import edu.curso.java.spring.zspring.service.interf.CategoriaService;
import edu.curso.java.spring.zspring.service.interf.MaterialService;
import edu.curso.java.spring.zspring.service.interf.ProveedorService;

@Controller
@RequestMapping("/materiales/categorias")
public class CategoriaController {
	
	private static  Logger log = LoggerFactory.getLogger(CategoriaController.class);


	@Autowired
	private ProveedorService proveedorService;
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public String listar(Model model) {
		List<ProveedorBo> proveedores = proveedorService.listarProveedores();
		model.addAttribute("proveedores", proveedores);
		List<CategoriaBo> categorias = categoriaService.listarCategorias();
		model.addAttribute("categorias", categorias);
		log.info("mostrando categorias");
		return "/materiales/categorias";
	}
	
	@GetMapping("/nuevo")
	public String nuevaCategoria(Model model) {
		List<ProveedorBo> proveedores = proveedorService.listarProveedores();
		model.addAttribute("proveedores", proveedores);
		model.addAttribute("categoriaForm", new CategoriaForm());
		return "/materiales/categoriasform";
	}
	
	@PostMapping("/guardar")
	public String guardarCategoria(@Valid @ModelAttribute(name = "categoriaForm" ) CategoriaForm categoriaForm, BindingResult bindingResult, Model model){
		if(bindingResult.hasErrors()) {
			return "/materiales/categoriasform";
		}
		CategoriaBo categoria = new CategoriaBo();
		categoria.setNombre(categoriaForm.getNombre());
		categoriaService.nuevaCategoria(categoria);	
		return "redirect:/materiales/categorias";
	}
	
	@GetMapping("/{id}/eliminar")
		public String eliminarCategoria(Model model, @PathVariable Long id) {
		categoriaService.eliminarCategoria(id);
		return "redirect:/materiales/categorias";
	}	
}
