package edu.curso.java.spring.zspring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.curso.java.spring.zspring.bo.TrabajadorBo;
import edu.curso.java.spring.zspring.bo.TrabajoBo;
import edu.curso.java.spring.zspring.repository.interf.TrabajadorRepository;
import edu.curso.java.spring.zspring.repository.interf.TrabajoRepository;
import edu.curso.java.spring.zspring.service.interf.TrabajadorService;

@Service
@Transactional
public class TrabajadorServiceImpl implements TrabajadorService {

	@Autowired
	private TrabajadorRepository trabajadorRepository;
	@Autowired
	private TrabajoRepository trabajoRepository;
	
	@Override
	public List<TrabajadorBo> listarTrabajadores() {
		return trabajadorRepository.listarTrabajadores();
	}

	@Override
	public TrabajadorBo obtenerTrabajador(Long id) {
		return trabajadorRepository.obtenerTrabajador(id);
	}

	@Override
	public TrabajadorBo nuevoTrabajador(TrabajadorBo trabajadorBo) {
		return trabajadorRepository.nuevoTrabajador(trabajadorBo);
		
	}

	@Override
	public void editarTrabajador(TrabajadorBo trabajador, Long id) {
		trabajadorRepository.editarTrabajador(trabajador, id);
	}

	@Override
	public void borrarTrabajador(Long id) {
		trabajadorRepository.borrarTrabajador(id);
	}

	@Override
	public void borrarTrabajoTrabajador(Long id, TrabajadorBo trabajador) {	
		List<TrabajoBo> trabajos = trabajadorRepository.obtenerTrabajosTrabajador(trabajador);
		TrabajoBo trabajoABorrar = trabajoRepository.obtenerTrabajo(id);
		trabajos.remove(trabajoABorrar);
		trabajador.setTrabajos(trabajos);
		Long id2 = trabajador.getId();
		trabajadorRepository.editarTrabajador(trabajador, id2);
	}

	@Override
	public List<TrabajoBo> obtenerTrabajosTrabajador(Long id) {
		TrabajadorBo trabajador = trabajadorRepository.obtenerTrabajador(id);
		return trabajadorRepository.obtenerTrabajosTrabajador(trabajador);
	}

}
