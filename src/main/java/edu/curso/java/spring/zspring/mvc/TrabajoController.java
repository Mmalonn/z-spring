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

import edu.curso.java.spring.zspring.bo.MaterialBo;
import edu.curso.java.spring.zspring.bo.ProveedorBo;
import edu.curso.java.spring.zspring.bo.TrabajadorBo;
import edu.curso.java.spring.zspring.bo.TrabajoBo;
import edu.curso.java.spring.zspring.mvc.form.TrabajoForm;
import edu.curso.java.spring.zspring.service.interf.MaterialService;
import edu.curso.java.spring.zspring.service.interf.ProveedorService;
import edu.curso.java.spring.zspring.service.interf.TrabajadorService;
import edu.curso.java.spring.zspring.service.interf.TrabajoService;


@Controller
@RequestMapping("/trabajos")
public class TrabajoController {

	private static  Logger log = LoggerFactory.getLogger(TrabajoController.class);

	@Autowired
	private TrabajoService trabajoservice;
	@Autowired
	private ProveedorService proveedorService;
	@Autowired
	private TrabajadorService trabajadorService;
	@Autowired
	private MaterialService materialService;
	
	@GetMapping("/lista")
	public String listar(Model model) {
		List<TrabajoBo> trabajos = trabajoservice.listarTrabajos();
		List<ProveedorBo> proveedores = proveedorService.listarProveedores();
		model.addAttribute("proveedores", proveedores);
		model.addAttribute("trabajos", trabajos);
		
		log.info("mostrando trabajos");
		return "/trabajos/listar";
	}
	
	@GetMapping("/{id}")
	public String verTrabajo(Model model, @PathVariable Long id) {
		TrabajoBo trabajo = trabajoservice.obtenerTrabajo(id);
		List<ProveedorBo> proveedores = proveedorService.listarProveedores();
		model.addAttribute("proveedores", proveedores);
		model.addAttribute("trabajo", trabajo);
		return "/trabajos/trabajo";
	}
	
	@GetMapping("/nuevo")
	public String nuevoTrabajo(Model model) {
		List<ProveedorBo> proveedores = proveedorService.listarProveedores();
		model.addAttribute("proveedores", proveedores);
		List<TrabajadorBo> trabajadores = trabajadorService.listarTrabajadores();
		model.addAttribute("trabajadores", trabajadores); 
		List<MaterialBo> materiales = materialService.listarMateriales();
		model.addAttribute("materiales", materiales);
		model.addAttribute("trabajoForm", new TrabajoForm());
		return "/trabajos/form";
		
	}
}
