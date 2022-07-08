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
import edu.curso.java.spring.zspring.bo.TrabajadorBo;
import edu.curso.java.spring.zspring.service.interf.ProveedorService;
import edu.curso.java.spring.zspring.service.interf.TrabajadorService;

@Controller
@RequestMapping("/trabajadores")
public class TrabajadorController {

	private static  Logger log = LoggerFactory.getLogger(TrabajadorController.class);

	@Autowired
	private TrabajadorService trabajadorService;
	@Autowired
	private ProveedorService proveedorService;
	
	@GetMapping("/lista")
	public String listar(Model model) {
		List<TrabajadorBo> trabajadores = trabajadorService.listarTrabajadores();
		List<ProveedorBo> proveedores = proveedorService.listarProveedores();
		model.addAttribute("proveedores", proveedores);
		model.addAttribute("trabajadores", trabajadores);
		log.info("mostrando trabajadores");
		return "/trabajadores/listar";
	}
	
	@GetMapping("/{id}")
	public String verTrabajador(Model model, @PathVariable Long id) {
		TrabajadorBo trabajador = trabajadorService.obtenerTrabajador(id);
		List<ProveedorBo> proveedores = proveedorService.listarProveedores();
		model.addAttribute("proveedores", proveedores);
		model.addAttribute("trabajador", trabajador);
		return "/trabajadores/trabajador";
	}

}
