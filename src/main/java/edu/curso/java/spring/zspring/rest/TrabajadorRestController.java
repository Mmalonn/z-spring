package edu.curso.java.spring.zspring.rest;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.curso.java.spring.zspring.rest.dto.TrabajadorDto;
import edu.curso.java.spring.zspring.bo.TrabajadorBo;
import edu.curso.java.spring.zspring.service.interf.TrabajadorService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TrabajadorRestController {

	private static Logger log = LoggerFactory.getLogger(TrabajadorRestController.class);

	@Autowired
	private TrabajadorService trabajadorService;
	
	@GetMapping("/trabajadores")
	public List<TrabajadorDto> listarTrabajadores(){
		List<TrabajadorBo> trabajadores = trabajadorService.listarTrabajadores();
		List<TrabajadorDto> trabajadoresDto = new ArrayList<TrabajadorDto>();
		for(TrabajadorBo trabajador: trabajadores) {
			trabajadoresDto.add(new TrabajadorDto(trabajador));
		}
		log.info("mostrando trabajadores");
		return trabajadoresDto ;
	}
}
