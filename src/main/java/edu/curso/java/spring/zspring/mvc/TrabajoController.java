package edu.curso.java.spring.zspring.mvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.curso.java.spring.zspring.bo.FacturaBo;
import edu.curso.java.spring.zspring.bo.MaterialBo;
import edu.curso.java.spring.zspring.bo.ProveedorBo;
import edu.curso.java.spring.zspring.bo.TrabajadorBo;
import edu.curso.java.spring.zspring.bo.TrabajoBo;
import edu.curso.java.spring.zspring.bo.UbicacionBo;
import edu.curso.java.spring.zspring.mvc.form.TrabajoForm;
import edu.curso.java.spring.zspring.service.MaterialException;
import edu.curso.java.spring.zspring.service.interf.FacturaService;
import edu.curso.java.spring.zspring.service.interf.MaterialService;
import edu.curso.java.spring.zspring.service.interf.ProveedorService;
import edu.curso.java.spring.zspring.service.interf.TrabajadorService;
import edu.curso.java.spring.zspring.service.interf.TrabajoService;
import edu.curso.java.spring.zspring.service.interf.TrabajoTerminadoService;
import edu.curso.java.spring.zspring.service.interf.UbicacionService;

@Controller
@RequestMapping("/trabajos")
public class TrabajoController {

	private static Logger log = LoggerFactory.getLogger(TrabajoController.class);

	@Autowired
	private TrabajoService trabajoService;
	@Autowired
	private ProveedorService proveedorService;
	@Autowired
	private TrabajadorService trabajadorService;
	@Autowired
	private MaterialService materialService;
	@Autowired
	private UbicacionService ubicacionService;
	@Autowired
	private TrabajoTerminadoService trabajoTerminadoService;
	@Autowired
	private FacturaService facturaService;

	@GetMapping("/lista")
	public String listar(Model model) {
		List<TrabajoBo> trabajos = trabajoService.listarTrabajos();
		List<ProveedorBo> proveedores = proveedorService.listarProveedores();
		model.addAttribute("proveedores", proveedores);
		model.addAttribute("trabajos", trabajos);

		log.info("mostrando trabajos");
		return "/trabajos/listar";
	}

	@GetMapping("/{id}")
	public String verTrabajo(Model model, @PathVariable Long id) {
		TrabajoBo trabajo = trabajoService.obtenerTrabajo(id);
		List<ProveedorBo> proveedores = proveedorService.listarProveedores();
		model.addAttribute("proveedores", proveedores);
		model.addAttribute("trabajo", trabajo);
		return "/trabajos/trabajo";
	}

	@GetMapping("/factura/{id}")
	public String verFactura(Model model, @PathVariable Long id) {
		List<ProveedorBo> proveedores = proveedorService.listarProveedores();
		model.addAttribute("proveedores", proveedores);
		FacturaBo factura = facturaService.obtenerFactura(id);
		model.addAttribute("factura", factura);
		return "/trabajos/factura";
	}

	@GetMapping("/nuevo")
	public String nuevoTrabajo(Model model) {
		List<ProveedorBo> proveedores = proveedorService.listarProveedores();
		model.addAttribute("proveedores", proveedores);
		List<TrabajadorBo> trabajadores = trabajadorService.listarTrabajadores();
		model.addAttribute("trabajadores", trabajadores);
		List<MaterialBo> materiales = materialService.listarMateriales();
		model.addAttribute("materiales", materiales);
		model.addAttribute("trabajoForm", new TrabajoForm());
		return "/trabajos/form";
	}

