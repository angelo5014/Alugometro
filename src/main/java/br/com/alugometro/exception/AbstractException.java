package br.com.alugometro.exception;

public class AbstractException extends Exception{
	
	protected String mensagem;
	
	public String getMensagem() {
		return this.mensagem;
	}
}
