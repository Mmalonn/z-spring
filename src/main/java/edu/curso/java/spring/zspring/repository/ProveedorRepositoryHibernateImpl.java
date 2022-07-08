package edu.curso.java.spring.zspring.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.curso.java.spring.zspring.bo.ProveedorBo;
import edu.curso.java.spring.zspring.repository.interf.ProveedoresRepository;

@Repository
public class ProveedorRepositoryHibernateImpl implements ProveedoresRepository {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<ProveedorBo> listarProveedores() {
		return entityManager.createQuery("from ProveedorBo as p order by p.nombre").getResultList();
	}

}
