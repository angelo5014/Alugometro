package br.com.alugometro.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.alugometro.domain.Usuario;
import br.com.alugometro.domain.Usuario.PermissaoUsuario;
import br.com.alugometro.domain.Usuario.SituacaoUsuario;
import br.com.alugometro.dto.UsuarioDTO;

public class UsuarioMapperTest {

	@Test
	public void converteParaDTOComSucesso(){
		// Arrang
		Usuario entidadeTeste = new Usuario();
		entidadeTeste.setIdUsuario(100L);
		entidadeTeste.setNome("Teste");
		entidadeTeste.setSobrenome("da Silva");
		entidadeTeste.setEmail("teste.silva@teste.com");
		entidadeTeste.setSenha("senha");
		entidadeTeste.setSituacao(SituacaoUsuario.ATIVO);
		entidadeTeste.setPermissao(PermissaoUsuario.ROLE_USER);
		
		UsuarioDTO dtoEsperado = new UsuarioDTO();
		dtoEsperado.setIdUsuario(100L);
		dtoEsperado.setNome("Teste");
		dtoEsperado.setSobrenome("da Silva");
		dtoEsperado.setEmail("teste.silva@teste.com");
		dtoEsperado.setSenha("senha");
		dtoEsperado.setSituacao(SituacaoUsuario.ATIVO);
		dtoEsperado.setPermissao(PermissaoUsuario.ROLE_USER);
		
		// Act
		UsuarioDTO dtoObtido = UsuarioMapper.paraDTO(entidadeTeste);
		
		// Assert
		assertEquals(dtoEsperado, dtoObtido);
	}
	
	@Test
	public void converteParaEntidadeComsucesso(){
		// Arrang
		UsuarioDTO dtoTeste = new UsuarioDTO();
		dtoTeste.setIdUsuario(100L);
		dtoTeste.setNome("Teste");
		dtoTeste.setSobrenome("da Silva");
		dtoTeste.setEmail("teste.silva@teste.com");
		dtoTeste.setSenha("senha");
		dtoTeste.setSituacao(SituacaoUsuario.ATIVO);
		dtoTeste.setPermissao(PermissaoUsuario.ROLE_USER);
		
		Usuario entidadeEsperada = new Usuario();
		entidadeEsperada.setIdUsuario(100L);
		entidadeEsperada.setNome("Teste");
		entidadeEsperada.setSobrenome("da Silva");
		entidadeEsperada.setEmail("teste.silva@teste.com");
		entidadeEsperada.setSenha("senha");
		entidadeEsperada.setSituacao(SituacaoUsuario.ATIVO);
		entidadeEsperada.setPermissao(PermissaoUsuario.ROLE_USER);
		
		
		// Act
		Usuario entidadeObtida = UsuarioMapper.paraEntidade(dtoTeste);
		
		// Assert
		assertEquals(entidadeEsperada, entidadeObtida);
	}

}
