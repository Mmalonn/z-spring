package edu.curso.java.spring.zspring.rest;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
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

import edu.curso.java.spring.zspring.bo.MaterialBo;
import edu.curso.java.spring.zspring.rest.dto.CategoriaDto;
import edu.curso.java.spring.zspring.rest.dto.MaterialDto;
import edu.curso.java.spring.zspring.service.interf.MaterialService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class MaterialRestController {

	private static Logger log = LoggerFactory.getLogger(MaterialRestController.class);

	@Autowired
	private MaterialService materialService;

	@GetMapping("/materiales")
	public List<MaterialDto> listarMateriales() {
		List<MaterialBo> materiales = materialService.listarMateriales();
		List<MaterialDto> materialesDto = new ArrayList<MaterialDto>();
		for (MaterialBo material : materiales) {
			materialesDto.add(new MaterialDto(material));
			System.out.println(material);
		}
		System.out.println(materiales);
		System.out.println(materialesDto);
		
		return materialesDto;
	}

	@GetMapping("/materiales/{id}")
	public ResponseEntity<MaterialDto> obtenerMaterial(@PathVariable Long id) {
		MaterialBo material = materialService.obtenerMaterial(id);
		MaterialDto materialDto = new MaterialDto(material);
		return ResponseEntity.ok(materialDto);
	}

	@PostMapping("/materiales")
	public ResponseEntity<MaterialDto> nuevoMaterial(@RequestBody MaterialDto materialDto) {
		MaterialBo material = new MaterialBo();
		material.setNombre(materialDto.getNombre());
		material.setPrecio(materialDto.getPrecio());
		material.setCantidad(materialDto.getCantidad());
		material.setCategoriaBo(materialDto.getCategoriaBo());
		material.setProveedorBo(materialDto.getProveedorBo());
		materialService.nuevoMaterial(material);
		return ResponseEntity.status(HttpStatus.CREATED).body(materialDto);
	}

	@DeleteMapping("/materiales/borrar/{id}")
	public ResponseEntity<?> eliminarMaterial(@PathVariable Long id) {
		materialService.eliminarMaterial(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

	@PutMapping("/materiales/{id}")
	public ResponseEntity<MaterialDto> actualizarMaterial(@RequestBody MaterialDto materialDto, @PathVariable Long id) {
		MaterialBo material = new MaterialBo();
		material.setNombre(materialDto.getNombre());
		material.setCantidad(materialDto.getCantidad());
		material.setPrecio(materialDto.getPrecio());
		material.setCategoriaBo(materialDto.getCategoriaBo());
		material.setProveedorBo(materialDto.getProveedorBo());
		materialService.editarMaterial(material, id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(materialDto);

	}
}
