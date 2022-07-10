package edu.curso.java.spring.zspring.mvc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.curso.java.spring.zspring.bo.ProveedorBo;
import edu.curso.java.spring.zspring.bo.TrabajadorBo;
import edu.curso.java.spring.zspring.mvc.form.TrabajadorForm;
import edu.curso.java.spring.zspring.service.interf.ProveedorService;
import edu.curso.java.spring.zspring.service.interf.TrabajadorService;

@Controller
@RequestMapping("/trabajadores")
public class TrabajadorController {

	private static Logger log = LoggerFactory.getLogger(TrabajadorController.class);

	@Autowired
	private TrabajadorService trabajadorService;
	@Autowired
	private ProveedorService proveedorService;

	@GetMapping("/lista")
	public String listar(Model model) {
		List<TrabajadorBo> trabajadores = trabajadorService.listarTrabajadores();
		List<ProveedorBo> proveedores = proveedorService.listarProveedores();
		model.addAttribute("proveedores", proveedores);
		model.addAttribute("trabajadores", trabajadores);
		log.info("mostrando trabajadores");
		return "/trabajadores/listar";
	}

	@GetMapping("/{id}")
	public String verTrabajador(Model model, @PathVariable Long id) {
		TrabajadorBo trabajador = trabajadorService.obtenerTrabajador(id);
		List<ProveedorBo> proveedores = proveedorService.listarProveedores();
		model.addAttribute("proveedores", proveedores);
		model.addAttribute("trabajador", trabajador);
		return "/trabajadores/trabajador";
	}

	@GetMapping("/nuevo")
	public String nuevoTrabajador(Model model) {
		List<ProveedorBo> proveedores = proveedorService.listarProveedores();
		model.addAttribute("proveedores", proveedores);
		model.addAttribute("trabajadorForm", new TrabajadorForm());
		return "/trabajadores/form";
	}

	@PostMapping("/guardar")
	public String guardar(@ModelAttribute(name = "trabajadorForm") TrabajadorForm trabajadorForm, Model model) {
		TrabajadorBo trabajador = null;
		Long idTrabajador = trabajadorForm.getId();
		if (idTrabajador == null) {
			trabajador = new TrabajadorBo();
		} else {
			trabajador = trabajadorService.obtenerTrabajador(idTrabajador);
		}
		trabajador.setNombre(trabajadorForm.getNombre());
		trabajador.setApellido(trabajadorForm.getApellido());
		trabajador.setDni(trabajadorForm.getDni());
		trabajador.setTelefono(trabajadorForm.getTelefono());
		trabajador.setSueldoPorHora(trabajadorForm.getSueldoPorHora());

		if (idTrabajador == null) {
			trabajadorService.nuevoTrabajador(trabajador);
		} else {
			trabajadorService.editarTrabajador(trabajador, idTrabajador);
		}
		return "redirect:/trabajadores/lista";
	}
	
	@GetMapping("/{id}/editar")
	public String editar(Model model, @PathVariable Long id) {
		TrabajadorBo trabajador= trabajadorService.obtenerTrabajador(id);
		TrabajadorForm form = new TrabajadorForm();
		List<ProveedorBo> proveedores = proveedorService.listarProveedores();
		model.addAttribute("proveedores", proveedores);
		form.setId(trabajador.getId());
		form.setNombre(trabajador.getNombre());
		form.setApellido(trabajador.getApellido());
		form.setDni(trabajador.getDni());
		form.setTelefono(trabajador.getTelefono());
		form.setSueldoPorHora(trabajador.getSueldoPorHora());
		model.addAttribute("trabajadorForm", form);
		return "/trabajadores/form";
	}
	
	@GetMapping("/{id}/eliminar")
	public String eliminarTrabajador(Model model, @PathVariable Long id) {
		trabajadorService.borrarTrabajador(id);
		return "redirect:/trabajadores/lista";
	}

}
