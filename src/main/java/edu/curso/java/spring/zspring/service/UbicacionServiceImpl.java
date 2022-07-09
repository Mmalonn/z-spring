package edu.curso.java.spring.zspring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.curso.java.spring.zspring.bo.UbicacionBo;
import edu.curso.java.spring.zspring.repository.interf.UbicacionRepository;
import edu.curso.java.spring.zspring.service.interf.UbicacionService;

@Service
@Transactional
public class UbicacionServiceImpl implements UbicacionService {

	@Autowired
	private UbicacionRepository ubicacionRepository;

	@Override
	public List<UbicacionBo> listarUbicaciones() {
		return ubicacionRepository.listarUbicaciones();
	}

	@Override
	public UbicacionBo obtenerUbicacion(Long id) {
		return ubicacionRepository.obtenerUbicacion(id);
	}

	@Override
	public void nuevaUbicacion(UbicacionBo ubicacion) {
		ubicacionRepository.nuevaUbicacion(ubicacion);
	}

	@Override
	public void borrarUbicacion(Long id) {
		ubicacionRepository.eliminarUbicacion(id);
	}

	@Override
	public void editarUbicacion(UbicacionBo ubicacion, Long id) {
		ubicacionRepository.editarUbicacion(ubicacion, id);
	}

}
