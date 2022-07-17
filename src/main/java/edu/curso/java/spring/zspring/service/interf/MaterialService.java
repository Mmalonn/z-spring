package edu.curso.java.spring.zspring.service.interf;

import java.util.List;

import org.springframework.ui.Model;

import edu.curso.java.spring.zspring.bo.MaterialBo;
import edu.curso.java.spring.zspring.mvc.form.MaterialForm;
import edu.curso.java.spring.zspring.service.MaterialException;


public interface MaterialService {

	List<MaterialBo> listarMateriales();

	MaterialBo obtenerMaterial(Long id);

	void eliminarMaterial(Long id);

	void editarMaterial(MaterialBo material, Long id);

	void nuevoMaterial(MaterialForm materialForm);

	void nuevoMaterial(MaterialBo material);

	Long obtenerStock(Long idMaterial);

	Long restarMateriales(Long idMaterial, Long cantidad) throws MaterialException;

	List<MaterialBo> buscarMaterialPorNombre(String nombre);
	
	void cargarMateriales(Model model);

}
