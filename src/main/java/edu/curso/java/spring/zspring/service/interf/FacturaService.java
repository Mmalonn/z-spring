package edu.curso.java.spring.zspring.service.interf;

import edu.curso.java.spring.zspring.bo.FacturaBo;
import edu.curso.java.spring.zspring.mvc.form.TrabajoForm;

public interface FacturaService {

	void crearFactura(TrabajoForm trabajo);

	FacturaBo obtenerFactura(Long id);

}
