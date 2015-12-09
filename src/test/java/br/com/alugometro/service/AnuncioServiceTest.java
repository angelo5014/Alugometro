package br.com.alugometro.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.alugometro.AppConfig;
import br.com.alugometro.dao.AnuncioDAO;
import br.com.alugometro.dao.UsuarioDAO;
import br.com.alugometro.domain.Anuncio;
import br.com.alugometro.domain.Anuncio.SituacaoAnuncio;
import br.com.alugometro.domain.Cidade;
import br.com.alugometro.domain.Foto;
import br.com.alugometro.domain.TipoAcomodacao;
import br.com.alugometro.domain.TipoImovel;
import br.com.alugometro.domain.Usuario;
import br.com.alugometro.dto.AnuncioDTO;
import br.com.alugometro.dto.AnuncioResumoDTO;
import br.com.alugometro.exception.AbstractException;
import br.com.alugometro.exception.UsuarioNaoEncontradoException;
import br.com.alugometro.mapper.AnuncioMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppConfig.class)
@WebAppConfiguration
public class AnuncioServiceTest {
	
	@InjectMocks
	AnuncioService anuncioService;
	
	@Mock
	AnuncioDAO anuncioDAO;
	
	@Mock
	UsuarioDAO usuarioDAO;
	
	Anuncio anuncio = new Anuncio();
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		anuncio.setIdAnuncio(1L);
		anuncio.setCidade(new Cidade(1L));
		anuncio.setUsuario(new Usuario());
		anuncio.setTipoImovel(new TipoImovel());
		anuncio.setTipoAcomodacao(new TipoAcomodacao());
		anuncio.setDiaria(new BigDecimal("100"));
		anuncio.setDataInicio(new Date());
		anuncio.setDataFim(new Date());
		anuncio.setFotoCapa(new Foto());
		anuncio.setSituacao(SituacaoAnuncio.DISPONIVEL);
	}
	
	@Test
	public void buscarPorIdNaoEhNulo() {
		Mockito.when(anuncioDAO.buscarPorId(1L)).thenReturn(anuncio);
		Assert.assertNotNull(anuncioService.buscarPorId(1L));
	}

	@Test
	public void desativarAnuncio(){
		Mockito.when(anuncioDAO.desativar(1L)).thenReturn(1);
		Assert.assertEquals(1, anuncioService.desativarAnuncio(1L));
	}
	
	@Test
	public void listarTodos(){
		List<Anuncio> list = new ArrayList<>();
		list.add(anuncio);
		
		Mockito.when(anuncioDAO.listarTodos()).thenReturn(list);
		
		Assert.assertEquals(AnuncioMapper.paraDTO(anuncio).getIdAnuncio(), anuncioService.listarTodos().get(0).getIdAnuncio());
	}
	
	@Test
	public void buscarAnuncioDeUsuario() {
		List<Anuncio> list = new ArrayList<>();
		list.add(anuncio);
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(1L);
		usuario.setAnuncios(list);
		
		try {
			Mockito.when(usuarioDAO.buscarPorId(1L)).thenReturn(usuario);
		} catch (UsuarioNaoEncontradoException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals(list.get(0).getIdAnuncio(), anuncioService.buscarAnunciosDoUsuario(1L).get(0).getIdAnuncio());
		
	}
	
	@Test
	public void buscarAnuncioDeUsuarioPorEmail() {
		List<Anuncio> list = new ArrayList<>();
		list.add(anuncio);
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(1L);
		usuario.setEmail("teste@teste.com");
		usuario.setAnuncios(list);
		
		try {
			Mockito.when(usuarioDAO.buscarPorEmail("teste@teste.com")).thenReturn(usuario);
		} catch (AbstractException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals(list.get(0).getIdAnuncio(), anuncioService.buscarAnunciosDoUsuarioEmail("teste@teste.com").get(0).getIdAnuncio());
		
	}
	
	@Test
	public void listarPorCidade() {
		List<Anuncio> list = new ArrayList<>();
		list.add(anuncio);
		
		Mockito.when(anuncioDAO.listarPorCidade("São Leopoldo")).thenReturn(list);
		
		Assert.assertEquals(new AnuncioResumoDTO(anuncio).getCidade(), anuncioService.listarPorCidade("São Leopoldo").get(0).getCidade());
	}
	
}
