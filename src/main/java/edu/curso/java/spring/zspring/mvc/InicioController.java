package edu.curso.java.spring.zspring.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.curso.java.spring.zspring.service.interf.TrabajoService;

@Controller
@RequestMapping("/")
public class InicioController {

	private static  Logger log = LoggerFactory.getLogger(InicioController.class);

	@Autowired
	private TrabajoService trabajoService;
	
	@GetMapping
	public String irAInicio(Model model) {
		return "/inicio/index";
	}
}
