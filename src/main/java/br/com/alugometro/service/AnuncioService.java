package br.com.alugometro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alugometro.dao.AnuncioDAO;
import br.com.alugometro.dto.AnuncioDTO;
import br.com.alugometro.mapper.AnuncioMapper;

@Service
public class AnuncioService {

	private AnuncioDAO anuncioDAO;

	@Autowired
	public AnuncioService(AnuncioDAO anuncioDAO) {
		this.anuncioDAO = anuncioDAO;
	}
	
	public AnuncioDTO buscarPorID(Long idAnuncio) {
		return AnuncioMapper.paraDTO(anuncioDAO.encontrarPorId(idAnuncio));
	}
	
	public AnuncioDTO inserir(AnuncioDTO anuncioDTO){
		anuncioDAO.salvar(AnuncioMapper.gerarNovaEntidade(anuncioDTO));
		return anuncioDTO;
	}
	
}
