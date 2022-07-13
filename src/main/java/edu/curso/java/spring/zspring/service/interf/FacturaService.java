package edu.curso.java.spring.zspring.service.interf;

import edu.curso.java.spring.zspring.bo.FacturaBo;

public interface FacturaService {

	void crearFactura(FacturaBo factura);

	FacturaBo obtenerFactura(Long id);

}
