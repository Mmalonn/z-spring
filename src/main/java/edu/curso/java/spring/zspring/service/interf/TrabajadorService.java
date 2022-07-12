package edu.curso.java.spring.zspring.service.interf;

import java.util.List;

import edu.curso.java.spring.zspring.bo.TrabajadorBo;
import edu.curso.java.spring.zspring.bo.TrabajoBo;

public interface TrabajadorService {

	List<TrabajadorBo> listarTrabajadores();
	
	TrabajadorBo obtenerTrabajador(Long id);

	TrabajadorBo nuevoTrabajador(TrabajadorBo trabajadorBo);

	void editarTrabajador(TrabajadorBo trabajador, Long id);

	void borrarTrabajador(Long id);

	void borrarTrabajoTrabajador(Long id, TrabajadorBo trabajador);

	List<TrabajoBo> obtenerTrabajosTrabajador(Long id);
}
