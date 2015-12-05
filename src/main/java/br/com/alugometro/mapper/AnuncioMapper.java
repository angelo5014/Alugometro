package br.com.alugometro.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.alugometro.domain.Anuncio;
import br.com.alugometro.domain.Anuncio.SituacaoAnuncio;
import br.com.alugometro.domain.Cidade;
import br.com.alugometro.domain.Foto;
import br.com.alugometro.domain.TipoAcomodacao;
import br.com.alugometro.domain.TipoImovel;
import br.com.alugometro.domain.Usuario;
import br.com.alugometro.dto.AnuncioDTO;

public class AnuncioMapper {

	public static Anuncio paraEntidade(AnuncioDTO dto) {
		Anuncio anuncio = new Anuncio();
		anuncio.setUsuario(new Usuario(dto.getIdUsuario()));
		anuncio.setTipoImovel(new TipoImovel(dto.getIdTipoImovel()));
		anuncio.setTipoAcomodacao(new TipoAcomodacao(dto.getIdTipoAcomodacao()));
		anuncio.setNumeroPessoas(dto.getNumeroPessoas());
		anuncio.setCidade(new Cidade(dto.getIdCidade()));
		anuncio.setDataInicio(dateParaString(dto.getDataInicio()));
		anuncio.setDataFim(dateParaString(dto.getDataFim()));
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
		return dto;
	}
	
	private static Date dateParaString(String data){
		SimpleDateFormat formatter = new SimpleDateFormat();
		Date date = new Date();
		try {
			date = (Date) formatter.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
}
