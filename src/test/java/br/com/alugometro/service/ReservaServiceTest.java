package br.com.alugometro.service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.alugometro.dao.AnuncioDAO;
import br.com.alugometro.dao.ReservaDAO;
import br.com.alugometro.domain.Anuncio;
import br.com.alugometro.domain.Cidade;
import br.com.alugometro.domain.Reserva;
import br.com.alugometro.domain.Reserva.SituacaoReserva;
import br.com.alugometro.domain.TipoImovel;
import br.com.alugometro.domain.Usuario;
import br.com.alugometro.domain.Usuario.SituacaoUsuario;
import br.com.alugometro.dto.ReservaConfirmacaoDTO;
import br.com.alugometro.dto.ReservaDTO;

public class ReservaServiceTest {
	
	@InjectMocks
	ReservaService reservaService;
	
	@Mock
	ReservaDAO reservaDAO;
	
	@Mock
	AnuncioDAO anuncioDAO;
	
	Reserva reserva;
	Usuario usuario;
	List<Reserva> reservas;
	Anuncio anuncio;
	
	Calendar calendario;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		
		calendario = Calendar.getInstance();
		
		calendario.set(2015, 10, 10);
		Date dataInicio = calendario.getTime();
		
		calendario.set(2015,  10, 20);
		Date dataFim = calendario.getTime();
		
		usuario = new Usuario();
		usuario.setIdUsuario(1L);
		usuario.setEmail("teste@teste.com");
		usuario.setNome("Teste");
		usuario.setSobrenome("Teste");
		usuario.setSituacao(SituacaoUsuario.ATIVO);
		
		TipoImovel tipoImovel = new TipoImovel();
		tipoImovel.setDescricao("teste");
		
		Cidade cidade = new Cidade();
		cidade.setNome("teste");
		
		anuncio = new Anuncio();
		anuncio.setIdAnuncio(1L);
		anuncio.setTipoImovel(tipoImovel);
		anuncio.setCidade(cidade);
		anuncio.setUsuario(usuario);
		anuncio.setDataInicio(dataInicio);
		anuncio.setDataFim(dataFim);
		
		reserva = new Reserva();
		reserva.setIdReserva(1L);
		reserva.setAnuncio(anuncio);
		reserva.setUsuario(usuario);
		reserva.setDataInicio(dataInicio);
		reserva.setDataFim(dataFim);
		reserva.setValorDia(new BigDecimal(10));
		reserva.setValorTotal(new BigDecimal(100));
		reserva.setSituacao(SituacaoReserva.PENDENTE);
		
		reservas = new ArrayList<Reserva>();
		reservas.add(reserva);
		reservas.add(reserva);

	}
	
	@Test
	public void reservaDeDia10102015ADia20102015ComDiaria10TemTotal100() {
		// Arrange
		calendario.set(2015,  10, 10);
		Date dataInicio = calendario.getTime();
		
		calendario.set(2015,  10, 20);
		Date dataFim = calendario.getTime();
		
		BigDecimal diaria = new BigDecimal(10);
		
		BigDecimal totalEsperado = new BigDecimal(100);
		
		ReservaConfirmacaoDTO reservaConfirmacao = new ReservaConfirmacaoDTO();
		reservaConfirmacao.setDataInicio(CalendarioService.converterDateParaString(dataInicio));
		reservaConfirmacao.setDataFim(CalendarioService.converterDateParaString(dataFim));
		reservaConfirmacao.setDiaria(diaria);
		
		// Act
		reservaService.calcularTotalReserva(reservaConfirmacao);
		
		// Assert
		assertEquals(totalEsperado, reservaConfirmacao.getTotal());
	}
	
	@Test
	public void buscarPorId1TrazReserva1(){
		// Arrange
		Mockito.when(reservaDAO.buscarPorId(1L)).thenReturn(reserva);
		Long idReservaEsperado = 1L;
		
		// Act
		ReservaDTO reservaObtida = this.reservaService.buscarPorId(1L);
		
		// Assert
		assertEquals(idReservaEsperado, reservaObtida.getIdReserva());
	}
	
	@Test
	public void buscarPorIdUsuario1TrazListaDe2Reservas(){
		// Arrange
		Mockito.when(reservaDAO.buscarPorIdUsuario(1L)).thenReturn(reservas);
		int qtdReservasEsperadas = 2;
		
		// Act
		List<ReservaDTO> reservasObtidas = this.reservaService.buscarPorUsuario(1L);
		
		// Assert
		assertEquals(qtdReservasEsperadas, reservasObtidas.size());
	}
	
	@Test
	public void buscarPorEmailUsuarioTrazListaDe2Reservas(){
		// Arrange
		Mockito.when(reservaDAO.buscarPorEmailUsuario("email")).thenReturn(reservas);
		int qtdReservasEsperadas = 2;
		
		// Act
		List<ReservaDTO> reservasObtidas = this.reservaService.buscarPorEmailUsuario("email");
		
		// Assert
		assertEquals(qtdReservasEsperadas, reservasObtidas.size());
	}
	
	@Test
	public void buscarPorDataESituacaoTrazListaDe2Reservas(){
		// Arrange
		Mockito.when(reservaDAO.listarPorDataESituacao("dataInicio", "dataFim", SituacaoReserva.PENDENTE)).thenReturn(reservas);
		int qtdReservasEsperadas = 2;
		
		// Act
		List<ReservaDTO> reservasObtidas = this.reservaService.buscarPorDataESituacao("dataInicio", "dataFim", SituacaoReserva.PENDENTE);
		
		// Assert
		assertEquals(qtdReservasEsperadas, reservasObtidas.size());
	}
	
	@Test
	public void obterDadosParaConfirmacaoTrazReservaComAnuncioDeId1(){
		// Arrange
		Mockito.when(anuncioDAO.buscarPorId(1L)).thenReturn(anuncio);
		Long idAnuncioEsperado = 1L;
		
		// Act
		ReservaConfirmacaoDTO reservaObtida = this.reservaService.obterDadosParaConfirmacao(1L);
		
		// Assert
		assertEquals(idAnuncioEsperado, reservaObtida.getIdAnuncio());
	}
}
