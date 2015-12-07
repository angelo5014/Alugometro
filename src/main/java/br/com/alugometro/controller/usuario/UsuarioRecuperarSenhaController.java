package br.com.alugometro.controller.usuario;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.alugometro.dto.TokenDTO;
import br.com.alugometro.dto.UsuarioDTO;
import br.com.alugometro.exception.AbstractException;
import br.com.alugometro.service.TokenService;
import br.com.alugometro.service.UsuarioService;

@Controller
@RequestMapping("/usuario/recuperarsenha")
public class UsuarioRecuperarSenhaController {

	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	TokenService tokenService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView viewRecuperarSenha(){
		return new ModelAndView("recuperarsenha", "usuario", new UsuarioDTO());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView enviarEmailRecuperacao(HttpServletRequest request,
												@RequestParam("email") String email,
												RedirectAttributes attributes){
		UsuarioDTO usuario = null;
		
		try {
			usuario = this.usuarioService.buscarPorEmail(email);
		} catch (AbstractException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(usuario == null){
			attributes.addFlashAttribute("mensagem", "Usuário não existe.");
			return new ModelAndView("redirect:/recuperarsenha");
		}
		
		String token = UUID.randomUUID().toString();
		
		TokenDTO tokenDTO = new TokenDTO(usuario, token);
		
		this.tokenService.salvarToken(tokenDTO);
		
		
		return new ModelAndView("redirect:/usuario/recuperarsenha");
	}
	
}
