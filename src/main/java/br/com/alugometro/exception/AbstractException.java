package br.com.alugometro.exception;

@SuppressWarnings("serial")
public class AbstractException extends Exception{
	
	protected String mensagem;
	
	public String getMensagem() {
		return this.mensagem;
	}
}
