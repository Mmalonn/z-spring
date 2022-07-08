package edu.curso.java.spring.zspring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.curso.java.spring.zspring.bo.TrabajadorBo;
import edu.curso.java.spring.zspring.repository.interf.TrabajadorRepository;
import edu.curso.java.spring.zspring.service.interf.TrabajadorService;

@Service
@Transactional
public class TrabajadorServiceImpl implements TrabajadorService {

	@Autowired
	private TrabajadorRepository trabajadorRepository;
	
	@Override
	public List<TrabajadorBo> listarTrabajadores() {
		return trabajadorRepository.listarTrabajadores();
	}

}
