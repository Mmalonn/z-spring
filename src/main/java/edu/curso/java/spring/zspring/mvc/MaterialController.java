package edu.curso.java.spring.zspring.mvc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.curso.java.spring.zspring.bo.CategoriaBo;
import edu.curso.java.spring.zspring.bo.MaterialBo;
import edu.curso.java.spring.zspring.bo.ProveedorBo;
import edu.curso.java.spring.zspring.mvc.form.MaterialForm;
import edu.curso.java.spring.zspring.service.interf.CategoriaService;
import edu.curso.java.spring.zspring.service.interf.MaterialService;
import edu.curso.java.spring.zspring.service.interf.ProveedorService;

@Controller
@RequestMapping("/materiales")
public class MaterialController {

	private static  Logger log = LoggerFactory.getLogger(MaterialController.class);

	@Autowired
	private MaterialService materialService;
	@Autowired
	private ProveedorService proveedorService;
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/lista")
	public String listar(Model model) {
		List<MaterialBo> materiales = materialService.listarMateriales();
		List<ProveedorBo> proveedores = proveedorService.listarProveedores();
		model.addAttribute("proveedores", proveedores);
		model.addAttribute("materiales", materiales);
		log.info("mostrando materiales");
		return "/materiales/listar";
	}
	
	@GetMapping("/nuevo")
	public String nuevoMaterial(Model model) {
		List<ProveedorBo> proveedores = proveedorService.listarProveedores();
		model.addAttribute("proveedores", proveedores);
		List<CategoriaBo> categorias = categoriaService.listarCategorias();
		model.addAttribute("categorias", categorias);
		model.addAttribute("materialForm", new MaterialForm());
		return "/materiales/form";
	}
	
	@PostMapping("/guardar")
	public String guardar(@ModelAttribute(name="materialForm") MaterialForm materialForm, Model model) {
		MaterialBo material = null;
		Long idMaterial = materialForm.getId();
		if(idMaterial == null) {
			material = new MaterialBo();
		} else {
			material = materialService.obtenerMaterial(idMaterial);
		}
		material.setNombre(materialForm.getNombre());
		material.setCantidad(materialForm.getCantidad());
		material.setPrecio(materialForm.getPrecio());
		if(idMaterial == null) {
			materialService.nuevoMaterial(material, materialForm.getIdCategoria(), materialForm.getIdProveedor());
		} else {
			materialService.editarMaterial(material, idMaterial);
		}
		return "redirect:/materiales/lista";
	}
	
}
