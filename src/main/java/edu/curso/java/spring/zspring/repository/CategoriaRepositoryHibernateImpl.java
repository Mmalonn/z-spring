package edu.curso.java.spring.zspring.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.curso.java.spring.zspring.bo.CategoriaBo;
import edu.curso.java.spring.zspring.bo.MaterialBo;
import edu.curso.java.spring.zspring.bo.ProveedorBo;
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

	@Override
	public void nuevaCategoria(CategoriaBo categoria) {
		entityManager.persist(categoria);
	}

	@Override
	public void editarCategoria(CategoriaBo categoriaBo, Long id) {
		CategoriaBo categoria = entityManager.find(CategoriaBo.class, id);
		categoria.setNombre(categoriaBo.getNombre());
		categoria.setMateriales(categoriaBo.getMateriales());
		entityManager.merge(categoria);
	}

	@Override
	public List<MaterialBo> obtenerMaterialesCategoria(CategoriaBo categoriaBo) {
		return entityManager.createQuery("select materiales from CategoriaBo as b where b.nombre = :custName").setParameter("custName", categoriaBo.getNombre()).getResultList();
	}



}
