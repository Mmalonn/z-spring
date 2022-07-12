package edu.curso.java.spring.zspring.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.curso.java.spring.zspring.bo.MaterialBo;
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

	@Override
	public ProveedorBo obtenerProveedor(Long id) {
		return entityManager.find(ProveedorBo.class, id);
	}

	@Override
	public ProveedorBo nuevoProveedor(ProveedorBo proveedorBo) {
		entityManager.persist(proveedorBo);
		return null;
	}

	@Override
	public void borrarProveedor(Long id) {
		ProveedorBo proveedor = entityManager.find(ProveedorBo.class, id);
		entityManager.remove(proveedor);
	}

	@Override
	public void editarProveedor(ProveedorBo proveedorBo, Long id) {
		ProveedorBo proveedor = entityManager.find(ProveedorBo.class, id);
		proveedor.setNombre(proveedorBo.getNombre());
		proveedor.setDireccion(proveedorBo.getDireccion());
		proveedor.setTelefono(proveedorBo.getTelefono());
		proveedor.setMateriales(proveedor.getMateriales());
		entityManager.merge(proveedor);
	}

	@Override
	public List<MaterialBo> obtenerMaterialesProveedor(ProveedorBo proveedorBo) {
		return entityManager.createQuery("select materiales from ProveedorBo as p where p.nombre = :custName")
				.setParameter("custName", proveedorBo.getNombre()).getResultList();
	}

}
