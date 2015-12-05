package br.com.alugometro.controller.anuncio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import br.com.alugometro.domain.Cidade;
import br.com.alugometro.domain.TipoAcomodacao;
import br.com.alugometro.domain.TipoImovel;
import br.com.alugometro.service.AnuncioService;
import br.com.alugometro.service.CidadeService;
import br.com.alugometro.service.TipoAcomodacaoService;
import br.com.alugometro.service.TipoImovelService;

@Controller
public abstract class AbstractAnuncioController {

	protected AnuncioService anuncioService;
	protected TipoImovelService tipoImovelService;
	protected TipoAcomodacaoService tipoAcomodacaoService;
	protected CidadeService cidadeService;

	@Autowired
	public AbstractAnuncioController(AnuncioService anuncioService,
									TipoImovelService tipoImovelService,
									TipoAcomodacaoService tipoAcomodacaoService,
									CidadeService cidadeService) {
		this.anuncioService = anuncioService;
		this.tipoImovelService = tipoImovelService;
		this.cidadeService = cidadeService;
		this.tipoAcomodacaoService = tipoAcomodacaoService;
	}

	@ModelAttribute("tiposImoveis")
    public List<TipoImovel> comboTiposImoveis() {
        return tipoImovelService.listarTodos();
    }
	
	@ModelAttribute("tiposAcomodacoes")
    public List<TipoAcomodacao> comboTiposAcomodacoes() {
        return tipoAcomodacaoService.listarTodos();
    }
	
	@ModelAttribute("cidades")
    public List<Cidade> comboCidade() {
        return cidadeService.listarTodos();
    }
	
}
