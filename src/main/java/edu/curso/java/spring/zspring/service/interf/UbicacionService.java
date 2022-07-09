package edu.curso.java.spring.zspring.service.interf;

import java.util.List;

import edu.curso.java.spring.zspring.bo.UbicacionBo;

public interface UbicacionService {

	List<UbicacionBo> listarUbicaciones();
	
	UbicacionBo obtenerUbicacion(Long id);
}