	@PostMapping("/guardar")
	public String guardar(@Valid @ModelAttribute(name = "trabajoForm") TrabajoForm trabajoForm, BindingResult bindingResult, Model model) throws IOException{
		if(bindingResult.hasErrors()) {
			List<ProveedorBo> proveedores = proveedorService.listarProveedores();
			model.addAttribute("proveedores", proveedores);
			List<TrabajadorBo> trabajadores = trabajadorService.listarTrabajadores();
			model.addAttribute("trabajadores", trabajadores);
			List<MaterialBo> materiales = materialService.listarMateriales();
			model.addAttribute("materiales", materiales);
			model.addAttribute("trabajoForm", trabajoForm);
			return "/trabajos/form";
		}
		
		
		
		TrabajoBo trabajo = new TrabajoBo();
		trabajo.setNombre(trabajoForm.getNombre());
		trabajo.setTarea(trabajoForm.getTarea());
		trabajo.setHorasEstimadas(trabajoForm.getHorasEstimadas());
		trabajo.setFecha(trabajoForm.getFecha());
		List<Long> materialesForm = trabajoForm.getIdMateriales();
		List<String> materiales = new ArrayList<String>();
		for (Long id : materialesForm) {
			MaterialBo material = materialService.obtenerMaterial(id);
			materiales.add(material.getNombre());
		}
		trabajo.setMateriales(materiales);
		trabajo.setPrecioFinal(trabajoForm.getPrecioFinal());
		UbicacionBo ubicacion = new UbicacionBo();
		ubicacion.setDireccion(trabajoForm.getUbicacionBo());
		trabajo.setUbicacionBo(ubicacion);
		Long trabajadorId = trabajoForm.getIdTrabajador();
		try {
		ubicacionService.nuevaUbicacion(ubicacion);
		materialService.restarMateriales(trabajoForm.getIdMaterial(), trabajoForm.getCantidad1());
		materialService.restarMateriales(trabajoForm.getIdMaterial2(), trabajoForm.getCantidad2());
		materialService.restarMateriales(trabajoForm.getIdMaterial3(), trabajoForm.getCantidad3());
		FacturaBo factura = new FacturaBo();
		factura.setNombre(trabajoForm.getNombre());
		factura.setTarea(trabajoForm.getTarea());
		factura.setFecha(trabajoForm.getFecha());
		factura.setUbicacionBo(trabajoForm.getUbicacionBo());
		factura.setHorasEstimadas(trabajoForm.getHorasEstimadas());
		factura.setCantidad1(trabajoForm.getCantidad1());
		factura.setCantidad2(trabajoForm.getCantidad2());
		factura.setCantidad3(trabajoForm.getCantidad3());
		factura.setPrecioFinal(trabajoForm.getPrecioFinal());
		factura.setPrecioT(trabajoForm.getPrecioT());
		factura.setPrecioM1(trabajoForm.getPrecioM1());
		factura.setPrecioM2(trabajoForm.getPrecioM2());
		factura.setPrecioM3(trabajoForm.getPrecioM3());
		TrabajadorBo trabajador = trabajadorService.obtenerTrabajador(trabajoForm.getIdTrabajador());
		factura.setTrabajadorBo(trabajador.getNombre() + " " + trabajador.getApellido());
		String material1 = materialService.obtenerMaterial(trabajoForm.getIdMaterial1()).getNombre();
		factura.setMaterial1(material1);
		String material2 = materialService.obtenerMaterial(trabajoForm.getIdMaterial2()).getNombre();
		factura.setMaterial2(material2);
		String material3 = materialService.obtenerMaterial(trabajoForm.getIdMaterial3()).getNombre();
		factura.setMaterial3(material3);
		trabajo.setFactura(factura);
		facturaService.crearFactura(factura);
		trabajoService.agregarTrabajo(trabajo, trabajadorId);
		}catch(MaterialException e) {
			e.printStackTrace();
			List<ProveedorBo> proveedores = proveedorService.listarProveedores();
			model.addAttribute("proveedores", proveedores);
			List<TrabajadorBo> trabajadores = trabajadorService.listarTrabajadores();
			model.addAttribute("trabajadores", trabajadores);
			List<MaterialBo> materiales2 = materialService.listarMateriales();
			model.addAttribute("materiales", materiales2);
			trabajoForm.setNombre("POR FAVOR REVISA EL STOCK");
			model.addAttribute("trabajoForm", trabajoForm);
			return "/trabajos/form";
		}
		
		return "redirect:/trabajos/lista";
	}

	@GetMapping("/{id}/eliminar/{id2}")
	public String eliminarTrabajo(Model model, @PathVariable Long id, @PathVariable Long id2) {
		TrabajadorBo trabajador = trabajadorService.obtenerTrabajador(id2);
		trabajadorService.borrarTrabajoTrabajador(id, trabajador);

		trabajoService.eliminarTrabajo(id);
		return "redirect:/trabajos/lista";
	}

	@GetMapping("/{id}/terminar/{id2}")
	public String terminarTrabajo(Model model, @PathVariable Long id, @PathVariable Long id2) {
		TrabajadorBo trabajador = trabajadorService.obtenerTrabajador(id2);
		trabajadorService.borrarTrabajoTrabajador(id, trabajador);
		TrabajoBo trabajo = trabajoService.obtenerTrabajo(id);
		trabajoTerminadoService.nuevoTerminado(trabajo);
		trabajoService.eliminarTrabajo(id);

		return "redirect:/trabajos/lista";
	}

}
