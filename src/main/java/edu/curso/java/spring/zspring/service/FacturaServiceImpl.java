package edu.curso.java.spring.zspring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.curso.java.spring.zspring.bo.FacturaBo;

import edu.curso.java.spring.zspring.repository.interf.FacturaRepository;

import edu.curso.java.spring.zspring.service.interf.FacturaService;

//los metodos de edicion, alta y eliminacion solo son accesibles con la cuenta admin y no se muestran los botones en las vistas en el resto de cuentas

@Service
@Transactional
public class FacturaServiceImpl implements FacturaService {

	@Autowired
	private FacturaRepository facturaRepository;

	//la factura se crea unicamente mediante el metodo de crear trabajo
	@Override
	public void crearFactura(FacturaBo factura) {
		facturaRepository.nuevaFactura(factura);
	}

	@Override
	public FacturaBo obtenerFactura(Long id) {
		FacturaBo factura = facturaRepository.obtenerFactura(id);
		return factura;
	}

}
