package br.com.alugometro.mapper;

import br.com.alugometro.domain.Anuncio;
import br.com.alugometro.dto.AnuncioDTO;

public class AnuncioMapper {

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
		dto.setIdFederacao(anuncio.getCidade().getEstado().getIdFederacao().getIdFederacao());
		dto.setDataInicio(anuncio.getDataInicio());
		dto.setDataFim(anuncio.getDataFim());
		dto.setDiaria(anuncio.getDiaria());
		dto.setDescricaoCapa(anuncio.getDescricaoCapa());
		dto.setDescricaoDetalhada(anuncio.getDescricaoDetalhada());
		dto.setFotoCapa(anuncio.getFotoCapa().getUrl());
		return dto;
	}
	
}
