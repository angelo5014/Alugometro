package br.com.alugometro.exception;

public class TokenInvalidoException extends AbstractException{

	public TokenInvalidoException(){
		this.mensagem = "Token inválido!";
	}
	
}
