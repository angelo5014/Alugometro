package br.com.alugometro.mapper;

import java.util.List;

import br.com.alugometro.domain.Anuncio;
import br.com.alugometro.domain.Reserva;
import br.com.alugometro.domain.Usuario;
import br.com.alugometro.dto.ReservaDTO;

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
		entidade.setSituacao(dto.getSituacao());
		
		return entidade;
		
	}
	
	public static ReservaDTO paraDTO(Reserva entidade){
		ReservaDTO dto = new ReservaDTO();
		dto.setIdReserva(entidade.getIdReserva());
		dto.setIdAnuncio(entidade.getAnuncio().getIdAnuncio());
		dto.setIdUsuario(entidade.getUsuario().getIdUsuario());
		dto.setDataInicio(entidade.getDataInicio());
		dto.setDataFim(entidade.getDataFim());
		dto.setValorDia(entidade.getValorDia());
		dto.setValorTotal(entidade.getValorTotal());
		dto.setSituacao(entidade.getSituacao());
		
		return dto;
	}

	public static List<ReservaDTO> paraListaDTO(List<Reserva> listaEntidade) {

	}
}
