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

import edu.curso.java.spring.zspring.bo.ProveedorBo;
import edu.curso.java.spring.zspring.rest.dto.ProveedorDto;
import edu.curso.java.spring.zspring.service.interf.ProveedorService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ProveedorRestController {

	private static Logger log = LoggerFactory.getLogger(ProveedorRestController.class);

	@Autowired
	private ProveedorService proveedorService;
	
	@GetMapping("/proveedores")
	public List<ProveedorDto> listarProveedores(){
		List<ProveedorBo> proveedores = proveedorService.listarProveedores();
		List<ProveedorDto> proveedoresDto = new ArrayList<ProveedorDto>();
		for(ProveedorBo proveedor: proveedores) {
			proveedoresDto.add(new ProveedorDto(proveedor));
		}
		log.info("mostrando proveedores");
		return proveedoresDto ;
	}
	@GetMapping("/proveedores/{id}")
	public ResponseEntity<ProveedorDto> obtenerProveedor(@PathVariable Long id){
	ProveedorBo proveedor = proveedorService.obtenerProveedor(id);
	ProveedorDto proveedorDto = new ProveedorDto(proveedor);
	return ResponseEntity.ok(proveedorDto);
	
	}
	
	@PostMapping("/proveedores")
	public ResponseEntity<ProveedorDto> nuevoProveedor(@RequestBody ProveedorDto proveedorDto){
		ProveedorBo proveedor = new ProveedorBo();
		proveedor.setNombre(proveedorDto.getNombre());
		proveedor.setDireccion(proveedorDto.getDireccion());
		proveedor.setTelefono(proveedorDto.getTelefono());
		proveedor.setMateriales(proveedorDto.getMateriales());
		proveedorService.nuevoProveedor(proveedor);
		return ResponseEntity.status(HttpStatus.CREATED).body(proveedorDto);
	}
}
