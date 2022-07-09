package edu.curso.java.spring.zspring.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.curso.java.spring.zspring.bo.CategoriaBo;
import edu.curso.java.spring.zspring.repository.interf.CategoriaRepository;

@Repository
public class CategoriaRepositoryHibernateImpl implements CategoriaRepository {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<CategoriaBo> listarCategorias() {
		return entityManager.createQuery("from CategoriaBo as p order by p.nombre").getResultList();
	}

	@Override
	public CategoriaBo obtenerCategoria(Long id) {
		return entityManager.find(CategoriaBo.class, id);
	}



}
