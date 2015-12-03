package br.com.alugometro.mapper;

import br.com.alugometro.domain.Anuncio;
import br.com.alugometro.domain.Anuncio.SituacaoAnuncio;
import br.com.alugometro.domain.Cidade;
import br.com.alugometro.domain.Estado;
import br.com.alugometro.domain.Federacao;
import br.com.alugometro.domain.TipoAcomodacao;
import br.com.alugometro.domain.TipoImovel;
import br.com.alugometro.domain.Usuario;
import br.com.alugometro.dto.AnuncioDTO;

public class AnuncioMapper {

	public static Anuncio gerarNovaEntidade(AnuncioDTO anuncioDTO) {
		Anuncio anuncio = new Anuncio();
		anuncio.setUsuario(new Usuario(anuncioDTO.getIdUsuario()));
		anuncio.setTipoImovel(new TipoImovel(anuncioDTO.getIdTipoImovel()));
		anuncio.setTipoAcomodacao(new TipoAcomodacao(anuncioDTO.getIdTipoAcomodacao()));
		anuncio.setNumeroPessoas(anuncioDTO.getNumeroPessoas());
		anuncio.setCidade(new Cidade(new Estado(new Federacao(anuncioDTO.getIdFederacao()))));
		anuncio.setDataInicio(anuncioDTO.getDataInicio());
		anuncio.setDataFim(anuncioDTO.getDataFim());
		anuncio.setDiaria(anuncioDTO.getDiaria());
		anuncio.setDescricaoCapa(anuncio.getDescricaoCapa());
		anuncio.setDescricaoDetalhada(anuncio.getDescricaoDetalhada());
		anuncio.setFotoCapa(anuncio.getFotoCapa());
		anuncio.setSituacao(Enum.valueOf(SituacaoAnuncio.class, anuncioDTO.getSituacao()));
		return anuncio;
	}
	
	public static AnuncioDTO paraDTO(Anuncio anuncio) {
		AnuncioDTO dto = new AnuncioDTO();
		dto.setIdAnuncio(anuncio.getIdAnuncio());
		dto.setIdUsuario(anuncio.getUsuario().getIdUsuario());
		dto.setIdTipoImovel(anuncio.getTipoImovel().getIdTipoImovel());
		dto.setIdTipoAcomodacao(anuncio.getTipoAcomodacao().getIdTipoAcomodacao());
		dto.setNumeroPessoas(anuncio.getNumeroPessoas());
		dto.setIdCidade(anuncio.getCidade().getIdCidade());
		dto.setNomeCidade(anuncio.getCidade().getNome());
		dto.setIdEstado(anuncio.getCidade().getEstado().getIdEstado());
		dto.setIdFederacao(anuncio.getCidade().getEstado().getFederacao().getIdFederacao());
		dto.setDataInicio(anuncio.getDataInicio());
		dto.setDataFim(anuncio.getDataFim());
		dto.setDiaria(anuncio.getDiaria());
		dto.setDescricaoCapa(anuncio.getDescricaoCapa());
		dto.setDescricaoDetalhada(anuncio.getDescricaoDetalhada());
		dto.setFotoCapa(anuncio.getFotoCapa().getUrl());
		return dto;
	}
	
}
