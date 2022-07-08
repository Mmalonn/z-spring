package edu.curso.java.spring.zspring.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.curso.java.spring.zspring.bo.MaterialBo;
import edu.curso.java.spring.zspring.repository.interf.MaterialRepository;

@Repository
public class MaterialRepositoryHibernateImpl implements MaterialRepository {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<MaterialBo> listarMateriales() {
		return entityManager.createQuery("from MaterialBo as m order by m.nombre").getResultList();
	}

}
