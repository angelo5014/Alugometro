package br.com.alugometro.controller.anuncio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import br.com.alugometro.domain.TipoImovel;
import br.com.alugometro.service.AnuncioService;
import br.com.alugometro.service.TipoImovelService;

@Controller
public abstract class AbstractAnuncioController {

	protected AnuncioService anuncioService;
	protected TipoImovelService tipoImovelService;

	@Autowired
	public AbstractAnuncioController(AnuncioService anuncioService, TipoImovelService tipoImovelService) {
		this.anuncioService = anuncioService;
		this.tipoImovelService = tipoImovelService;
	}

	@ModelAttribute("tiposImoveis")
    public List<TipoImovel> comboTiposImoveis() {
        return tipoImovelService.listarTodos();
    }
	
}
