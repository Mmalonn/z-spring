package edu.curso.java.spring.zspring.mvc;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.curso.java.spring.zspring.bo.TrabajoBo;
import edu.curso.java.spring.zspring.service.interf.TrabajoService;


@Controller
@RequestMapping("/trabajos")
public class TrabajoController {

	private static  Logger log = LoggerFactory.getLogger(TrabajoController.class);

	@Autowired
	private TrabajoService trabajoservice;
	
	@GetMapping("/lista")
	public String listar(Model model) {
		List<TrabajoBo> trabajos = trabajoservice.listarTrabajos();
		model.addAttribute("trabajos", trabajos);
		log.info("mostrando trabajos");
		return "/trabajos/listar";
	}
}
