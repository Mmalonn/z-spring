package edu.curso.java.spring.zspring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import edu.curso.java.spring.zspring.bo.TrabajadorBo;
import edu.curso.java.spring.zspring.bo.TrabajoBo;
import edu.curso.java.spring.zspring.repository.interf.TrabajadorRepository;
import edu.curso.java.spring.zspring.repository.interf.TrabajoRepository;
import edu.curso.java.spring.zspring.service.interf.TrabajadorService;

//los metodos de edicion, alta y eliminacion solo son accesibles con la cuenta admin y no se muestran los botones en las vistas en el resto de cuentas

@Service
@Transactional
public class TrabajadorServiceImpl implements TrabajadorService {

	@Autowired
	private TrabajadorRepository trabajadorRepository;
	@Autowired
	private TrabajoRepository trabajoRepository;
	
	@Override
	public List<TrabajadorBo> listarTrabajadores() {
		return trabajadorRepository.listarTrabajadores();
	}

	@Override
	public TrabajadorBo obtenerTrabajador(Long id) {
		return trabajadorRepository.obtenerTrabajador(id);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@Override
	public TrabajadorBo nuevoTrabajador(TrabajadorBo trabajadorBo) {
		return trabajadorRepository.nuevoTrabajador(trabajadorBo);
		
	}

	@PreAuthorize("hasRole('ADMIN')")
	@Override
	public void editarTrabajador(TrabajadorBo trabajador, Long id) {
		trabajadorRepository.editarTrabajador(trabajador, id);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@Override
	public void borrarTrabajador(Long id) {
		trabajadorRepository.borrarTrabajador(id);
	}

	//mediante este metodo se elimina el trabajo que se va a eliminar, de la lista de trabajos del empleado
	@PreAuthorize("hasRole('ADMIN')")
	@Override
	public void borrarTrabajoTrabajador(Long id, TrabajadorBo trabajador) {	
		List<TrabajoBo> trabajos = trabajadorRepository.obtenerTrabajosTrabajador(trabajador);
		TrabajoBo trabajoABorrar = trabajoRepository.obtenerTrabajo(id);
		trabajos.remove(trabajoABorrar);
		trabajador.setTrabajos(trabajos);
		Long id2 = trabajador.getId();
		trabajadorRepository.editarTrabajador(trabajador, id2);
	}

	@Override
	public List<TrabajoBo> obtenerTrabajosTrabajador(Long id) {
		TrabajadorBo trabajador = trabajadorRepository.obtenerTrabajador(id);
		return trabajadorRepository.obtenerTrabajosTrabajador(trabajador);
	}
	
	@Override
	public void cargarTrabajosTrabajador(Model model, Long id) {
		List<TrabajoBo> trabajos = this.obtenerTrabajosTrabajador(id);
		model.addAttribute("trabajos", trabajos);
	}
	
	@Override
	public void cargarTrabajadores(Model model) {
		List<TrabajadorBo> trabajadores = this.listarTrabajadores();
		model.addAttribute("trabajadores", trabajadores);
	}
	
	

}
