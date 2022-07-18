package edu.curso.java.spring.zspring.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.curso.java.spring.zspring.bo.TrabajoTerminadoBo;
import edu.curso.java.spring.zspring.service.interf.ProveedorService;
import edu.curso.java.spring.zspring.service.interf.TrabajoTerminadoService;

@Controller
@RequestMapping("/terminados")
public class TrabajoTerminadoController {

	private static  Logger log = LoggerFactory.getLogger(TrabajoTerminadoController.class);

	@Autowired
	private TrabajoTerminadoService trabajoTerminadoService;
	@Autowired
	private ProveedorService proveedorService;
	
	@GetMapping("/lista")
	public String listar(Model model) {
		proveedorService.cargarProveedores(model);
		trabajoTerminadoService.cargarTerminados(model);
		log.info("mostrando terminados");
		return "/terminados/listar";	
	}

	
	//los trabajos terminados solo se pueden ver
	@GetMapping("/{id}")
	public String verTerminado(Model model, @PathVariable Long id) {
		TrabajoTerminadoBo terminado = trabajoTerminadoService.obtenerTerminado(id);
		proveedorService.cargarProveedores(model);
		model.addAttribute("terminado", terminado);
		return "/terminados/terminado";
	}
}
