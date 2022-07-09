package edu.curso.java.spring.zspring.repository.interf;

import java.util.List;

import edu.curso.java.spring.zspring.bo.UbicacionBo;

public interface UbicacionRepository {
	
	public List<UbicacionBo> listarUbicaciones();
	
	public UbicacionBo obtenerUbicacion(Long id);

	public void nuevaUbicacion(UbicacionBo ubicacion);

	public void eliminarUbicacion(Long id);
	
	public void editarUbicacion(UbicacionBo ubicacionBo, Long id);
	

}
