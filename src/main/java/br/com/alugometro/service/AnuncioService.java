package br.com.alugometro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alugometro.dao.AnuncioDAO;
import br.com.alugometro.domain.Anuncio;
import br.com.alugometro.dto.AnuncioCadastroDTO;
import br.com.alugometro.dto.AnuncioResumoDTO;
import br.com.alugometro.mapper.AnuncioMapper;

@Service
public class AnuncioService {

	private AnuncioDAO anuncioDAO;

	@Autowired
	public AnuncioService(AnuncioDAO anuncioDAO) {
		this.anuncioDAO = anuncioDAO;
	}
	
	public AnuncioCadastroDTO buscarPorID(Long idAnuncio) {
		return AnuncioMapper.paraDTO(anuncioDAO.encontrarPorId(idAnuncio));
	}
	
	public List<AnuncioResumoDTO> listarTodos() {
		List<Anuncio> anuncios = anuncioDAO.listarTodos();
		
		List<AnuncioResumoDTO> anunciosResumoDTO = new ArrayList<AnuncioResumoDTO>();
		for (Anuncio anuncio : anuncios) {
			anunciosResumoDTO.add(new AnuncioResumoDTO(anuncio));
		}
		
		return anunciosResumoDTO;
	}
	
	public AnuncioCadastroDTO inserir(AnuncioCadastroDTO dto){
		anuncioDAO.salvar(AnuncioMapper.gerarNovaEntidade(dto));
		return dto;
	}
}
