package edu.curso.java.spring.zspring.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
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

	@Override
	public MaterialBo obtenerMaterial(Long id) {
		return entityManager.find(MaterialBo.class, id);
	}

	@Override
	public void nuevoMaterial(MaterialBo material) {
		entityManager.persist(material);
	}

	@Override
	public void eliminarMaterial(Long id) {
		MaterialBo material = entityManager.find(MaterialBo.class, id);
		entityManager.remove(material);
	}

	@Override
	public void editarMaterial(MaterialBo materialBo, Long id) {
		MaterialBo material = entityManager.find(MaterialBo.class, id);
		material.setNombre(materialBo.getNombre());
		material.setCantidad(materialBo.getCantidad());
		material.setPrecio(materialBo.getPrecio());
		material.setCategoriaBo(materialBo.getCategoriaBo());
		material.setProveedorBo(materialBo.getProveedorBo());
		entityManager.merge(material);
	}


	
}
