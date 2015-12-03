package br.com.alugometro.security;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AlugometroMd5EncoderTest {
	
	private AlugometroMd5Encoder encoder;
	
	@Before
	public void setUp(){
		encoder = new AlugometroMd5Encoder();
		//Salt definido na classe: Alohomora
	}
	
	@Test
	public void senhaAdminTemHashEsperado() {
		// Arrange
		String senhaPura = "admin";
		String hashEsperado = "53aa16ffad92e1f4b211e061e461ca53";
		
		// Act
		String hashObtido = encoder.encodePassword(senhaPura, null);
		
		// Assert
		assertEquals(hashEsperado, hashObtido);
	}
	
	@Test
	public void senhaAdminÉVálida(){
		// Arrange
		String senhaPura = "admin";
		String hashSenha = encoder.encodePassword(senhaPura, null);
		
		// Act
		boolean senhaEValida = encoder.isPasswordValid(hashSenha, senhaPura, null);
		
		// Assert
		assertTrue(senhaEValida);
	}

}
