package br.com.alugometro.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.alugometro.AbstractInfrastructureTest;
import br.com.alugometro.domain.TipoAcomodacao;

public class TipoAcomodacaoDAOTest extends AbstractInfrastructureTest {

	@Autowired
	private TipoAcomodacaoDAO tipoAcomodacaoDAO;

	@Test
	public void deveEncontrarTipoDeAcomodacaoPorId() throws Exception {
		TipoAcomodacao tipoAcomodacao = tipoAcomodacaoDAO.encontrarPorId(1L);
		Assert.assertNotNull(tipoAcomodacao);
	}

	@Test
	public void testListarTodos() throws Exception {
		List<TipoAcomodacao> tiposAcomodacao = tipoAcomodacaoDAO.listarTodos();
		Assert.assertNotNull(tiposAcomodacao);
	}

}
