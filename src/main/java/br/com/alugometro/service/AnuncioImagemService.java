package br.com.alugometro.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.alugometro.dao.FotoDAO;
import br.com.alugometro.domain.Foto;

@Service
public class AnuncioImagemService {
	
	private FotoDAO fotoDAO;
	
	@Autowired
	public AnuncioImagemService(FotoDAO fotoDAO) {
		this.fotoDAO = fotoDAO;
	}

	public Long inserirImagemCapa(MultipartFile imagem){
		String caminho;
		if(!imagem.isEmpty()){
			if (!imagem.getContentType().equals("image/jpeg")) {
					throw new RuntimeException("Only JPG images are accepted");
			}
		}
		try {
			caminho = saveImage("teste" + ".jpg", imagem);
		} catch (IOException e) {
			return null;
		}
		
		Foto foto = new Foto();
		foto.setUrl(caminho);
		
		fotoDAO.salvar(foto);
		
	}	
	
	private String saveImage(String nomeArquivo, MultipartFile imagem)
			throws RuntimeException, IOException {
			try {
				//System.out.println("CONTEXTO: " + servletContext.getContextPath());
				
				File arquivo = new File(/*servletContext.getRealPath("/") + "/" + filename*/"C:\\Alugometro\\" + nomeArquivo);
				return arquivo.getAbsolutePath();
				//FileUtils.writeByteArrayToFile(file, image.getBytes());
			
			} catch (Exception e) {
				throw e;
			}
		}
	
}
