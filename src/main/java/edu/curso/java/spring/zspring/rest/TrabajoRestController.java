package edu.curso.java.spring.zspring.rest;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.curso.java.spring.zspring.bo.TrabajoBo;
import edu.curso.java.spring.zspring.rest.dto.TrabajoDto;
import edu.curso.java.spring.zspring.service.interf.TrabajoService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TrabajoRestController {

	private static Logger log = LoggerFactory.getLogger(TrabajoRestController.class);

	@Autowired
	private TrabajoService trabajoService;

	@GetMapping("/trabajos")
	public List<TrabajoDto> listarTrabajos() {
		List<TrabajoBo> trabajos = trabajoService.listarTrabajos();
		List<TrabajoDto> trabajosDto = new ArrayList<TrabajoDto>();
		for (TrabajoBo trabajo : trabajos) {
			trabajosDto.add(new TrabajoDto(trabajo));
		}
		log.info("mostrando trabajos");
		return trabajosDto;
	}

	@GetMapping("/trabajos/{id}")
	public ResponseEntity<TrabajoDto> obtenerTrabajo(@PathVariable Long id) {
		TrabajoBo trabajo = trabajoService.obtenerTrabajo(id);
		TrabajoDto trabajoDto = new TrabajoDto(trabajo);
		return ResponseEntity.ok(trabajoDto);
	}
	
	@PostMapping("/trabajos")
	public ResponseEntity<TrabajoDto> nuevoTrabajo(@RequestBody TrabajoDto trabajoDto){
		TrabajoBo trabajo = new TrabajoBo();
		trabajo.setNombre(trabajoDto.getNombre());
		trabajo.setTarea(trabajoDto.getTarea());
		trabajo.setFecha(trabajoDto.getFecha());
		trabajo.setUbicacionBo(trabajoDto.getUbicacionBo());
		trabajo.setHorasEstimadas(trabajoDto.getHorasEstimadas());
		trabajo.setTrabajadorBo(trabajoDto.getTrabajadorBo());
		trabajo.setMateriales(trabajoDto.getMateriales());
		trabajo.setPrecioFinal(trabajoDto.getPrecioFinal());
		trabajoService.agregarTrabajador(trabajo);
		return ResponseEntity.status(HttpStatus.CREATED).body(trabajoDto);
	}
	
	@DeleteMapping("/trabajos/borrar/{id}")
	public ResponseEntity<?> eliminarTrabajo(@PathVariable Long id){
		trabajoService.eliminarTrabajo(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
	@PutMapping("/trabajos/{id}")
	public ResponseEntity<TrabajoDto> editarTrabajo(@RequestBody TrabajoDto trabajoDto, @PathVariable Long id){
		TrabajoBo trabajo = new TrabajoBo();
		trabajo.setNombre(trabajoDto.getNombre());
		trabajo.setTarea(trabajoDto.getTarea());
		trabajo.setFecha(trabajoDto.getFecha());
		trabajo.setUbicacionBo(trabajoDto.getUbicacionBo());
		trabajo.setHorasEstimadas(trabajoDto.getHorasEstimadas());
		trabajo.setTrabajadorBo(trabajoDto.getTrabajadorBo());
		trabajo.setMateriales(trabajoDto.getMateriales());
		trabajo.setPrecioFinal(trabajoDto.getPrecioFinal());
		trabajoService.editarTrabajo(trabajo, id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(trabajoDto);
	}
}
