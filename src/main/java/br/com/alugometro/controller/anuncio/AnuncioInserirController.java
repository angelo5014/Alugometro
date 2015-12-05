package br.com.alugometro.controller.anuncio;

import java.io.IOException;

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
import br.com.alugometro.exception.AbstractException;
import br.com.alugometro.exception.MultiplosUsuariosEncontradosException;
import br.com.alugometro.service.AnuncioImagemService;
import br.com.alugometro.service.AnuncioService;
import br.com.alugometro.service.CidadeService;
import br.com.alugometro.service.TipoAcomodacaoService;
import br.com.alugometro.service.TipoImovelService;

@Controller
@RequestMapping("/anuncio")
public class AnuncioInserirController extends AbstractAnuncioController{
	
	private AnuncioImagemService anuncioImagemService;
	
	@Autowired
	public AnuncioInserirController(AnuncioService anuncioService,
									TipoImovelService tipoImovelService,
									TipoAcomodacaoService tipoAcomodacaoService,
									CidadeService cidadeService,
									AnuncioImagemService anuncioImagemService) {
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
		
		if(result.hasErrors()){
			return new ModelAndView("anuncio/inserir");
		}
		
		if(imagem.getSize() != 0){
			try{
				anuncioImagemService.validarFormatoImagem(imagem);
			}catch (MultiplosUsuariosEncontradosException e) {
				result.addError(new FieldError("anuncio", "idFotoCapa", e.getMensagem()));
				return new ModelAndView("anuncio/inserir");
			}
		}else{
			result.addError(new FieldError("anuncio", "idFotoCapa", "Por favor insira uma imagem"));
			return new ModelAndView("anuncio/inserir");
		}
		
		try {
			anuncioService.inserir(anuncioDTO, imagem);
			redirectAttributes.addFlashAttribute("mensagem", "Anuncio criado com sucesso");
			return new ModelAndView("redirect:/home");
		} catch (IOException | RuntimeException | AbstractException e) {
			return new ModelAndView("anuncio/inserir");
		}
	}
}
