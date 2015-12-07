package br.com.alugometro.controller.anuncio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.alugometro.dto.AnuncioResumoDTO;
import br.com.alugometro.dto.AnuncioSegurancaDTO;
import br.com.alugometro.exception.UsuarioNaoEncontradoException;
import br.com.alugometro.service.AnuncioService;
import br.com.alugometro.service.CidadeService;
import br.com.alugometro.service.TipoAcomodacaoService;
import br.com.alugometro.service.TipoImovelService;
import br.com.alugometro.service.UsuarioService;

@Controller
@RequestMapping("/anuncio")
public class AnuncioDesativarController extends AbstractAnuncioController {
	

	@Autowired
	public AnuncioDesativarController(AnuncioService anuncioService,
									TipoImovelService tipoImovelService,
									TipoAcomodacaoService tipoAcomodacaoService,
									CidadeService cidadeService,
									UsuarioService usuarioService) {
		super(anuncioService, tipoImovelService, tipoAcomodacaoService, cidadeService, usuarioService);
	}
	@RequestMapping(path = "/desativar", method = RequestMethod.POST)
	public ModelAndView desativarAnuncio(@ModelAttribute AnuncioSegurancaDTO anuncioSegurancaDTO,
										final RedirectAttributes redirectAttributes){

		Long idUsuarioLogado = usuarioService.obterIdDoUsuarioLogado();
		Long idUsuarioEsperado = null;
		try {
			idUsuarioEsperado = usuarioService.buscarPorId(anuncioSegurancaDTO.getIdUsuario()).getIdUsuario();
		} catch (UsuarioNaoEncontradoException e) {
			e.printStackTrace();
		}
		
			if(idUsuarioLogado == idUsuarioEsperado){
				anuncioService.desativarAnuncio(anuncioSegurancaDTO.getIdAnuncio());
			}else{
				redirectAttributes.addFlashAttribute("mensagem", "Voce não tem permissão para isso");
				return new ModelAndView("redirect:/");
			}
		return new ModelAndView("redirect:/anuncio");
	}
	
}
