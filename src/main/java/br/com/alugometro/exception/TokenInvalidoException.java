package br.com.alugometro.exception;

public class TokenInvalidoException extends AbstractException{

	private static final long serialVersionUID = 1L;

	public TokenInvalidoException(){
		this.mensagem = "Token inválido!";
	}
	
}
