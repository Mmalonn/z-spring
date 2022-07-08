package edu.curso.java.spring.zspring.repository.interf;

import java.util.List;

import edu.curso.java.spring.zspring.bo.TrabajadorBo;

public interface TrabajadorRepository {

	public List<TrabajadorBo> listarTrabajadores();
}
