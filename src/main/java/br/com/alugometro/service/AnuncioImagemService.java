package br.com.alugometro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alugometro.dao.FotoDAO;

@Service
public class AnuncioImagemService {
	
	private FotoDAO fotoDAO;
	
	@Autowired
	public AnuncioImagemService(FotoDAO fotoDAO) {
		this.fotoDAO = fotoDAO;
	}
}
