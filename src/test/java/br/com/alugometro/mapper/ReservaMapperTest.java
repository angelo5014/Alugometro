package br.com.alugometro.mapper;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import br.com.alugometro.domain.Anuncio;
import br.com.alugometro.domain.Cidade;
import br.com.alugometro.domain.Reserva;
import br.com.alugometro.domain.Reserva.SituacaoReserva;
import br.com.alugometro.domain.TipoImovel;
import br.com.alugometro.domain.Usuario;
import br.com.alugometro.dto.ReservaConfirmacaoDTO;
import br.com.alugometro.dto.ReservaDTO;
import br.com.alugometro.service.CalendarioService;

public class ReservaMapperTest {

	@Test
	public void converteParaDTOComSucesso() {
		// Arrange
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(1L);
		
		TipoImovel tipoImovel = new TipoImovel();
		tipoImovel.setDescricao("teste");
		
		Cidade cidade = new Cidade();
		cidade.setNome("teste");
		
		Anuncio anuncio = new Anuncio();
		anuncio.setIdAnuncio(1L);
		anuncio.setTipoImovel(tipoImovel);
		anuncio.setCidade(cidade);
		
		Date dataInicio = new Date();;
		Date dataFim = new Date();
		
		try {
			dataInicio = df.parse("2015-10-10");
			dataFim = df.parse("2015-10-11");
		} catch (ParseException e) {
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
		dtoEsperado.setSituacao("PENDENTE");
		
		// Act
		ReservaDTO dtoObtido = ReservaMapper.paraDTO(entidade);
		
		// Assert
		assertEquals(dtoEsperado, dtoObtido);
	}
	
	@Test
	public void converteParaEntidadeComsucesso() {
		// Arrange
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(1L);

		Anuncio anuncio = new Anuncio();
		anuncio.setIdAnuncio(1L);
		
		Date dataInicio = new Date();;
		Date dataFim = new Date();
		
		try {
			dataInicio = df.parse("2015-10-10");
			dataFim = df.parse("2015-10-11");
		} catch (ParseException e) {
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
		dto.setSituacao("PENDENTE");
		
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
	
	@Test
	public void converteDeReservaConfirmacaoDTOParaEntidadeComsucesso(){
		// Arrange
		// DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(1L);

		Anuncio anuncio = new Anuncio();
		anuncio.setIdAnuncio(1L);
		
		String dataInicio = "2015-10-10";
		String dataFim = "2015-10-11";
		
		ReservaConfirmacaoDTO dto = new ReservaConfirmacaoDTO();
		dto.setIdAnuncio(1L);
		dto.setIdUsuarioLocando(1L);
		dto.setDataInicio(dataInicio);
		dto.setDataFim(dataFim);
		dto.setDiaria(new BigDecimal(10));
		dto.setTotal(new BigDecimal(10));
		
		Reserva entidadeEsperada = new Reserva();
		entidadeEsperada.setAnuncio(anuncio);
		entidadeEsperada.setUsuario(usuario);
		try {
			entidadeEsperada.setDataInicio(CalendarioService.converterStringParaDate(dataInicio));
			entidadeEsperada.setDataFim(CalendarioService.converterStringParaDate(dataFim));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		entidadeEsperada.setValorDia(new BigDecimal(10));
		entidadeEsperada.setValorTotal(new BigDecimal(10));
		
		// Act
		Reserva entidadeObtida = new Reserva();;
		try {
			entidadeObtida = ReservaMapper.paraEntidade(dto);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		// Assert
		assertEquals(entidadeEsperada, entidadeObtida);
	}
	
}
