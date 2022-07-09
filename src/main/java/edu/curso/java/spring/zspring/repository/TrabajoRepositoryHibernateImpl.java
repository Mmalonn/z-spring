package edu.curso.java.spring.zspring.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.curso.java.spring.zspring.bo.TrabajoBo;
import edu.curso.java.spring.zspring.repository.interf.TrabajoRepository;

@Repository
public class TrabajoRepositoryHibernateImpl implements TrabajoRepository {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<TrabajoBo> listarTrabajos() {	
		return entityManager.createQuery("from TrabajoBo as t order by t.nombre").getResultList();
	}

	@Override
	public TrabajoBo obtenerTrabajo(Long id) {
		return entityManager.find(TrabajoBo.class, id);
	}
}
