package edu.curso.java.spring.zspring.mvc;


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

import edu.curso.java.spring.zspring.bo.ProveedorBo;
import edu.curso.java.spring.zspring.mvc.form.ProveedorForm;
import edu.curso.java.spring.zspring.service.interf.ProveedorService;

@Controller
@RequestMapping("/proveedores")
public class ProveedorController {
	
	private static  Logger log = LoggerFactory.getLogger(ProveedorController.class);

	@Autowired
	private ProveedorService proveedorService;
	
	@GetMapping
	public String listar(Model model) {
		proveedorService.cargarProveedores(model);
		log.info("mostrando proveedores");
		return "/proveedores/listar";
	}
	
	@GetMapping("/{id}")
	public String verProveedor(Model model, @PathVariable Long id) {
		ProveedorBo proveedor= proveedorService.obtenerProveedor(id);
		proveedorService.cargarProveedores(model);
		model.addAttribute("proveedor", proveedor);
		return "/proveedores/proveedor";
	}

	
	
	@GetMapping("/nuevo")
	public String nuevoProveedor(Model model) {
		proveedorService.cargarProveedores(model);
		model.addAttribute("proveedorForm", new ProveedorForm());
		return "/proveedores/form";
	}
	
	@PostMapping("/guardar")
		public String guardarProveedor(@Valid @ModelAttribute(name = "proveedorForm" ) ProveedorForm proveedorForm, BindingResult bindingResult, Model model){
		if(bindingResult.hasErrors()) {
			return "/proveedores/form";
		}
		proveedorService.nuevoProveedor(proveedorForm);
		return "redirect:/proveedores";
	}
	
	@GetMapping("{id}/eliminar")
	public String eliminarProveedor(Model model, @PathVariable Long id) {
		proveedorService.borrarProveedor(id);
		return "redirect:/proveedores";
	}
	

}
