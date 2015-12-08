package br.com.alugometro.service;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.alugometro.AbstractInfrastructureTest;

public class UsuarioSenhaServiceTest extends AbstractInfrastructureTest{
	
	UsuarioSenhaService senhaService = new UsuarioSenhaService();
	
	@Test
	public void criptogravarSenha123ComSucesso() {
		// Arrange
		String senhaEsperada = "2b63d556eaed34aa883a354d27cd0997";
		
		// Act
		String senhaObtida = this.senhaService.criptografarSenha("123");
		
		// Assert
		assertEquals(senhaEsperada, senhaObtida);
	}
	
	@Test
	public void verificarSenha123(){
		// Arrange
		String senhaConfirmada = "2b63d556eaed34aa883a354d27cd0997";
		String senhaConfirmar = this.senhaService.criptografarSenha("123");
		
		// Act
		boolean resultado = this.senhaService.confirmarSenha(senhaConfirmar, senhaConfirmada);
		
		// Assert
		assertTrue(resultado);
	}

}

