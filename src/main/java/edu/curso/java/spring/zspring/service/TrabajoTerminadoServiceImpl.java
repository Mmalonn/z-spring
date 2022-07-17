package edu.curso.java.spring.zspring.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import edu.curso.java.spring.zspring.bo.TrabajoBo;
import edu.curso.java.spring.zspring.bo.TrabajoTerminadoBo;
import edu.curso.java.spring.zspring.repository.interf.TrabajoTerminadoRepository;
import edu.curso.java.spring.zspring.service.interf.TrabajoTerminadoService;

@Service
@Transactional
public class TrabajoTerminadoServiceImpl implements TrabajoTerminadoService {

	@Autowired
	private TrabajoTerminadoRepository trabajoTerminadoRepository;
	
	@Override
	public List<TrabajoTerminadoBo> listarTrabajosTerminados() {
		return trabajoTerminadoRepository.listarTrabajosTerminados();
	}

	@Override
	public TrabajoTerminadoBo obtenerTerminado(Long id) {
		return trabajoTerminadoRepository.obtenerTerminado(id);
	}

	@Override
	public void nuevoTerminado(TrabajoBo trabajo) {
		TrabajoTerminadoBo terminado = new TrabajoTerminadoBo();
		terminado.setNombre(trabajo.getNombre());
		terminado.setFecha(trabajo.getFecha());
		terminado.setTarea(trabajo.getTarea());
		terminado.setHorasEstimadas(trabajo.getHorasEstimadas());
		terminado.setTrabajadorBo(trabajo.getTrabajadorBo().getNombre());
		terminado.setPrecioFinal(trabajo.getPrecioFinal());
		terminado.setUbicacionBo(trabajo.getUbicacionBo().getDireccion());
		LocalDate localDate = LocalDate.now();
		terminado.setFechaFinalizacion(localDate);
		trabajoTerminadoRepository.nuevoTerminado(terminado);
	}

	@Override
	public void nuevoTerminado(TrabajoTerminadoBo trabajo) {
		trabajoTerminadoRepository.nuevoTerminado(trabajo);
	}
	
	@Override
	public void cargarTerminados(Model model) {
		List<TrabajoTerminadoBo> trabajosTerminados = this.listarTrabajosTerminados();		
		model.addAttribute("terminados", trabajosTerminados);
	}

}
