package edu.curso.java.spring.zspring.mvc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.curso.java.spring.zspring.bo.TrabajoTerminadoBo;
import edu.curso.java.spring.zspring.service.interf.TrabajoTerminadoService;

@Controller
@RequestMapping("/terminados")
public class TrabajoTerminadoController {

	private static  Logger log = LoggerFactory.getLogger(TrabajoTerminadoController.class);

	@Autowired
	private TrabajoTerminadoService trabajoTerminadoService;
	
	@GetMapping("/lista")
	public String listar(Model model) {
		List<TrabajoTerminadoBo> trabajosTerminados = trabajoTerminadoService.listarTrabajosTerminados();
		model.addAttribute("terminados", trabajosTerminados);
		log.info("mostrando terminados");
		return "/terminados/listar";
		
	}
}
