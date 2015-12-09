package br.com.alugometro.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.alugometro.dao.AnuncioDAO;
import br.com.alugometro.dao.UsuarioDAO;
import br.com.alugometro.domain.Anuncio;
import br.com.alugometro.domain.Foto;
import br.com.alugometro.dto.AnuncioDTO;
import br.com.alugometro.dto.AnuncioResumoDTO;
import br.com.alugometro.exception.AbstractException;
import br.com.alugometro.exception.ImagemNaoRegistradaException;
import br.com.alugometro.exception.UsuarioNaoEncontradoException;
import br.com.alugometro.mapper.AnuncioMapper;

@Service
public class AnuncioService {

	private AnuncioDAO anuncioDAO;
	private UsuarioDAO usuarioDAO;
	private AnuncioFotoService anuncioFotoService;
	private UsuarioService usuarioService;

	@Autowired
	public AnuncioService(AnuncioDAO anuncioDAO,UsuarioDAO usuarioDAO,UsuarioService usuarioService, AnuncioFotoService anuncioFotoService) {
		this.anuncioDAO = anuncioDAO;
		this.usuarioDAO = usuarioDAO;
		this.usuarioService = usuarioService;
		this.anuncioFotoService = anuncioFotoService;
	}
	
	public AnuncioDTO buscarPorId(Long idAnuncio) {
		return AnuncioMapper.paraDTO(anuncioDAO.buscarPorId(idAnuncio));
	}
	
	public int desativarAnuncio(Long idAnuncio){
		return anuncioDAO.desativar(idAnuncio);
	}
	
	public List<AnuncioResumoDTO> listarTodos() {
		List<Anuncio> anuncios = anuncioDAO.listarTodos();
		
		List<AnuncioResumoDTO> anunciosResumoDTO = new ArrayList<AnuncioResumoDTO>();
		for (Anuncio anuncio : anuncios) {
			anunciosResumoDTO.add(new AnuncioResumoDTO(anuncio));
		}
		
		return anunciosResumoDTO;
	}
	
	public List<AnuncioResumoDTO> buscarAnunciosDoUsuario(Long idUsuario) {
		List<AnuncioResumoDTO> anunciosDTO = new ArrayList<>();
		
		try {
			for (Anuncio anuncio : usuarioDAO.buscarPorId(idUsuario).getAnuncios()) {
				anunciosDTO.add(new AnuncioResumoDTO(anuncio));
			}
		} catch (UsuarioNaoEncontradoException e) {
			e.printStackTrace();
		}
		return anunciosDTO;
	}
	
	public List<AnuncioResumoDTO> buscarAnunciosDoUsuarioEmail(String email) {
		List<AnuncioResumoDTO> anunciosDTO = new ArrayList<>();
		
		try {
			for (Anuncio anuncio : usuarioDAO.buscarPorEmail(email).getAnuncios()) {
				anunciosDTO.add(new AnuncioResumoDTO(anuncio));
			}
		} catch ( AbstractException e) {
			e.printStackTrace();
		}
		return anunciosDTO;
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
			BigDecimal precoMenor, 
			BigDecimal precoMaior, 
			Long idTipoImovel, 
			Long idTipoAcomodacao, 
			Long idCidade) {

		List<Anuncio> anuncios = anuncioDAO.listarPorPrecoETipoImovelETipoAcomodacaoECidade(
				precoMenor, precoMaior, idTipoImovel, idTipoAcomodacao, idCidade);

		List<AnuncioResumoDTO> anunciosDTO = new ArrayList<AnuncioResumoDTO>();
		for (Anuncio anuncio : anuncios) {
			anunciosDTO.add(new AnuncioResumoDTO(anuncio));
		}

		return anunciosDTO;
	}
	
	public Anuncio inserir(AnuncioDTO dto, MultipartFile imagem) throws AbstractException {
		
		Long idUsuario = null;
		idUsuario = usuarioService.obterIdDoUsuarioLogado();
		
		Foto imagemSalva = null;
		try {
			imagemSalva = anuncioFotoService.salvarImagem(imagem.getOriginalFilename(),idUsuario , imagem);
		} catch (ImagemNaoRegistradaException e) {
			e.printStackTrace();
		}
		Long idFoto = imagemSalva.getIdFoto();
		
		dto.setIdUsuario(idUsuario);
		dto.setIdFotoCapa(idFoto);
		dto.setSituacao("DISPONIVEL");
		try {
			return anuncioDAO.salvar(AnuncioMapper.paraEntidade(dto));
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
}
