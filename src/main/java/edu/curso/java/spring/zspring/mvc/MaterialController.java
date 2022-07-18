package edu.curso.java.spring.zspring.mvc;


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

import edu.curso.java.spring.zspring.bo.MaterialBo;
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
		materialService.cargarMateriales(model);
		proveedorService.cargarProveedores(model);
		categoriaService.obtenerCategorias(model);	
		log.info("mostrando materiales");
		return "/materiales/listar";
	}
	
	@GetMapping("/nuevo")
	public String nuevoMaterial(Model model) {
		proveedorService.cargarProveedores(model);
		categoriaService.obtenerCategorias(model);
		model.addAttribute("materialForm", new MaterialForm());
		return "/materiales/form";
	}
	
	//este metodo permite agregar nuevo material y tambien sirve para editar la cantidad del determinado material si es que se acaba,
	//ingresando una cantidad, a partir de javascript te permite hacer un calculo del costo segun el precio y poder """"comprar""""
	@PostMapping("/guardar")
	public String guardar(@ModelAttribute(name="materialForm") MaterialForm materialForm, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			proveedorService.cargarProveedores(model);
			categoriaService.obtenerCategorias(model);
			model.addAttribute("materialForm", new MaterialForm());
			return "/materiales/form";
		}
		Long idMaterial = materialForm.getId();
		if(idMaterial == null) {
		materialService.nuevoMaterial(materialForm);
		}else {
			Long stockActual = materialService.obtenerStock(idMaterial);
			materialService.editarMaterial(materialForm, idMaterial, stockActual);
		}
		return "redirect:/materiales/lista";
	}

	//este es el metodo que te envia a la pagina donde """"comprar"""" mas del determinado material
	@GetMapping("/{id}/comprar")
	public String comprar(Model model, @PathVariable Long id) {
		MaterialBo material = materialService.obtenerMaterial(id);
		MaterialForm form = new MaterialForm();
		proveedorService.cargarProveedores(model);
		setearForm(model, material, form);
		return "/materiales/comprar";
	}

	private void setearForm(Model model, MaterialBo material, MaterialForm form) {
		form.setId(material.getId());
		form.setNombre(material.getNombre());
		form.setPrecio(material.getPrecio());
		form.setProveedorBo(material.getProveedorBo());
		model.addAttribute("materialForm", form);
	}
	
	
	
}
