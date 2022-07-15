package edu.curso.java.spring.zspring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import edu.curso.java.spring.zspring.bo.CategoriaBo;
import edu.curso.java.spring.zspring.bo.MaterialBo;
import edu.curso.java.spring.zspring.bo.ProveedorBo;
import edu.curso.java.spring.zspring.repository.MaterialRepositoryJdbc;
import edu.curso.java.spring.zspring.repository.interf.CategoriaRepository;
import edu.curso.java.spring.zspring.repository.interf.MaterialRepository;
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

	@Override
	public void eliminarMaterial(Long id) {
		materialRepository.eliminarMaterial(id);
	}

	@Override
	public void editarMaterial(MaterialBo material, Long id) {
		materialRepository.editarMaterial(material, id);
	}

	@Override
	public void nuevoMaterial(MaterialBo material, Long idCategoria, Long idProveedor) {
		CategoriaBo categoria = categoriaRepository.obtenerCategoria(idCategoria);
		ProveedorBo proveedor = proveedorRepository.obtenerProveedor(idProveedor);

		material.setCategoriaBo(categoria);
		material.setProveedorBo(proveedor);
		materialRepository.nuevoMaterial(material);
		try {
			List<MaterialBo> materiales = proveedorRepository.obtenerMaterialesProveedor(proveedor);
			materiales.add(material);
			System.out.println(material.getNombre());
			proveedor.setMateriales(materiales);
			proveedorRepository.editarProveedor(proveedor, idProveedor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			List<MaterialBo> materiales = categoriaRepository.obtenerMaterialesCategoria(categoria);
			materiales.add(material);
			categoria.setMateriales(materiales);
			categoriaRepository.editarCategoria(categoria, idCategoria);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void nuevoMaterial(MaterialBo material) {
		materialRepository.nuevoMaterial(material);
	}

	@Override
	public Long obtenerStock(Long idMaterial) {
		MaterialBo material = materialRepository.obtenerMaterial(idMaterial);
		return material.getCantidad();
	}

	@Override
	public Long restarMateriales(Long idMaterial, Long cantidad) throws MaterialException {
		MaterialBo material = materialRepository.obtenerMaterial(idMaterial);
		String nombre = material.getNombre();
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

}
