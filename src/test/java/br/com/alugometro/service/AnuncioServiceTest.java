package br.com.alugometro.service;

import java.util.Date;

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
import br.com.alugometro.domain.Anuncio;
import br.com.alugometro.domain.Anuncio.SituacaoAnuncio;
import br.com.alugometro.domain.Cidade;
import br.com.alugometro.domain.Foto;
import br.com.alugometro.domain.TipoAcomodacao;
import br.com.alugometro.domain.TipoImovel;
import br.com.alugometro.domain.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppConfig.class)
@WebAppConfiguration
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
	
}
