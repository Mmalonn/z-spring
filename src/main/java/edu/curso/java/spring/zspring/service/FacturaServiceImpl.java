package edu.curso.java.spring.zspring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.curso.java.spring.zspring.bo.FacturaBo;
import edu.curso.java.spring.zspring.bo.MaterialBo;
import edu.curso.java.spring.zspring.bo.TrabajadorBo;
import edu.curso.java.spring.zspring.bo.TrabajoBo;
import edu.curso.java.spring.zspring.mvc.form.TrabajoForm;
import edu.curso.java.spring.zspring.repository.interf.FacturaRepository;
import edu.curso.java.spring.zspring.repository.interf.MaterialRepository;
import edu.curso.java.spring.zspring.repository.interf.TrabajadorRepository;
import edu.curso.java.spring.zspring.service.interf.FacturaService;

@Service
@Transactional
public class FacturaServiceImpl implements FacturaService {

	@Autowired
	private MaterialRepository materialRepository;
	@Autowired
	private FacturaRepository facturaRepository;
	@Autowired
	private TrabajadorRepository trabajadorRepository;

	@Override
	public void crearFactura(TrabajoForm trabajo) {
		FacturaBo factura = new FacturaBo();
		factura.setNombre(trabajo.getNombre());
		factura.setTarea(trabajo.getTarea());
		factura.setFecha(trabajo.getFecha());
		factura.setUbicacionBo(trabajo.getUbicacionBo());
		factura.setHorasEstimadas(trabajo.getHorasEstimadas());
		factura.setCantidad1(trabajo.getCantidad1());
		factura.setCantidad2(trabajo.getCantidad2());
		factura.setCantidad3(trabajo.getCantidad3());
		factura.setPrecioFinal(trabajo.getPrecioFinal());
		TrabajadorBo trabajador = trabajadorRepository.obtenerTrabajador(trabajo.getIdTrabajador());
		factura.setTrabajadorBo(trabajador.getNombre() + " " + trabajador.getApellido());
		String material1 = materialRepository.obtenerMaterial(trabajo.getIdMaterial1()).getNombre();
		factura.setMaterial1(material1);
		String material2 = materialRepository.obtenerMaterial(trabajo.getIdMaterial2()).getNombre();
		factura.setMaterial2(material2);
		String material3 = materialRepository.obtenerMaterial(trabajo.getIdMaterial3()).getNombre();
		factura.setMaterial3(material3);
		facturaRepository.nuevaFactura(factura);
	}

	@Override
	public FacturaBo obtenerFactura(Long id) {
		FacturaBo factura = facturaRepository.obtenerFactura(id);
		return factura;
	}

}
