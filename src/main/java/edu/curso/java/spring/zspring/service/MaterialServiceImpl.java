package edu.curso.java.spring.zspring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import edu.curso.java.spring.zspring.bo.CategoriaBo;
import edu.curso.java.spring.zspring.bo.MaterialBo;
import edu.curso.java.spring.zspring.bo.ProveedorBo;
import edu.curso.java.spring.zspring.mvc.form.MaterialForm;
import edu.curso.java.spring.zspring.repository.interf.CategoriaRepository;
import edu.curso.java.spring.zspring.repository.interf.MaterialRepository;
import edu.curso.java.spring.zspring.repository.interf.MaterialRepositoryJdbc;
import edu.curso.java.spring.zspring.repository.interf.ProveedoresRepository;
import edu.curso.java.spring.zspring.service.interf.MaterialService;

@Service
@Transactional
public class MaterialServiceImpl implements MaterialService {

	@Autowired
	private MaterialRepository materialRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProveedoresRepository proveedorRepository;
	@Autowired
	private MaterialRepositoryJdbc materialRepositoryJdbc;

	@Override
	public List<MaterialBo> listarMateriales() {
		return materialRepository.listarMateriales();
	}

	@Override
	public MaterialBo obtenerMaterial(Long id) {
		return materialRepository.obtenerMaterial(id);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@Override
	public void eliminarMaterial(Long id) {
		materialRepository.eliminarMaterial(id);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@Override
	public void editarMaterial(MaterialBo material, Long id) {
		materialRepository.editarMaterial(material, id);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@Override
	public void nuevoMaterial(MaterialForm materialForm) {
		CategoriaBo categoria = categoriaRepository.obtenerCategoria(materialForm.getIdCategoria());
		ProveedorBo proveedor = proveedorRepository.obtenerProveedor(materialForm.getIdProveedor());	
		MaterialBo material = new MaterialBo();
		material.setNombre(materialForm.getNombre());
		material.setPrecio(materialForm.getPrecio());
		material.setCantidad(materialForm.getCantidad());
		material.setCategoriaBo(categoria);
		material.setProveedorBo(proveedor);
		materialRepository.nuevoMaterial(material);
		try {
			List<MaterialBo> materiales = proveedorRepository.obtenerMaterialesProveedor(proveedor);
			materiales.add(material);
			proveedor.setMateriales(materiales);
			proveedorRepository.editarProveedor(proveedor, proveedor.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			List<MaterialBo> materiales = categoriaRepository.obtenerMaterialesCategoria(categoria);
			materiales.add(material);
			categoria.setMateriales(materiales);
			categoriaRepository.editarCategoria(categoria, categoria.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PreAuthorize("hasRole('ADMIN')")
	@Override
	public void nuevoMaterial(MaterialBo material) {
		materialRepository.nuevoMaterial(material);
	}

	@Override
	public Long obtenerStock(Long idMaterial) {
		MaterialBo material = materialRepository.obtenerMaterial(idMaterial);
		return material.getCantidad();
	}

	@PreAuthorize("hasRole('ADMIN')")
	@Override
	public Long restarMateriales(Long idMaterial, Long cantidad) throws MaterialException {
		MaterialBo material = materialRepository.obtenerMaterial(idMaterial);
		Long cantidadObtenida = material.getCantidad() - cantidad;
		if (cantidadObtenida < 1) {
			throw new MaterialException("no alcanza el material, necesitas comprar mas");
		} else {
			material.setCantidad(cantidadObtenida);
			materialRepository.editarMaterial(material, idMaterial);
		}
		return idMaterial;
		
	}

	@Override
	public List<MaterialBo> buscarMaterialPorNombre(String nombre) {
		return materialRepositoryJdbc.buscarProductos(nombre);
	}
	
	@Override
	public void cargarMateriales(Model model) {
		List<MaterialBo> materiales = this.listarMateriales();
		model.addAttribute("materiales", materiales);
	}

}
