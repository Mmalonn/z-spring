package edu.curso.java.spring.zspring.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.curso.java.spring.zspring.bo.TrabajoTerminadoBo;
import edu.curso.java.spring.zspring.repository.interf.TrabajoTerminadoRepository;

@Repository
public class TrabajoTerminadoRepositoryHibernateImpl implements TrabajoTerminadoRepository {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<TrabajoTerminadoBo> listarTrabajosTerminados() {
		return entityManager.createQuery("from TrabajoTerminadoBo as t order by t.nombre").getResultList();
	}

	@Override
	public TrabajoTerminadoBo obtenerTerminado(Long id) {
		return entityManager.find(TrabajoTerminadoBo.class, id);
	}

}
