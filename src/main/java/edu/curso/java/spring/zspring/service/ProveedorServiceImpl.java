package edu.curso.java.spring.zspring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import edu.curso.java.spring.zspring.bo.ProveedorBo;
import edu.curso.java.spring.zspring.mvc.form.ProveedorForm;
import edu.curso.java.spring.zspring.repository.interf.ProveedoresRepository;
import edu.curso.java.spring.zspring.service.interf.ProveedorService;

@Service
@Transactional
public class ProveedorServiceImpl implements ProveedorService {

	@Autowired
	private ProveedoresRepository proveedorRepository;

	// @Cacheable("proveedores")
	@Override
	public List<ProveedorBo> listarProveedores() {
		return proveedorRepository.listarProveedores();
	}

	@Override
	public ProveedorBo obtenerProveedor(Long id) {
		return proveedorRepository.obtenerProveedor(id);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@Override
	public ProveedorBo nuevoProveedor(ProveedorForm proveedorForm) {
		ProveedorBo proveedor = new ProveedorBo();
		proveedor.setNombre(proveedorForm.getNombre());
		proveedor.setTelefono(proveedorForm.getTelefono());
		proveedor.setDireccion(proveedorForm.getDireccion());
		return proveedorRepository.nuevoProveedor(proveedor);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@Override
	public void borrarProveedor(Long id) {
		proveedorRepository.borrarProveedor(id);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@Override
	public void editarProveedor(ProveedorBo proveedorBo, Long id) {
		proveedorRepository.editarProveedor(proveedorBo, id);
	}

	@Override
	public void cargarProveedores(Model model) {
		List<ProveedorBo> proveedores = this.listarProveedores();
		model.addAttribute("proveedores", proveedores);
	}

	@Override
	public void nuevoProveedor(ProveedorBo proveedor) {
		proveedorRepository.nuevoProveedor(proveedor);	
	}

}
