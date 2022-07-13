package edu.curso.java.spring.zspring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.curso.java.spring.zspring.bo.FacturaBo;

import edu.curso.java.spring.zspring.repository.interf.FacturaRepository;

import edu.curso.java.spring.zspring.service.interf.FacturaService;

@Service
@Transactional
public class FacturaServiceImpl implements FacturaService {

	@Autowired
	private FacturaRepository facturaRepository;

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
