package br.com.alugometro.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.alugometro.AbstractInfrastructureTest;
import br.com.alugometro.domain.TipoImovel;

public class TipoImovelDAOTest extends AbstractInfrastructureTest {

	@Autowired
	private TipoImovelDAO tipoImovelDAO;
	
	@Test
	public void deveEncontrarTipoDeImovelPorId() throws Exception {
		TipoImovel tipoImovel = tipoImovelDAO.encontrarPorId(1L);
		Assert.assertNotNull(tipoImovel);
	}
	
	@Test
	public void deveListarTodos() throws Exception {
		List<TipoImovel> tiposImovel = tipoImovelDAO.listarTodos();
		Assert.assertNotNull(tiposImovel);
	}

}
