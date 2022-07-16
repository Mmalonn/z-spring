package edu.curso.java.spring.zspring.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.curso.java.spring.zspring.bo.USERS;
import edu.curso.java.spring.zspring.repository.interf.UsuarioRepository;

@Repository
public class UsuarioRepositoryHibernateImpl implements UsuarioRepository {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void guardarUsuario(USERS usuario) {
		entityManager.persist(usuario);
		entityManager.createNativeQuery("insert INTO GROUP_MEMBERS (ID, USERNAME, GROUP_ID) values (GROUPS_SEQ.nextval,  :nombre, 2)")
		.setParameter("nombre", usuario.getUSERNAME()).executeUpdate();
		entityManager.createNativeQuery("insert INTO AUTHORITIES (USERNAME, AUTHORITY) values (:nombre, 'ROLE_GENERAL')")
		.setParameter("nombre", usuario.getUSERNAME()).executeUpdate();
	}

}
