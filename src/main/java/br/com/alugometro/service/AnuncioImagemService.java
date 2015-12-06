package br.com.alugometro.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.alugometro.dao.AnuncioFotoDAO;
import br.com.alugometro.dao.FotoDAO;
import br.com.alugometro.domain.Anuncio;
import br.com.alugometro.domain.AnuncioFoto;
import br.com.alugometro.domain.Foto;
import br.com.alugometro.dto.AnuncioFotoDTO;
import br.com.alugometro.exception.FormatoDeImagemNaoSuportadoException;
import br.com.alugometro.exception.ImagemNaoRegistradaException;

@Service
public class AnuncioImagemService {
	
	private FotoDAO fotoDAO;
	private AnuncioFotoDAO anuncioFotoDAO;
	
	private final String CAMINHO_BASE = "C:\\Alugometro\\";
	
	@Autowired
	public AnuncioImagemService(FotoDAO fotoDAO, AnuncioFotoDAO anuncioFotoDAO) {
		this.fotoDAO = fotoDAO;
		this.anuncioFotoDAO = anuncioFotoDAO;
	}
	
	public List<AnuncioFotoDTO> listarPorIdAnuncio(Long idAnuncio) {
		List<AnuncioFoto> anuncioFotos = anuncioFotoDAO.encontrarPorIdAnuncio(idAnuncio);
		List<AnuncioFotoDTO> anuncioFotosDTO = new ArrayList<AnuncioFotoDTO>();
		
		for (AnuncioFoto anuncioFoto : anuncioFotos) {
			anuncioFotosDTO.add(new AnuncioFotoDTO(anuncioFoto));
		}
		
		return anuncioFotosDTO;
	}
	
	public void validarFormatoImagem(MultipartFile imagem) throws FormatoDeImagemNaoSuportadoException {
		if (!imagem.getContentType().equals("image/*")) {
			throw new FormatoDeImagemNaoSuportadoException();
		}
	}
	
	public void validarFormatoVariasImagensEInserir(MultipartFile[] imagens, Long idAnuncio) throws FormatoDeImagemNaoSuportadoException, ImagemNaoRegistradaException{
		for (MultipartFile imagem : imagens) {
			
			validarFormatoImagem(imagem);
			
			Foto foto = salvarImagem(imagem.getOriginalFilename(), imagem);
			relacionarFotoComAnuncio(foto, idAnuncio);
		}
	}
	
	private AnuncioFoto relacionarFotoComAnuncio(Foto foto, Long idAnuncio) {
		AnuncioFoto anuncioFoto = new AnuncioFoto();
		anuncioFoto.setAnuncio(new Anuncio(idAnuncio));
		anuncioFoto.setFoto(foto);
		return anuncioFotoDAO.salvar(anuncioFoto);
	}

	public Foto salvarImagem(String filename, MultipartFile image) throws ImagemNaoRegistradaException{
				String caminhoFinal = CAMINHO_BASE + filename;
				
				File file = new File(caminhoFinal);
			
				try {
					FileUtils.writeByteArrayToFile(file, image.getBytes());
				} catch (IOException e) {
					throw new ImagemNaoRegistradaException();
				}
			
				return fotoDAO.salvar(new Foto(caminhoFinal));
	}
	
}
