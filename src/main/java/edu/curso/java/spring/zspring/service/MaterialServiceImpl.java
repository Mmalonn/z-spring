package edu.curso.java.spring.zspring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.curso.java.spring.zspring.bo.MaterialBo;
import edu.curso.java.spring.zspring.repository.interf.MaterialRepository;
import edu.curso.java.spring.zspring.service.interf.MaterialService;

@Service
@Transactional
public class MaterialServiceImpl implements MaterialService {

	@Autowired
	private MaterialRepository materialRepository;
	
	@Override
	public List<MaterialBo> listarMateriales() {
		return materialRepository.listarMateriales();
	}

}
