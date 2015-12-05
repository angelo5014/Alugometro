package br.com.alugometro.service;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.alugometro.dao.FotoDAO;
import br.com.alugometro.domain.Foto;

@Service
public class AnuncioImagemService {
	
	private FotoDAO fotoDAO;
	
	private final String CAMINHO_BASE = "C:\\Alugometro\\";
	
	@Autowired
	public AnuncioImagemService(FotoDAO fotoDAO) {
		this.fotoDAO = fotoDAO;
	}
	
	public boolean validarFormatoImagem(MultipartFile imagem) {
		if (imagem.getContentType().equals("image/jpeg")) {
			return true;
		}
		return false;
	}
	
	public Foto saveImage(String filename, MultipartFile image)
			throws RuntimeException, IOException {
			try {
				String caminhoFinal = CAMINHO_BASE + filename;
				
				File file = new File(caminhoFinal);
			
				FileUtils.writeByteArrayToFile(file, image.getBytes());
			
				return fotoDAO.salvar(new Foto(caminhoFinal));
				
			} catch (Exception e) {
				throw e;
			}
		}
	
}
