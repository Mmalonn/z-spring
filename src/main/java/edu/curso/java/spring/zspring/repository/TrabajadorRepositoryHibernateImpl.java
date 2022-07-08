package edu.curso.java.spring.zspring.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.curso.java.spring.zspring.bo.ProveedorBo;
import edu.curso.java.spring.zspring.bo.TrabajadorBo;
import edu.curso.java.spring.zspring.repository.interf.TrabajadorRepository;

@Repository
public class TrabajadorRepositoryHibernateImpl implements TrabajadorRepository {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<TrabajadorBo> listarTrabajadores() {
		return entityManager.createQuery("from TrabajadorBo as t order by t.nombre").getResultList();
	}

	@Override
	public TrabajadorBo obtenerTrabajador(Long id) {
		return entityManager.find(TrabajadorBo.class, id);
	}
	

}
