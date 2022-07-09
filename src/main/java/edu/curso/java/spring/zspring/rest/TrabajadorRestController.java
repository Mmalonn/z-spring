package edu.curso.java.spring.zspring.rest;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/trabajadores/{id}")
	public TrabajadorDto buscarTrabajador(@PathVariable Long id) {
		TrabajadorBo trabajador = trabajadorService.obtenerTrabajador(id);
		TrabajadorDto trabajadorDto = new TrabajadorDto(trabajador);
		return trabajadorDto;
	}
	
	@PostMapping("/trabajadores")
	public ResponseEntity<TrabajadorDto> nuevoTrabajador(@RequestBody TrabajadorDto trabajadorDto){
	TrabajadorBo trabajador = new TrabajadorBo();
	trabajador.setNombre(trabajadorDto.getNombre());
	trabajador.setApellido(trabajadorDto.getApellido());
	trabajador.setDni(trabajadorDto.getDni());
	trabajador.setTelefono(trabajadorDto.getTelefono());
	trabajador.setSueldoPorHora(trabajadorDto.getSueldoPorHora());
	trabajador.setTrabajos(trabajadorDto.getTrabajos());
	trabajadorService.nuevoTrabajador(trabajador);
	return ResponseEntity.status(HttpStatus.CREATED).body(trabajadorDto);
	}
}
