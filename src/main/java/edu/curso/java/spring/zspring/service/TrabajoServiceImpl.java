package edu.curso.java.spring.zspring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import edu.curso.java.spring.zspring.bo.TrabajadorBo;
import edu.curso.java.spring.zspring.bo.TrabajoBo;
import edu.curso.java.spring.zspring.bo.UbicacionBo;
import edu.curso.java.spring.zspring.repository.interf.TrabajadorRepository;
import edu.curso.java.spring.zspring.repository.interf.TrabajoRepository;
import edu.curso.java.spring.zspring.repository.interf.UbicacionRepository;
import edu.curso.java.spring.zspring.service.interf.TrabajoService;

@Service
@Transactional
public class TrabajoServiceImpl implements TrabajoService {

	@Autowired
	private TrabajoRepository trabajoRepository;
	@Autowired
	private UbicacionRepository ubicacionRepository;
	@Autowired
	private TrabajadorRepository trabajadorRepository;
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public List<TrabajoBo> listarTrabajos() {
		return trabajoRepository.listarTrabajos();
	}

	@Override
	public TrabajoBo obtenerTrabajo(Long id) {
		return trabajoRepository.obtenerTrabajo(id);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@Override
	public void agregarTrabajo(TrabajoBo trabajo, Long id) {
		UbicacionBo ubicacion = trabajo.getUbicacionBo();
		ubicacionRepository.nuevaUbicacion(ubicacion);
		TrabajadorBo trabajadorBo = trabajadorRepository.obtenerTrabajador(id);
		trabajo.setTrabajadorBo(trabajadorBo);
		trabajoRepository.agregarTrabajo(trabajo);
		try {
			List<TrabajoBo> trabajos = trabajadorRepository.obtenerTrabajosTrabajador(trabajadorBo);
			trabajos.add(trabajo);
			trabajadorBo.setTrabajos(trabajos);
			trabajadorRepository.editarTrabajador(trabajadorBo, id);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("hola");
		}
	}

	@PreAuthorize("hasRole('ADMIN')")
	@Override
	public void eliminarTrabajo(Long id) {
		trabajoRepository.borrarTrabajo(id);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@Override
	public void editarTrabajo(TrabajoBo trabajoBo, Long id2) {
		TrabajoBo trabajo = trabajoRepository.obtenerTrabajo(id2);
		trabajoRepository.editarTrabajo(trabajo, id2);
	}
	
	@Async
	@Override
	public void enviarCorreoFactura(String emailCliente, String titulo, String mensaje) {
		System.out.println(emailCliente);
		System.out.println(titulo);
		System.out.println(mensaje);
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("emaildeprueba@gmail.com");
		message.setTo(emailCliente);
		message.setSubject(titulo);
		message.setText(mensaje);
		try {
		javaMailSender.send(message);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void cargarTrabajos(Model model) {
		List<TrabajoBo> trabajos = this.listarTrabajos();
		model.addAttribute("trabajos", trabajos);
	}

	
}
