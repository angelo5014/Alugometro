package br.com.alugometro.controller.anuncio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.alugometro.exception.AbstractException;
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

	@RequestMapping(path = "/usuario", method = RequestMethod.POST)
	public ModelAndView listarAnunciosDoUsuario(@ModelAttribute("email") String email ) throws AbstractException {
		return new ModelAndView("anuncio/listar-usuario", "anuncios", anuncioService.buscarAnunciosDoUsuarioEmail(email));
	}
	
	
	
}
