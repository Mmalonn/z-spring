package edu.curso.java.spring.zspring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.curso.java.spring.zspring.bo.TrabajoTerminadoBo;
import edu.curso.java.spring.zspring.repository.interf.TrabajoTerminadoRepository;
import edu.curso.java.spring.zspring.service.interf.TrabajoTerminadoService;

@Service
@Transactional
public class TrabajoTerminadoServiceImpl implements TrabajoTerminadoService {

	@Autowired
	private TrabajoTerminadoRepository trabajoTerminadoRepository;
	
	@Override
	public List<TrabajoTerminadoBo> listarTrabajosTerminados() {
		return trabajoTerminadoRepository.listarTrabajosTerminados();
	}

}
