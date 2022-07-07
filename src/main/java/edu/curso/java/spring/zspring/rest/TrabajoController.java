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

import edu.curso.java.spring.zspring.bo.TrabajoBo;
import edu.curso.java.spring.zspring.rest.dto.TrabajoDto;
import edu.curso.java.spring.zspring.service.interf.TrabajoService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TrabajoController {

	private static Logger log = LoggerFactory.getLogger(TrabajoController.class);
	
	@Autowired
	private TrabajoService trabajoservice;
	
	@GetMapping("/trabajos")
	public List<TrabajoDto> listarTrabajos(){
		List<TrabajoBo> trabajos = trabajoservice.listarTrabajos();
		List<TrabajoDto> trabajosDto = new ArrayList<TrabajoDto>();
		for(TrabajoBo trabajo: trabajos) {
			trabajosDto.add(new TrabajoDto(trabajo));
		}
		return trabajosDto;
	}
}
