package br.com.alugometro.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.alugometro.dao.AnuncioDAO;
import br.com.alugometro.domain.Anuncio;
import br.com.alugometro.domain.Foto;
import br.com.alugometro.dto.AnuncioDTO;
import br.com.alugometro.dto.AnuncioResumoDTO;
import br.com.alugometro.exception.AbstractException;
import br.com.alugometro.mapper.AnuncioMapper;

@Service
public class AnuncioService {

	private AnuncioDAO anuncioDAO;
	private AnuncioImagemService anuncioImagemService;
	private UsuarioService usuarioService;

	@Autowired
	public AnuncioService(AnuncioDAO anuncioDAO,UsuarioService usuarioService, AnuncioImagemService anuncioImagemService) {
		this.anuncioDAO = anuncioDAO;
		this.usuarioService = usuarioService;
		this.anuncioImagemService = anuncioImagemService;
	}
	
	public AnuncioDTO buscarPorID(Long idAnuncio) {
		return AnuncioMapper.paraDTO(anuncioDAO.buscarPorId(idAnuncio));
	}
	
	public List<AnuncioResumoDTO> listarTodos() {
		List<Anuncio> anuncios = anuncioDAO.listarTodos();
		
		List<AnuncioResumoDTO> anunciosResumoDTO = new ArrayList<AnuncioResumoDTO>();
		for (Anuncio anuncio : anuncios) {
			anunciosResumoDTO.add(new AnuncioResumoDTO(anuncio));
		}
		
		return anunciosResumoDTO;
	}
	
	public List<AnuncioResumoDTO> listarPorCidade(String cidade) {

		List<Anuncio> anuncios = anuncioDAO.listarPorCidade(cidade);

		List<AnuncioResumoDTO> anunciosDTO = new ArrayList<AnuncioResumoDTO>();
		for (Anuncio anuncio : anuncios) {
			anunciosDTO.add(new AnuncioResumoDTO(anuncio));
		}

		return anunciosDTO;
	}
	
	public List<AnuncioResumoDTO> listarPorBuscaDetalhada(
			BigDecimal precoMenor, BigDecimal precoMaior, Long idTipoImovel, Long idTipoAcomodacao, Long idCidade) {

		List<Anuncio> anuncios = anuncioDAO.listarPorPrecoETipoImovelETipoAcomodacaoECidade(
				precoMenor, precoMaior, idTipoImovel, idTipoAcomodacao, idCidade);

		List<AnuncioResumoDTO> anunciosDTO = new ArrayList<AnuncioResumoDTO>();
		for (Anuncio anuncio : anuncios) {
			anunciosDTO.add(new AnuncioResumoDTO(anuncio));
		}

		return anunciosDTO;
	}
	
	public Anuncio inserir(AnuncioDTO dto, MultipartFile imagem) throws RuntimeException, IOException, AbstractException{
		
		Long idUsuario = usuarioService.obterIdDoUsuarioLogado();
		
		Foto imagemSalva = anuncioImagemService.saveImage(imagem.getOriginalFilename(), imagem);
		Long idFoto = imagemSalva.getIdFoto();
		
		dto.setIdUsuario(idUsuario);
		dto.setIdFotoCapa(idFoto);
		dto.setSituacao("DISPONIVEL");
		return anuncioDAO.salvar(AnuncioMapper.paraEntidade(dto));
	}
}
