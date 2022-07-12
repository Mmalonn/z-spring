package edu.curso.java.spring.zspring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.curso.java.spring.zspring.bo.TrabajadorBo;
import edu.curso.java.spring.zspring.bo.TrabajoBo;
import edu.curso.java.spring.zspring.bo.UbicacionBo;
import edu.curso.java.spring.zspring.repository.interf.TrabajadorRepository;
import edu.curso.java.spring.zspring.repository.interf.TrabajoRepository;
import edu.curso.java.spring.zspring.repository.interf.UbicacionRepository;
import edu.curso.java.spring.zspring.service.interf.TrabajoService;

@Service
@Transactional
public class TrabajoServiceImpl implements TrabajoService {

	@Autowired
	private TrabajoRepository trabajoRepository;
	@Autowired
	private UbicacionRepository ubicacionRepository;
	@Autowired
	private TrabajadorRepository trabajadorRepository;

	@Override
	public List<TrabajoBo> listarTrabajos() {
		return trabajoRepository.listarTrabajos();
	}

	@Override
	public TrabajoBo obtenerTrabajo(Long id) {
		return trabajoRepository.obtenerTrabajo(id);
	}

	@Override
	public void agregarTrabajo(TrabajoBo trabajo, Long id) {
		UbicacionBo ubicacion = trabajo.getUbicacionBo();
		ubicacionRepository.nuevaUbicacion(ubicacion);
		TrabajadorBo trabajadorBo = trabajadorRepository.obtenerTrabajador(id);
		trabajo.setTrabajadorBo(trabajadorBo);
		trabajoRepository.agregarTrabajo(trabajo);
		try {
			List<TrabajoBo> trabajos = trabajadorRepository.obtenerTrabajosTrabajador(trabajadorBo);
			trabajos.add(trabajo);
			trabajadorBo.setTrabajos(trabajos);
			trabajadorRepository.editarTrabajador(trabajadorBo, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
