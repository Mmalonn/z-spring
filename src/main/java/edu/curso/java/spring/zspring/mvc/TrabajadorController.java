package edu.curso.java.spring.zspring.mvc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
		trabajadorService.cargarTrabajadores(model);
		proveedorService.cargarProveedores(model);
		log.info("mostrando trabajadores");
		return "/trabajadores/listar";
	}

	@GetMapping("/{id}")
	public String verTrabajador(Model model, @PathVariable Long id) {
		proveedorService.cargarProveedores(model);
		trabajadorService.cargarTrabajosTrabajador(model, id);
		TrabajadorBo trabajador = trabajadorService.obtenerTrabajador(id);
		model.addAttribute("trabajador", trabajador);
		return "/trabajadores/trabajador";
	}

	@GetMapping("/nuevo")
	public String nuevoTrabajador(Model model) {
		proveedorService.cargarProveedores(model);
		model.addAttribute("trabajadorForm", new TrabajadorForm());
		return "/trabajadores/form";
	}

	//este metodo permite guardar un nuevo trabajador o guardar la edicion sobre un trabajador indicado por id, ademas de poder guardar una foto del mismo
	@PostMapping("/guardar")
	public String guardar(@Valid @ModelAttribute(name = "trabajadorForm") TrabajadorForm trabajadorForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			proveedorService.cargarProveedores(model);
			model.addAttribute("trabajadorForm", trabajadorForm);
			return "/trabajadores/form";
		}
		TrabajadorBo trabajador = null;
		Long idTrabajador = trabajadorForm.getId();
		if (idTrabajador == null) {
			trabajador = new TrabajadorBo();
		} else {
			trabajador = trabajadorService.obtenerTrabajador(idTrabajador);
		}

		this.setearTrabajador(trabajadorForm, trabajador);
		if (idTrabajador == null) {
			trabajadorService.nuevoTrabajador(trabajador);
		} else {
			trabajadorService.editarTrabajador(trabajador, idTrabajador);
		}

		guardarFoto(trabajadorForm, trabajador);
		return "redirect:/trabajadores/lista";
	}

	@GetMapping(value = "/recuperar-foto/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] recuperarFotoProducto(@PathVariable Long id) {
		TrabajadorBo trabajador = trabajadorService.obtenerTrabajador(id);
		if (trabajador != null) {
			File imagen = new File("C:/Users/marco/Desktop/eclipse-workspace/z-spring/src/main/webapp/WEB-INF/foto-"
					+ trabajador.getId() + ".jpg");
			if (imagen.exists()) {
				try (FileInputStream in = new FileInputStream(imagen)) {
					return in.readAllBytes();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	//envia a la pagina de edicion del trabajador con los modelos correspondientes, rellenando el form con sus datos previos
	@GetMapping("/{id}/editar")
	public String editar(Model model, @PathVariable Long id) {
		proveedorService.cargarProveedores(model);
		TrabajadorBo trabajador = trabajadorService.obtenerTrabajador(id);
		setearForm(model, trabajador);
		return "/trabajadores/form";
	}

	//elimina al trabajador, pero solo es posible si no tiene trabajos asignados, por lo que si ese es el caso, no aparece el boton de eliminar en la vista
	//primero se debe eliminar el trabajo asignado
	@GetMapping("/{id}/eliminar")
	public String eliminarTrabajador(Model model, @PathVariable Long id) {
		trabajadorService.borrarTrabajador(id);
		return "redirect:/trabajadores/lista";
	}

	private void setearTrabajador(TrabajadorForm trabajadorForm, TrabajadorBo trabajador) {
		trabajador.setNombre(trabajadorForm.getNombre());
		trabajador.setApellido(trabajadorForm.getApellido());
		trabajador.setDni(trabajadorForm.getDni());
		trabajador.setTelefono(trabajadorForm.getTelefono());
		trabajador.setSueldoPorHora(trabajadorForm.getSueldoPorHora());
	}

	private void guardarFoto(TrabajadorForm trabajadorForm, TrabajadorBo trabajador) {
		File imagen = new File("C:/Users/marco/Desktop/eclipse-workspace/z-spring/src/main/webapp/WEB-INF/foto-"
				+ trabajador.getId() + ".jpg");
		try (FileOutputStream out = new FileOutputStream(imagen)) {
			out.write(trabajadorForm.getFoto().getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setearForm(Model model, TrabajadorBo trabajador) {
		TrabajadorForm form = new TrabajadorForm();
		form.setId(trabajador.getId());
		form.setNombre(trabajador.getNombre());
		form.setApellido(trabajador.getApellido());
		form.setDni(trabajador.getDni());
		form.setTelefono(trabajador.getTelefono());
		form.setSueldoPorHora(trabajador.getSueldoPorHora());
		model.addAttribute("trabajadorForm", form);
	}
}
