package br.com.alugometro.controller.anuncio;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.alugometro.dto.AnuncioFotoDTO;
import br.com.alugometro.service.AnuncioFotoService;
import br.com.alugometro.service.AnuncioService;
import br.com.alugometro.service.CidadeService;
import br.com.alugometro.service.TipoAcomodacaoService;
import br.com.alugometro.service.TipoImovelService;
import br.com.alugometro.service.UsuarioService;

@Controller
@RequestMapping("/anuncio")
public class AnuncioExibirController extends AbstractAnuncioController {

	private AnuncioFotoService anuncioFotoService;

	@Autowired
	public AnuncioExibirController(
			AnuncioService anuncioService,
			AnuncioFotoService anuncioFotoService,
			TipoImovelService tipoImovelService,
			TipoAcomodacaoService tipoAcomodacaoService, 
			CidadeService cidadeService,
			UsuarioService usuarioService) {
		
		super(anuncioService, tipoImovelService, tipoAcomodacaoService, cidadeService, usuarioService);
		this.anuncioFotoService = anuncioFotoService; 
	}

	@RequestMapping(path = "/{idAnuncio}", method = RequestMethod.GET)
	public ModelAndView exibir(@PathVariable("idAnuncio") Long idAnuncio) {

		ModelAndView model = new ModelAndView("anuncio/exibir", "anuncio", anuncioService.buscarPorId(idAnuncio));
		model.addObject("anuncioFotos", listaFotos(idAnuncio));
		return model;
	}

	private List<AnuncioFotoDTO> listaFotos(Long idAnuncio) {
		return anuncioFotoService.listarPorIdAnuncio(idAnuncio);
	}

	@ResponseBody
	@RequestMapping(path = "/rest/{idAnuncio}")
	public String buscarAnuncioFotos(@PathVariable("idAnuncio") Long idAnuncio) {
		
		JSONArray anuncioFotosArray = new JSONArray();
		JSONObject anuncioFotos = new JSONObject();
		
		for (AnuncioFotoDTO anuncioFotoDTO : listaFotos(idAnuncio)) {
			JSONObject userJSON = new JSONObject();
			userJSON.put("url", anuncioFotoDTO.getUrlFoto());
			anuncioFotos.put("fotos", anuncioFotosArray.put(userJSON));
		}
		
		return anuncioFotos.toString();
	}
	
}
