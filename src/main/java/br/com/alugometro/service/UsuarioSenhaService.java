package br.com.alugometro.service;

import org.springframework.stereotype.Service;

import br.com.alugometro.security.AlugometroMd5Encoder;

@Service
public class UsuarioSenhaService {

	AlugometroMd5Encoder encoder = new AlugometroMd5Encoder();
	
	public String criptografarSenha(String senha){
		return encoder.encodePassword(senha, null);
	}
	
	public boolean confirmarSenha(String senha, String confirmacao){
		return senha.equals(confirmacao);
	}
	
}
