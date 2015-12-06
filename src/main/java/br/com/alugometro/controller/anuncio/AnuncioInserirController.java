package br.com.alugometro.controller.anuncio;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.alugometro.dto.AnuncioDTO;
import br.com.alugometro.exception.FormatoDeImagemNaoSuportadoException;
import br.com.alugometro.exception.ImagemNaoRegistradaException;
import br.com.alugometro.service.AnuncioFotoService;
import br.com.alugometro.service.AnuncioService;
import br.com.alugometro.service.CidadeService;
import br.com.alugometro.service.TipoAcomodacaoService;
import br.com.alugometro.service.TipoImovelService;

@Controller
@RequestMapping("/anuncio")
public class AnuncioInserirController extends AbstractAnuncioController{
	
	private AnuncioFotoService anuncioImagemService;
	
	@Autowired
	public AnuncioInserirController(
			AnuncioService anuncioService,
			TipoImovelService tipoImovelService,
			TipoAcomodacaoService tipoAcomodacaoService,
			CidadeService cidadeService) {
		
		super(anuncioService, tipoImovelService, tipoAcomodacaoService, cidadeService);
		this.anuncioImagemService = anuncioImagemService;
	}

	@RequestMapping(path = "/inserir" , method = RequestMethod.GET)
	public ModelAndView inserir() {	
		return new ModelAndView("anuncio/inserir", "anuncio", new AnuncioDTO());
	}

	@RequestMapping(path = "/inserir", method = RequestMethod.POST)
	public ModelAndView inserir(@Valid @ModelAttribute("anuncio") AnuncioDTO anuncioDTO,
								BindingResult result,
								final RedirectAttributes redirectAttributes,
								@RequestParam("imagem") MultipartFile imagem,
								@RequestParam("imagens") MultipartFile[] imagens){
		
		final boolean IMAGEM_CAPA_NULA = imagem.getSize() == 0;	
		final boolean IMAGENS_OPCIONAIS_VAZIAS = imagens.length == 0;
		
		if(result.hasErrors()){
			return new ModelAndView("anuncio/inserir");
		}
		
		if(IMAGEM_CAPA_NULA){
			result.addError(new FieldError("anuncio", "idFotoCapa", "Por favor insira uma imagem"));
			return new ModelAndView("anuncio/inserir");
		}
		
		try {
			anuncioImagemService.validarFormatoImagem(imagem);
		} catch (FormatoDeImagemNaoSuportadoException e) {
			result.addError(new FieldError("anuncio", "idFotoCapa", e.getMensagem()));
			return new ModelAndView("anuncio/inserir");
		}
		
			Long idAnuncio = anuncioService.inserir(anuncioDTO, imagem).getIdAnuncio();
			
		if(!IMAGENS_OPCIONAIS_VAZIAS){
			try {
				anuncioImagemService.validarFormatoVariasImagensEInserir(imagens, idAnuncio);
			} catch (FormatoDeImagemNaoSuportadoException | ImagemNaoRegistradaException e) {
				result.addError(new FieldError("anuncio", "idFotoCapa", e.getMensagem()));
			}
		}
			
		redirectAttributes.addFlashAttribute("mensagem", "Anuncio criado com sucesso");
		return new ModelAndView("redirect:/home");
	}
}
