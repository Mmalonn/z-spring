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

import edu.curso.java.spring.zspring.bo.TrabajoTerminadoBo;
import edu.curso.java.spring.zspring.rest.dto.TrabajoTerminadoDto;
import edu.curso.java.spring.zspring.service.interf.TrabajoTerminadoService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TrabajoTerminadoRestController {
	
	private static Logger log = LoggerFactory.getLogger(TrabajoTerminadoRestController.class);

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
	
	@GetMapping("/terminados/{id}")
	public ResponseEntity<TrabajoTerminadoDto> obtenerTerminado(@PathVariable Long id){
		TrabajoTerminadoBo trabajo = trabajoTerminadoService.obtenerTerminado(id);
		TrabajoTerminadoDto trabajoDto = new TrabajoTerminadoDto(trabajo);
		return ResponseEntity.ok(trabajoDto);
	}
	
	@PostMapping("/terminados")
	public ResponseEntity<TrabajoTerminadoDto> nuevoTerminado(@RequestBody TrabajoTerminadoDto trabajoTerminadoDto){
		TrabajoTerminadoBo trabajo = new TrabajoTerminadoBo();
		trabajo.setNombre(trabajoTerminadoDto.getNombre());
		trabajo.setTarea(trabajoTerminadoDto.getTarea());
		trabajo.setFecha(trabajoTerminadoDto.getFecha());
		trabajo.setUbicacionBo(trabajoTerminadoDto.getUbicacionBo());
		trabajo.setHorasEstimadas(trabajoTerminadoDto.getHorasEstimadas());
		trabajo.setTrabajadorBo(trabajoTerminadoDto.getTrabajadorBo());
		trabajo.setPrecioFinal(trabajoTerminadoDto.getPrecioFinal());
		trabajo.setFechaFinalizacion(trabajoTerminadoDto.getFechaFinalizacion());
		trabajoTerminadoService.nuevoTerminado(trabajo);
		return ResponseEntity.status(HttpStatus.CREATED).body(trabajoTerminadoDto);
	}
}
