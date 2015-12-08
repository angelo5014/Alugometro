package br.com.alugometro.controller.usuario;

import java.util.UUID;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.alugometro.dto.RedefinirSenhaDTO;
import br.com.alugometro.dto.TokenDTO;
import br.com.alugometro.dto.UsuarioDTO;
import br.com.alugometro.email.AlugometroEmailSender;
import br.com.alugometro.exception.AbstractException;
import br.com.alugometro.exception.TokenInvalidoException;
import br.com.alugometro.exception.UsuarioNaoEncontradoException;
import br.com.alugometro.service.TokenService;
import br.com.alugometro.service.UsuarioSenhaService;
import br.com.alugometro.service.UsuarioService;

@Controller
@RequestMapping("/recuperarsenha")
public class UsuarioRecuperarSenhaController {

	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	UsuarioSenhaService senhaService;
	
    AlugometroEmailSender emailSender = new AlugometroEmailSender();
	
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
			attributes.addFlashAttribute("mensagem", e.getMensagem());
			return new ModelAndView("redirect:/");
		}
		
		if(usuario == null){
			attributes.addFlashAttribute("mensagem", "Usuário não existe.");
			return new ModelAndView("redirect:/");
		}
		
		String token = UUID.randomUUID().toString();
		
		TokenDTO tokenDTO = new TokenDTO();
		tokenDTO.setToken(token);
		tokenDTO.setUsuario(usuario);
		
		this.tokenService.salvarToken(tokenDTO);
		
		StringBuilder mensagem = new StringBuilder();
		mensagem.append("Olá, " + usuario.getNome().toUpperCase() + ".");
		mensagem.append("<br />");
		mensagem.append("Segue link para redefinição de senha:");
		mensagem.append("<a href='http://localhost:8082/recuperarsenha/verificartoken?id=");
		mensagem.append(usuario.getIdUsuario());
		mensagem.append("&token=");
		mensagem.append(token);
		mensagem.append("'>Redefinir Senha</a>");
		mensagem.append("<br />");
		mensagem.append("Att. Equipe Alugômetro");
		
		try {
			emailSender.sendSSLMessage(usuario.getEmail(), "Redefinir Senha", mensagem.toString());
			attributes.addFlashAttribute("mensagem", "Lhe enviamos um email para redefinição de sua senha!");
		} catch (MessagingException e) {
			attributes.addFlashAttribute("mensagem", "Não foi possível enviar o email de redefiniçao de senha, tente novamente mais tarde.");
		}
		
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(path = "/verificartoken", method = RequestMethod.GET)
	public ModelAndView verificarToken(@RequestParam(value = "id", required = true) Long idUsuario,
										@RequestParam(value = "token", required = true) String tokenUsuario,
										RedirectAttributes attributes){
		
		UsuarioDTO usuario = null;
		
		try {
			usuario = this.usuarioService.buscarPorId(idUsuario);
		} catch (UsuarioNaoEncontradoException e) {
			attributes.addFlashAttribute("mensagem", e.getMensagem());
		}
		
		TokenDTO token = this.tokenService.buscarToken(tokenUsuario);
		
		if(token.getToken().equals(tokenUsuario)){
			try {
				RedefinirSenhaDTO redefinirSenha = new RedefinirSenhaDTO();
				redefinirSenha.setIdUsuario(usuario.getIdUsuario());
				this.tokenService.invalidarToken(token);
				return new ModelAndView("usuario/redefinirsenha", "redefinirSenha", redefinirSenha);
			} catch (TokenInvalidoException e) {
				attributes.addFlashAttribute("mensagem", e.getMensagem());
				return new ModelAndView("redirect:/recuperarsenha");
			}
		}
		
		return new ModelAndView("redirect:/recuperarsenha");
	}
	
	@RequestMapping(path = "/redefinirsenha", method = RequestMethod.POST)
	public ModelAndView redefinirSenha(@Valid @ModelAttribute("redefinirSenha") RedefinirSenhaDTO redefinirSenha,
										BindingResult result,
										RedirectAttributes redirectAttributes){
		
		if(!senhaService.confirmarSenha(redefinirSenha.getSenha(), redefinirSenha.getConfirmacaoSenha())){
			result.addError(new FieldError("redefinirSenha", "senha", "Confirmação incorreta"));
		}
		
		if(result.hasErrors()){
			return new ModelAndView("usuario/redefinirSenha", "redefinirSenha", redefinirSenha);
		}
		
		UsuarioDTO usuario = null;
		
		try {
			usuario = usuarioService.buscarPorId(redefinirSenha.getIdUsuario());
			usuario.setSenha(redefinirSenha.getSenha());
		} catch (UsuarioNaoEncontradoException e) {
			redirectAttributes.addFlashAttribute("mensagem", e.getMensagem());
			return new ModelAndView("redirect:/");
		}
		
		usuarioService.salvar(usuario);
		
		redirectAttributes.addFlashAttribute("mensagem", "Senha alterada!");

		return new ModelAndView("redirect:/");
	}
	
}
