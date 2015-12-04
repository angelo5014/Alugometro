package br.com.alugometro.dto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.alugometro.domain.Usuario.SituacaoUsuario;

public class UsuarioDTOTest {
	
	UsuarioDTO usuarioTeste;
	
	@Before
	public void setUp(){
		usuarioTeste = new UsuarioDTO();
	}
	
	@Test
	public void usuarioDTOEstáComSituaçãoAtivo() {
		// Arrange
		usuarioTeste.setSituacao(SituacaoUsuario.ATIVO);
		
		// Act
		boolean situacaoÉAtivo = usuarioTeste.estaAtivo();
		
		// Assert
		assertTrue(situacaoÉAtivo);
	}
	
	@Test
	public void usuarioDTOEstáComSituaçãoInativo(){
		// Arrange
		usuarioTeste.setSituacao(SituacaoUsuario.INATIVO);
		
		// Act
		boolean situacaoÉInativo = usuarioTeste.estaAtivo();
		
		// Assert
		assertFalse(situacaoÉInativo);
	}
	
	@Test
	public void aoTrocarSituacaoDeusuarioDTOParaAtivoSituacaoÉAtivo(){
		// Arrange
		usuarioTeste.setSituacao(SituacaoUsuario.INATIVO);
		
		SituacaoUsuario situacaoEsperada = SituacaoUsuario.ATIVO;
		
		// Act
		usuarioTeste.setSituacao(SituacaoUsuario.ATIVO);
		SituacaoUsuario situacaoObtida = usuarioTeste.getSituacao();
		
		// Assert
		assertEquals(situacaoEsperada, situacaoObtida);
	}
	
	@Test
	public void aoTrocarSituacaoDeusuarioDTOParaInativoSituaçãoÉInativo(){
		// Arrange
		usuarioTeste.setSituacao(SituacaoUsuario.ATIVO);
		
		SituacaoUsuario situacaoEsperada = SituacaoUsuario.INATIVO;
		
		// Act
		usuarioTeste.setSituacao(SituacaoUsuario.INATIVO);
		SituacaoUsuario situacaoObtida = usuarioTeste.getSituacao();
		
		// Assert
		assertEquals(situacaoEsperada, situacaoObtida);
	}

}
