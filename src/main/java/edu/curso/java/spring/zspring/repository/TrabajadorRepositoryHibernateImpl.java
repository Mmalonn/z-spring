package edu.curso.java.spring.zspring.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.curso.java.spring.zspring.bo.ProveedorBo;
import edu.curso.java.spring.zspring.bo.TrabajadorBo;
import edu.curso.java.spring.zspring.bo.TrabajoBo;
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

	@Override
	public TrabajadorBo nuevoTrabajador(TrabajadorBo trabajadorBo) {
		entityManager.persist(trabajadorBo);
		return null;
	}

	@Override
	public void editarTrabajador(TrabajadorBo trabajadorBo, Long id) {
		TrabajadorBo trabajador = entityManager.find(TrabajadorBo.class, id);
		trabajador.setNombre(trabajadorBo.getNombre());
		trabajador.setApellido(trabajadorBo.getApellido());
		trabajador.setDni(trabajadorBo.getDni());
		trabajador.setTelefono(trabajadorBo.getTelefono());
		trabajador.setSueldoPorHora(trabajadorBo.getSueldoPorHora());
		trabajador.setTrabajos(trabajadorBo.getTrabajos());
		entityManager.merge(trabajador);
	}

	@Override
	public void borrarTrabajador(Long id) {
		TrabajadorBo trabajador = entityManager.find(TrabajadorBo.class, id);
		entityManager.remove(trabajador);
	}

	@Override
	public List<TrabajoBo> obtenerTrabajosTrabajador(TrabajadorBo trabajadorBo) {
		return entityManager.createQuery("select trabajoBo from trabajadorBo as t where t.nombre = :custName").setParameter("custName", trabajadorBo.getNombre()).getResultList();
	}
	

}
