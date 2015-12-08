package br.com.alugometro.mapper;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import br.com.alugometro.domain.Anuncio;
import br.com.alugometro.domain.Reserva;
import br.com.alugometro.domain.Usuario;
import br.com.alugometro.domain.SituacaoReserva;
import br.com.alugometro.dto.ReservaConfirmacaoDTO;
import br.com.alugometro.dto.ReservaDTO;
import br.com.alugometro.service.CalendarioService;

public class ReservaMapper {
	
	public static Reserva paraEntidade(ReservaDTO dto){
		Reserva entidade = new Reserva();
		
		Anuncio anuncio = new Anuncio();
		anuncio.setIdAnuncio(dto.getIdAnuncio());
		
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(dto.getIdUsuario());
		
		entidade.setIdReserva(dto.getIdReserva());
		entidade.setAnuncio(anuncio);
		entidade.setUsuario(usuario);
		entidade.setDataInicio(dto.getDataInicio());
		entidade.setDataFim(dto.getDataFim());
		entidade.setValorDia(dto.getValorDia());
		entidade.setValorTotal(dto.getValorTotal());
		entidade.setSituacao(Enum.valueOf(SituacaoReserva.class, dto.getSituacao()));
		
		return entidade;
		
	}
	
	public static Reserva paraEntidade(ReservaConfirmacaoDTO dto) throws ParseException{
		Reserva entidade = new Reserva();
		
		Anuncio anuncio = new Anuncio();
		anuncio.setIdAnuncio(dto.getIdAnuncio());
		
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(dto.getIdUsuarioLocando());
		
		entidade.setAnuncio(anuncio);
		entidade.setUsuario(usuario);
		entidade.setDataInicio(CalendarioService.converterStringParaDate(dto.getDataInicio()));
		entidade.setDataFim(CalendarioService.converterStringParaDate(dto.getDataFim()));
		entidade.setValorDia(dto.getDiaria());
		entidade.setValorTotal(dto.getTotal());
		
		return entidade;
		
	}
	
	public static ReservaDTO paraDTO(Reserva entidade){
		ReservaDTO dto = new ReservaDTO();
		dto.setIdReserva(entidade.getIdReserva());
		dto.setIdAnuncio(entidade.getAnuncio().getIdAnuncio());
		dto.setDescricaoCapaAnuncio(entidade.getAnuncio().getDescricaoCapa());
		dto.setIdUsuario(entidade.getUsuario().getIdUsuario());
		dto.setDataInicio(entidade.getDataInicio());
		dto.setDataFim(entidade.getDataFim());
		dto.setValorDia(entidade.getValorDia());
		dto.setValorTotal(entidade.getValorTotal());
		dto.setSituacao(entidade.getSituacao().toString());
		
		return dto;
	}
	
	public static ReservaDTO paraDTO(ReservaConfirmacaoDTO reservaConfirmacaoDTO) throws ParseException{
		ReservaDTO dto = new ReservaDTO();
		dto.setIdAnuncio(reservaConfirmacaoDTO.getIdAnuncio());
		dto.setIdUsuario(reservaConfirmacaoDTO.getIdUsuarioLocando());
		dto.setDataInicio(CalendarioService.converterStringParaDate(reservaConfirmacaoDTO.getDataInicio()));
		dto.setDataFim(CalendarioService.converterStringParaDate(reservaConfirmacaoDTO.getDataFim()));
		dto.setValorDia(reservaConfirmacaoDTO.getDiaria());
		dto.setValorTotal(reservaConfirmacaoDTO.getTotal());
		
		return dto;
	}

	public static List<ReservaDTO> paraListaDTO(List<Reserva> listaEntidade) {
		List<ReservaDTO> listaDTO = new ArrayList<ReservaDTO>();
		
		for (Reserva entidade : listaEntidade) {
			listaDTO.add(paraDTO(entidade));
		}
		
		return listaDTO;
	}
}
