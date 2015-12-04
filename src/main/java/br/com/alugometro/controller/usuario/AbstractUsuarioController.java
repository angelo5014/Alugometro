package br.com.alugometro.controller.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.alugometro.service.UsuarioService;

@Controller
public class AbstractUsuarioController {
	
	protected UsuarioService usuarioService;
	
	@Autowired
	public AbstractUsuarioController(UsuarioService usuarioService){
		this.usuarioService = usuarioService;
	}
}
