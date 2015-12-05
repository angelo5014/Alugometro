package br.com.alugometro.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.alugometro.dao.AnuncioDAO;
import br.com.alugometro.domain.Anuncio;
import br.com.alugometro.domain.Anuncio.SituacaoAnuncio;
import br.com.alugometro.domain.Cidade;
import br.com.alugometro.domain.Foto;
import br.com.alugometro.domain.TipoAcomodacao;
import br.com.alugometro.domain.TipoImovel;
import br.com.alugometro.domain.Usuario;
import br.com.alugometro.mapper.AnuncioMapper;

public class AnuncioServiceTest {
	
	@InjectMocks
	AnuncioService anuncioService;
	
	@Mock
	AnuncioDAO anuncioDAO;
	
	Anuncio anuncio = new Anuncio();
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		anuncio.setIdAnuncio(1L);
		anuncio.setCidade(new Cidade(1L));
		anuncio.setUsuario(new Usuario());
		anuncio.setTipoImovel(new TipoImovel());
		anuncio.setTipoAcomodacao(new TipoAcomodacao());
		anuncio.setFotoCapa(new Foto());
		anuncio.setSituacao(SituacaoAnuncio.DISPONIVEL);
	}
	
	@Test
	public void buscarPorIdnaoEhNulo() {
		Mockito.when(anuncioDAO.buscarPorId(1L)).thenReturn(anuncio);
		Assert.assertNotNull(anuncioService.buscarPorID(1L));
	}
	
	@Test
	public void inserirAnuncioComSucesso() {
		Assert.assertNotNull(anuncioService.inserir(AnuncioMapper.paraDTO(anuncio)));
	}
	
}
