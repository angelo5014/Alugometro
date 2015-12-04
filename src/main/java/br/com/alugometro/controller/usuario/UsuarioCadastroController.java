package br.com.alugometro.controller.usuario;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.alugometro.dto.UsuarioDTO;
import br.com.alugometro.service.UsuarioService;

@Controller
@RequestMapping("/usuario/inserir")
public class UsuarioCadastroController extends AbstractUsuarioController{

	@Autowired
	public UsuarioCadastroController(UsuarioService usuarioService) {
		super(usuarioService);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView viewCadastro(){
		return new ModelAndView("usuario/inserir", "usuario", new UsuarioDTO());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid @ModelAttribute("usuario") UsuarioDTO usuarioDTO,
									BindingResult result,
									final RedirectAttributes redirectAttributes){
		if(result.hasErrors()){
			return new ModelAndView("usuario/inserir");
		}
		
		redirectAttributes.addFlashAttribute("mensagem", "Cadastrado com sucesso!");
		usuarioService.salvar(usuarioDTO);

		return new ModelAndView("redirect:/");
		
	}
}
