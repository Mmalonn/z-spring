package edu.curso.java.spring.zspring.mvc;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.curso.java.spring.zspring.bo.USERS;
import edu.curso.java.spring.zspring.mvc.form.UsuarioForm;
import edu.curso.java.spring.zspring.service.interf.UsuarioService;

@Controller
@RequestMapping("/")
public class InicioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public String irAInicio(Model model) {
		return "/inicio/index";
	}

	@GetMapping("/registro")
	public String pagRegistro(Model model, UsuarioForm usuarioForm) {
		model.addAttribute(new UsuarioForm());
		return "/inicio/registro";
	}

	@PostMapping("/registro/guardar")
	public String guardarUsuario(@Valid @ModelAttribute(name = "usuarioForm") UsuarioForm usuarioForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "/inicio/registro";
		}
		model.addAttribute("usuarioForm", new UsuarioForm());
		USERS usuario = new USERS();
		usuario.setUSERNAME(usuarioForm.getUSERNAME());
		usuario.setPASSWORD(usuarioForm.getPASSWORD());
		usuario.setENABLED("Y");
		System.out.println(usuario.getUSERNAME());
		try {
			usuarioService.guardarUsuario(usuario);
		}catch(Exception e) {
			e.printStackTrace();
			return "/inicio/registro";
		}
		return "redirect:/";
	}
}
