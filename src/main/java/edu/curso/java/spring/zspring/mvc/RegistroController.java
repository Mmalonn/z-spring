package edu.curso.java.spring.zspring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registro")
public class RegistroController {

	@GetMapping
	public String registro(Model model) {
		return "inicio/registro";
	}
	
	//@PostMapping("/guardar")
	
}
