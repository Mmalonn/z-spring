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

import edu.curso.java.spring.zspring.bo.TrabajoTerminadoBo;
import edu.curso.java.spring.zspring.rest.dto.TrabajoTerminadoDto;
import edu.curso.java.spring.zspring.service.interf.TrabajoTerminadoService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TrabajoTerminadoRestController {
	
	private static Logger log = LoggerFactory.getLogger(TrabajoRestController.class);

	@Autowired
	private TrabajoTerminadoService trabajoTerminadoService;

	@GetMapping("/terminados")
	public List<TrabajoTerminadoDto> listarTrabajosTerminados(){
		List<TrabajoTerminadoBo> trabajosTerminados = trabajoTerminadoService.listarTrabajosTerminados();
		List<TrabajoTerminadoDto> trabajosTerminadosDto= new ArrayList<TrabajoTerminadoDto>();
		for(TrabajoTerminadoBo tTerminado: trabajosTerminados) {
			trabajosTerminadosDto.add(new TrabajoTerminadoDto(tTerminado));
		}
		log.info("mostrando trabajos terminados");
		return trabajosTerminadosDto ;
	}
}
