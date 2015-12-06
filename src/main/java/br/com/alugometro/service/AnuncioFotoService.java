package br.com.alugometro.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

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
public class AnuncioFotoService {
	
	private FotoDAO fotoDAO;
	private AnuncioFotoDAO anuncioFotoDAO;
	
	private final String CAMINHO_RESOURCES_SERVIDOR = "/anuncioImagens/"; 
	private final String CAMINHO_SISTEMA = "src/main/resources/static/anuncioImagens/";

	
	@Autowired
	ServletContext context;
	
	@Autowired
	public AnuncioFotoService(FotoDAO fotoDAO, AnuncioFotoDAO anuncioFotoDAO) {
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
		if (!imagem.getContentType().equals("image/jpeg")) {
			throw new FormatoDeImagemNaoSuportadoException();
		}
	}
	
	public void validarFormatoVariasImagensEInserir(MultipartFile[] imagens, Long idAnuncio, Long idUsuario) throws FormatoDeImagemNaoSuportadoException, ImagemNaoRegistradaException{
		for (MultipartFile imagem : imagens) {
			
			validarFormatoImagem(imagem);
			
			Foto foto = salvarImagem(imagem.getOriginalFilename(), idUsuario, imagem);
			relacionarFotoComAnuncio(foto, idAnuncio);
		}
	}
	
	private AnuncioFoto relacionarFotoComAnuncio(Foto foto, Long idAnuncio) {
		AnuncioFoto anuncioFoto = new AnuncioFoto();
		anuncioFoto.setAnuncio(new Anuncio(idAnuncio));
		anuncioFoto.setFoto(foto);
		return anuncioFotoDAO.salvar(anuncioFoto);
	}

	public Foto salvarImagem(String filename, Long idUsuario,MultipartFile imagem) throws ImagemNaoRegistradaException{
				String caminhoFinalNoSistema = CAMINHO_SISTEMA + idUsuario + "/" + filename;
				String caminhoFinalNoServidor = CAMINHO_RESOURCES_SERVIDOR + idUsuario + "/" + filename;
				
				File file = new File(caminhoFinalNoSistema);
			
				try {
					FileUtils.writeByteArrayToFile(file, imagem.getBytes());
				} catch (IOException e) {
					throw new ImagemNaoRegistradaException();
				}
			
				return fotoDAO.salvar(new Foto(caminhoFinalNoServidor));
	}
	
}
