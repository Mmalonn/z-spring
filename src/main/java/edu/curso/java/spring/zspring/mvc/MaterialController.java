package edu.curso.java.spring.zspring.mvc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.curso.java.spring.zspring.bo.MaterialBo;
import edu.curso.java.spring.zspring.service.interf.MaterialService;

@Controller
@RequestMapping("/materiales")
public class MaterialController {

	private static  Logger log = LoggerFactory.getLogger(TrabajoController.class);

	@Autowired
	private MaterialService materialService;
	
	@GetMapping("/lista")
	public String listar(Model model) {
		List<MaterialBo> materiales = materialService.listarMateriales();
		model.addAttribute("materiales", materiales);
		log.info("mostrando materiales");
		return "/materiales/listar";
	}
}
