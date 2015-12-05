package br.com.alugometro.dao;

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

}
