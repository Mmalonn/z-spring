package edu.curso.java.spring.zspring.repository.interf;

import java.util.List;

import edu.curso.java.spring.zspring.bo.TrabajadorBo;

public interface TrabajadorRepository {

	public List<TrabajadorBo> listarTrabajadores();

	public TrabajadorBo obtenerTrabajador(Long id);

	public TrabajadorBo nuevoTrabajador(TrabajadorBo trabajadorBo);

	public void editarTrabajador(TrabajadorBo trabajadorBo, Long id);
	
	public void borrarTrabajador(Long id);
}
