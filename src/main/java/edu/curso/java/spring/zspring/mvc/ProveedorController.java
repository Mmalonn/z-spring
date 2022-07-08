package edu.curso.java.spring.zspring.mvc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.curso.java.spring.zspring.bo.ProveedorBo;
import edu.curso.java.spring.zspring.service.interf.ProveedorService;

@Controller
@RequestMapping("/proveedores")
public class ProveedorController {
	
	private static  Logger log = LoggerFactory.getLogger(ProveedorController.class);

	@Autowired
	private ProveedorService proveedorService;
	
	@GetMapping
	public String listar(Model model) {
		List<ProveedorBo> proveedores = proveedorService.listarProveedores();
		model.addAttribute("proveedores", proveedores);
		log.info("mostrando proveedores");
		return "/proveedores/listar";
	}
	
	@GetMapping("/{id}")
	public String verProveedor(Model model, @PathVariable Long id) {
		ProveedorBo proveedor= proveedorService.obtenerProveedor(id);
		List<ProveedorBo> proveedores = proveedorService.listarProveedores();
		model.addAttribute("proveedores", proveedores);
		model.addAttribute("proveedor", proveedor);
		return "/proveedores/proveedor";
	}
}
