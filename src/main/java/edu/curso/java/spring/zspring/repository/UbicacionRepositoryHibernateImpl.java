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
		return entityManager.createQuery("from UbicacionBo as u order by u.direccion").getResultList();
	}

	@Override
	public UbicacionBo obtenerUbicacion(Long id) {
		return entityManager.find(UbicacionBo.class, id);
	}

	@Override
	public void nuevaUbicacion(UbicacionBo ubicacion) {
		entityManager.persist(ubicacion);
	}

	@Override
	public void eliminarUbicacion(Long id) {
		UbicacionBo ubicacion = entityManager.find(UbicacionBo.class, id);
		entityManager.remove(ubicacion);
	}

	@Override
	public void editarUbicacion(UbicacionBo ubicacionBo, Long id) {
		UbicacionBo ubicacion = entityManager.find(UbicacionBo.class, id);
		ubicacion.setDireccion(ubicacionBo.getDireccion());
		entityManager.merge(ubicacion);
	}

	
}
