package br.com.alugometro.controller.anuncio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.alugometro.service.AnuncioService;
import br.com.alugometro.service.CidadeService;
import br.com.alugometro.service.TipoAcomodacaoService;
import br.com.alugometro.service.TipoImovelService;

@Controller
@RequestMapping("/anuncio")
public class AnuncioExibirController extends AbstractAnuncioController {

	@Autowired
	public AnuncioExibirController(AnuncioService anuncioService, TipoImovelService tipoImovelService,
			TipoAcomodacaoService tipoAcomodacaoService, CidadeService cidadeService) {
		super(anuncioService, tipoImovelService, tipoAcomodacaoService, cidadeService);
	}
	
	@RequestMapping(path = "/{idAnuncio}",method=RequestMethod.GET)
	public ModelAndView exibir(@PathVariable("idAnuncio") Long idAnuncio) {
		return new ModelAndView("anuncio/exibir", "anuncio" , anuncioService.buscarPorID(idAnuncio));
	}
	
}
