package edu.curso.java.spring.zspring.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.curso.java.spring.zspring.bo.FacturaBo;
import edu.curso.java.spring.zspring.repository.interf.FacturaRepository;

@Repository
public class FacturaRepositoryHibernateImpl implements FacturaRepository {

	@Autowired
	private EntityManager entityManager;
	
	
	@Override
	public void nuevaFactura(FacturaBo factura) {
		entityManager.persist(factura);
	}


	@Override
	public FacturaBo obtenerFactura(Long id) {
		return entityManager.find(FacturaBo.class, id);
	}

	
}
