package br.com.alugometro.mapper;

import java.text.ParseException;

import br.com.alugometro.domain.Anuncio;
import br.com.alugometro.domain.Anuncio.SituacaoAnuncio;
import br.com.alugometro.domain.Cidade;
import br.com.alugometro.domain.Foto;
import br.com.alugometro.domain.TipoAcomodacao;
import br.com.alugometro.domain.TipoImovel;
import br.com.alugometro.domain.Usuario;
import br.com.alugometro.dto.AnuncioDTO;
import br.com.alugometro.service.CalendarioService;

public class AnuncioMapper {

	public static Anuncio paraEntidade(AnuncioDTO dto) throws ParseException {
		Anuncio anuncio = new Anuncio();
		anuncio.setUsuario(new Usuario(dto.getIdUsuario()));
		anuncio.setTipoImovel(new TipoImovel(dto.getIdTipoImovel()));
		anuncio.setTipoAcomodacao(new TipoAcomodacao(dto.getIdTipoAcomodacao()));
		anuncio.setNumeroPessoas(dto.getNumeroPessoas());
		anuncio.setCidade(new Cidade(dto.getIdCidade()));
		anuncio.setDataInicio(CalendarioService.converterStringParaDate(dto.getDataInicio()));
		anuncio.setDataFim(CalendarioService.converterStringParaDate(dto.getDataFim()));
		anuncio.setDiaria(dto.getDiaria());
		anuncio.setDescricaoCapa(dto.getDescricaoCapa());
		anuncio.setDescricaoDetalhada(dto.getDescricaoDetalhada());
		anuncio.setFotoCapa(new Foto(dto.getIdFotoCapa()));
		anuncio.setSituacao(Enum.valueOf(SituacaoAnuncio.class, dto.getSituacao()));
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
		dto.setDataInicio(anuncio.getDataInicio().toString());
		dto.setDataFim(anuncio.getDataFim().toString());
		dto.setDiaria(anuncio.getDiaria());
		dto.setDescricaoCapa(anuncio.getDescricaoCapa());
		dto.setDescricaoDetalhada(anuncio.getDescricaoDetalhada());
		dto.setIdFotoCapa(anuncio.getFotoCapa().getIdFoto());
		dto.setSituacao(anuncio.getSituacao().toString());
		
		dto.setCidade(anuncio.getCidade().getNome());
		dto.setTipoImovel(anuncio.getTipoImovel().getDescricao());
		dto.setTipoAcomodacao(anuncio.getTipoAcomodacao().getDescricao());
		dto.setUrlFotoCapa(anuncio.getFotoCapa().getUrl());
		dto.setDataInicioExibe(anuncio.getDataInicio());
		dto.setDataFimExibe(anuncio.getDataFim());
		
		return dto;
	}
}
