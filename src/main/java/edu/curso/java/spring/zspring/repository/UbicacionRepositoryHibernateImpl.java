package edu.curso.java.spring.zspring.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.curso.java.spring.zspring.bo.UbicacionBo;
import edu.curso.java.spring.zspring.repository.interf.UbicacionRepository;

@Repository
public class UbicacionRepositoryHibernateImpl implements UbicacionRepository {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<UbicacionBo> listarUbicaciones() {
		return entityManager.createQuery("from UbicacionBo as u order by u.calle").getResultList();
	}

	@Override
	public UbicacionBo obtenerUbicacion(Long id) {
		return entityManager.find(UbicacionBo.class, id);
	}

	
}
