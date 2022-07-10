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

import edu.curso.java.spring.zspring.bo.UbicacionBo;
import edu.curso.java.spring.zspring.rest.dto.UbicacionDto;
import edu.curso.java.spring.zspring.service.interf.UbicacionService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UbicacionRestController {

	private static Logger log = LoggerFactory.getLogger(UbicacionRestController.class);

	@Autowired
	private UbicacionService ubicacionService;

	@GetMapping("/ubicaciones")
	public List<UbicacionDto> listarUbicaciones() {
		List<UbicacionBo> ubicaciones = ubicacionService.listarUbicaciones();
		List<UbicacionDto> ubicacionesDto = new ArrayList<UbicacionDto>();
		for (UbicacionBo ubicacion : ubicaciones) {
			ubicacionesDto.add(new UbicacionDto(ubicacion));
		}
		log.info("mostrando ubicaciones");
		return ubicacionesDto;

	}
	
	@GetMapping("/ubicaciones/{id}")
	public ResponseEntity<UbicacionDto> obtenerUbicacion(@PathVariable Long id){
		UbicacionBo ubicacion = ubicacionService.obtenerUbicacion(id);
		UbicacionDto ubicacionDto = new UbicacionDto(ubicacion);
		return ResponseEntity.ok(ubicacionDto);
	}
	
	@PostMapping("/ubicaciones")
	public ResponseEntity<UbicacionDto> nuevaUbicacion(@RequestBody UbicacionDto ubicacionDto){
		UbicacionBo ubicacion = new UbicacionBo();
		ubicacion.setCalle(ubicacionDto.getCalle());
		ubicacion.setNumero(ubicacionDto.getNumero());
		ubicacionService.nuevaUbicacion(ubicacion);
		return ResponseEntity.status(HttpStatus.CREATED).body(ubicacionDto);
	}
	
	@DeleteMapping("/ubicaciones/borrar/{id}")
	public ResponseEntity<?> eliminarUbicacion(@PathVariable Long id){
		ubicacionService.borrarUbicacion(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
	@PutMapping("/ubicaciones/{id}")
	public ResponseEntity<UbicacionDto> editarUbicacion(@RequestBody UbicacionDto ubicacionDto, @PathVariable Long id){
		UbicacionBo ubicacion = new UbicacionBo();
		ubicacion.setCalle(ubicacionDto.getCalle());
		ubicacion.setNumero(ubicacionDto.getNumero());
		ubicacionService.editarUbicacion(ubicacion, id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(ubicacionDto);
	}
	

}
