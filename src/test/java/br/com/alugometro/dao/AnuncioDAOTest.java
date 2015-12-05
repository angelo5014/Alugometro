package br.com.alugometro.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.alugometro.AbstractInfrastructureTest;
import br.com.alugometro.domain.Anuncio;

public class AnuncioDAOTest extends AbstractInfrastructureTest {

	@Autowired
	private AnuncioDAO anuncioDAO;
	
	@Test
	public void testListarPorCidade() throws Exception {
		List<Anuncio> anuncios = anuncioDAO.listarPorCidade("P");
		Assert.assertNotNull(anuncios);
	}
	
	@Test
	public void deveRetornarAnunciosBuscandoPorTodosOsCampos() {
		BigDecimal precoMenor = new BigDecimal("10");
		BigDecimal precoMaior = new BigDecimal("150");
		
		List<Anuncio> anuncios = anuncioDAO.listarPorPrecoETipoImovelETipoAcomodacaoECidade(
				precoMenor, precoMaior, 1L, 1L, 1L);
		Assert.assertNotNull(anuncios);
	}
	
	@Test
	public void naoDeveRetornarAnunciosBuscandoPorTodosOsCampos() {
		BigDecimal precoMenor = new BigDecimal("100000");
		BigDecimal precoMaior = new BigDecimal("100001");
		
		List<Anuncio> anuncios = anuncioDAO.listarPorPrecoETipoImovelETipoAcomodacaoECidade(
				precoMenor, precoMaior, 1000000L, 100000L, 1L);
		Assert.assertNotNull(anuncios);
	}
	
	@Test
	public void deveRetornarAnunciosSóComFaixaDePreço() {
		BigDecimal precoMenor = new BigDecimal("10");
		BigDecimal precoMaior = new BigDecimal("150");
		
		List<Anuncio> anuncios = anuncioDAO.listarPorPrecoETipoImovelETipoAcomodacaoECidade(
				precoMenor, precoMaior, null, null, null);
		Assert.assertNotNull(anuncios);
	}

}
