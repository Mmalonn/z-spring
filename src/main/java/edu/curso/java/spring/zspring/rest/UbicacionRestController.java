package edu.curso.java.spring.zspring.rest;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

}
