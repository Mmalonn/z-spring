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

import edu.curso.java.spring.zspring.bo.MaterialBo;
import edu.curso.java.spring.zspring.rest.dto.MaterialDto;
import edu.curso.java.spring.zspring.service.interf.MaterialService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class MaterialRestController {

	private static Logger log = LoggerFactory.getLogger(TrabajoRestController.class);

	@Autowired
	private MaterialService materialService;
	
	@GetMapping("/materiales")
	public List<MaterialDto> listarMateriales(){
		List<MaterialBo> materiales = materialService.listarMateriales();
		List<MaterialDto> materialesDto = new ArrayList<MaterialDto>();
		for(MaterialBo material: materiales) {
			materialesDto.add(new MaterialDto(material));
		}
		log.info("mostrando materiales");
		return materialesDto ;
	}
}
