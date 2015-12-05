package br.com.alugometro.mapper;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

import br.com.alugometro.domain.Anuncio;
import br.com.alugometro.domain.Reserva;
import br.com.alugometro.domain.Reserva.SituacaoReserva;
import br.com.alugometro.domain.Usuario;
import br.com.alugometro.dto.AnuncioDTO;
import br.com.alugometro.dto.ReservaDTO;
import br.com.alugometro.dto.UsuarioDTO;

public class ReservaMapperTest {

	@Test
	public void converteParaDTOComSucesso(){
		// Arrange
		DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
		
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(1L);

		Anuncio anuncio = new Anuncio();
		anuncio.setIdAnuncio(1L);
		
		Date dataInicio = new Date();;
		Date dataFim = new Date();
		
		try {
			dataInicio = df.parse("10/10/2015");
			dataFim = df.parse("11/10/2015");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Reserva entidade = new Reserva();
		entidade.setIdReserva(1L);
		entidade.setAnuncio(anuncio);
		entidade.setUsuario(usuario);
		entidade.setDataInicio(dataInicio);
		entidade.setDataFim(dataFim);
		entidade.setValorDia(new BigDecimal(10));
		entidade.setValorTotal(new BigDecimal(10));
		entidade.setSituacao(SituacaoReserva.PENDENTE);
		
		ReservaDTO dtoEsperado = new ReservaDTO();
		dtoEsperado.setIdReserva(1L);
		dtoEsperado.setIdAnuncio(1L);
		dtoEsperado.setIdUsuario(1L);
		dtoEsperado.setDataInicio(dataInicio);
		dtoEsperado.setDataFim(dataFim);
		dtoEsperado.setValorDia(new BigDecimal(10));
		dtoEsperado.setValorTotal(new BigDecimal(10));
		dtoEsperado.setSituacao(SituacaoReserva.PENDENTE);
		
		// Act
		ReservaDTO dtoObtido = ReservaMapper.paraDTO(entidade);
		
		// Assert
		assertEquals(dtoEsperado, dtoObtido);
	}
	
	@Test
	public void converteParaEntidadeComsucesso(){
		// Arrange
		DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
		
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(1L);

		Anuncio anuncio = new Anuncio();
		anuncio.setIdAnuncio(1L);
		
		Date dataInicio = new Date();;
		Date dataFim = new Date();
		
		try {
			dataInicio = df.parse("10/10/2015");
			dataFim = df.parse("11/10/2015");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ReservaDTO dto = new ReservaDTO();
		dto.setIdReserva(1L);
		dto.setIdAnuncio(1L);
		dto.setIdUsuario(1L);
		dto.setDataInicio(dataInicio);
		dto.setDataFim(dataFim);
		dto.setValorDia(new BigDecimal(10));
		dto.setValorTotal(new BigDecimal(10));
		dto.setSituacao(SituacaoReserva.PENDENTE);
		
		Reserva entidadeEsperada = new Reserva();
		entidadeEsperada.setIdReserva(1L);
		entidadeEsperada.setAnuncio(anuncio);
		entidadeEsperada.setUsuario(usuario);
		entidadeEsperada.setDataInicio(dataInicio);
		entidadeEsperada.setDataFim(dataFim);
		entidadeEsperada.setValorDia(new BigDecimal(10));
		entidadeEsperada.setValorTotal(new BigDecimal(10));
		entidadeEsperada.setSituacao(SituacaoReserva.PENDENTE);
		
		// Act
		Reserva entidadeObtida = ReservaMapper.paraEntidade(dto);
		
		// Assert
		assertEquals(entidadeEsperada, entidadeObtida);
	}
}
