package br.com.alugometro.controller.anuncio;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.alugometro.service.AnuncioService;
import br.com.alugometro.service.CidadeService;
import br.com.alugometro.service.TipoAcomodacaoService;
import br.com.alugometro.service.TipoImovelService;
import br.com.alugometro.service.UsuarioService;

@Controller
@RequestMapping("/anuncio")
public class AnuncioListarController extends AbstractAnuncioController {

	@Autowired
	public AnuncioListarController(AnuncioService anuncioService, TipoImovelService tipoImovelService,
			TipoAcomodacaoService tipoAcomodacaoService, CidadeService cidadeService,
			UsuarioService usuarioService) {
		super(anuncioService, tipoImovelService, tipoAcomodacaoService, cidadeService, usuarioService);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar() {
		return new ModelAndView("anuncio/listar", "anuncios", anuncioService.listarTodos());
	}
	
	@RequestMapping(path = "/listarPorCidade", method=RequestMethod.GET)
	public ModelAndView listarPorCidade(@RequestParam("cidade") String cidade) {
		return new ModelAndView("anuncio/listar", "anuncios", anuncioService.listarPorCidade(cidade));
	}
	
	@RequestMapping(path = "/listarPorBuscaDetalhada", method=RequestMethod.GET)
	public ModelAndView listarPorBuscaDetalhada(
			@RequestParam("precoMenor") BigDecimal precoMenor, 
			@RequestParam("precoMaior") BigDecimal precoMaior,
			@RequestParam("idTipoImovel") Long idTipoImovel,
			@RequestParam("idTipoAcomodacao") Long idTipoAcomodacao,
			@RequestParam("idCidade") Long idCidade) {
		
		return new ModelAndView("anuncio/listar", "anuncios", anuncioService.listarPorBuscaDetalhada(
				precoMenor, precoMaior, idTipoImovel, idTipoAcomodacao, idCidade));
	}
	
}
