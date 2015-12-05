package br.com.alugometro.controller.anuncio;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.alugometro.dto.AnuncioCadastroDTO;
import br.com.alugometro.service.AnuncioService;
import br.com.alugometro.service.CidadeService;
import br.com.alugometro.service.TipoAcomodacaoService;
import br.com.alugometro.service.TipoImovelService;

@Controller
@RequestMapping("/anuncio")
public class AnuncioInserirController extends AbstractAnuncioController{

	@Autowired private ServletContext servletContext;
	
	@Autowired
	public AnuncioInserirController(AnuncioService anuncioService, TipoImovelService tipoImovelService,TipoAcomodacaoService tipoAcomodacaoService, CidadeService cidadeService) {
		super(anuncioService, tipoImovelService, tipoAcomodacaoService, cidadeService);
	}

	@RequestMapping(path = "/inserir" , method = RequestMethod.GET)
	public ModelAndView inserir() {	
		return new ModelAndView("anuncio/inserir", "anuncio", new AnuncioCadastroDTO());
	}

	@RequestMapping(path = "/inserir", method = RequestMethod.POST)
	public ModelAndView inserir(@Valid @ModelAttribute("anuncio") AnuncioCadastroDTO anuncioDTO,
								BindingResult result,
								final RedirectAttributes redirectAttributes,
								@RequestPart("imagem") MultipartFile imagem){
		
		if(result.hasErrors()){
			return new ModelAndView("anuncio/inserir");
		}
		if(!imagem.isEmpty()){
			validarImagem(imagem);
		}
		
		try {
			saveImage("teste" + ".jpg", imagem);
		} catch (IOException e) {
			return new ModelAndView("anuncio/inserir");
		}
		
		redirectAttributes.addFlashAttribute("mensagem", "Anuncio criado com sucesso");
		anuncioService.inserir(anuncioDTO);
		return new ModelAndView("redirect:/");
	}
	
	private void saveImage(String filename, MultipartFile image)
			throws RuntimeException, IOException {
			try {
				//System.out.println("CONTEXTO: " + servletContext.getContextPath());
				
				File file = new File(/*servletContext.getRealPath("/") + "/" + filename*/"C:\\Alugometro\\" + filename);
			
				//FileUtils.writeByteArrayToFile(file, image.getBytes());
			
			} catch (Exception e) {
				throw e;
			}
		}
	
	public void validarImagem(MultipartFile imagem) {
		if (!imagem.getContentType().equals("image/jpeg")) {
			throw new RuntimeException("Only JPG images are accepted");
		}
	}
	
//	@RequestMapping(path = "/inserir/imagem", method = RequestMethod.POST)
//	public ModelAndView inserirImagem(){
//		
//	}
}
