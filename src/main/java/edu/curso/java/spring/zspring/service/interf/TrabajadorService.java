package edu.curso.java.spring.zspring.service.interf;

import java.util.List;

import edu.curso.java.spring.zspring.bo.TrabajadorBo;

public interface TrabajadorService {

	List<TrabajadorBo> listarTrabajadores();
	
	TrabajadorBo obtenerTrabajador(Long id);

	TrabajadorBo nuevoTrabajador(TrabajadorBo trabajadorBo);
}
