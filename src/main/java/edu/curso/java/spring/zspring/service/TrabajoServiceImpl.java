package edu.curso.java.spring.zspring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.curso.java.spring.zspring.bo.TrabajoBo;
import edu.curso.java.spring.zspring.repository.interf.TrabajoRepository;
import edu.curso.java.spring.zspring.service.interf.TrabajoService;

@Service
@Transactional
public class TrabajoServiceImpl implements TrabajoService {

	@Autowired
	private TrabajoRepository trabajoRepository;
	
	@Override
	public List<TrabajoBo> listarTrabajos() {
		return trabajoRepository.listarTrabajos();
	}

	@Override
	public TrabajoBo obtenerTrabajo(Long id) {
		return trabajoRepository.obtenerTrabajo(id);
	}

	@Override
	public void agregarTrabajador(TrabajoBo trabajo) {
		trabajoRepository.agregarTrabajo(trabajo);
	}

	@Override
	public void eliminarTrabajo(Long id) {
		trabajoRepository.borrarTrabajo(id);
	}

	@Override
	public void editarTrabajo(TrabajoBo trabajo, Long id) {
		trabajoRepository.editarTrabajo(trabajo, id);
	}

}
