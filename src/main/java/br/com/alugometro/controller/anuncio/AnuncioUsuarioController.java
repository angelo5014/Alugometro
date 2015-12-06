package br.com.alugometro.controller.anuncio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.alugometro.service.AnuncioService;
import br.com.alugometro.service.CidadeService;
import br.com.alugometro.service.TipoAcomodacaoService;
import br.com.alugometro.service.TipoImovelService;
import br.com.alugometro.service.UsuarioService;

@Controller
@RequestMapping(path = "/anuncio")
public class AnuncioUsuarioController extends AbstractAnuncioController{
	
	@Autowired
	public AnuncioUsuarioController(
			AnuncioService anuncioService,
			TipoImovelService tipoImovelService,
			TipoAcomodacaoService tipoAcomodacaoService,
			CidadeService cidadeService,
			UsuarioService usuarioService) {
		super(anuncioService, tipoImovelService, tipoAcomodacaoService, cidadeService, usuarioService);
	}

	@RequestMapping(path = "/usuario/{id}", method = RequestMethod.GET)
	public ModelAndView listarAnunciosDoUsuario(@PathVariable("id") Long idUsuario
												) {
		if(usuarioService.obterIdDoUsuarioLogado() == idUsuario){
		return new ModelAndView("anuncio/listar-usuario", "anuncios", anuncioService.buscarAnunciosDoUsuario(idUsuario));
		}else{
			//redirectAttributes.addFlashAttribute("mensagem", "Voce não tem permissão para isso");
			return new ModelAndView("redirect:/");
		}
	}
	
	
	
}
