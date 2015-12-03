package br.com.alugometro.controller.anuncio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.alugometro.dto.AnuncioDTO;
import br.com.alugometro.service.AnuncioService;

@Controller
@RequestMapping("/anuncio")
public class AnuncioInserirController {

	private AnuncioService anuncioService;

	@Autowired
	public AnuncioInserirController(AnuncioService anuncioService) {
		this.anuncioService = anuncioService;
	}
	
	@RequestMapping(path = "/inserir" , method = RequestMethod.GET)
	public ModelAndView inserir() {	
		return new ModelAndView("anuncio/inserir", "anuncio", new AnuncioDTO());
	}
	
}
