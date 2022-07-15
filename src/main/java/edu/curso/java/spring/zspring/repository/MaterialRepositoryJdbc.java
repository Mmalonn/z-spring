package edu.curso.java.spring.zspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.curso.java.spring.zspring.bo.MaterialBo;

@Repository
public interface MaterialRepositoryJdbc extends JpaRepository<MaterialBo, Long> {

	@Query("select m from MaterialBo as m where m.nombre like ?1%")
	List<MaterialBo> buscarProductos(String nombre);
}
