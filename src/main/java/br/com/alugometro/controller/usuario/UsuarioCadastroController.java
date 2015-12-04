package br.com.alugometro.controller.usuario;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.alugometro.dto.UsuarioDTO;
import br.com.alugometro.service.UsuarioSenhaService;
import br.com.alugometro.service.UsuarioService;

@Controller
@RequestMapping("/usuario/inserir")
public class UsuarioCadastroController extends AbstractUsuarioController{

	private UsuarioSenhaService senhaService;
	
	@Autowired
	public UsuarioCadastroController(UsuarioService usuarioService, UsuarioSenhaService senhaService) {
		super(usuarioService);
		this.senhaService = senhaService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView viewCadastro(){
		return new ModelAndView("usuario/inserir", "usuario", new UsuarioDTO());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ConditionalOnExpression("${usuario.senhaConfirmada()}")
	public ModelAndView cadastrar(@Valid @ModelAttribute("usuario") UsuarioDTO usuarioDTO,
									BindingResult result,
									final RedirectAttributes redirectAttributes){
		
		if(!senhaService.confirmarSenha(usuarioDTO.getSenha(), usuarioDTO.getConfirmacaoSenha())){
			result.addError(new FieldError("usuario", "senha", "Confirmação incorreta"));
		}
		
		if(result.hasErrors()){
			return new ModelAndView("usuario/inserir");
		}
		
		redirectAttributes.addFlashAttribute("mensagem", "Cadastrado com sucesso!");
		
		usuarioService.salvar(usuarioDTO);

		return new ModelAndView("redirect:/");
	}
}
