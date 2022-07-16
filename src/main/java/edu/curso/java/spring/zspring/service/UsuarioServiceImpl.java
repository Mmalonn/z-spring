package edu.curso.java.spring.zspring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.curso.java.spring.zspring.bo.USERS;
import edu.curso.java.spring.zspring.repository.interf.UsuarioRepository;
import edu.curso.java.spring.zspring.service.interf.UsuarioService;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	
	@Override
	public void guardarUsuario(USERS usuario) {
		usuarioRepository.guardarUsuario(usuario);
	}

	
}
