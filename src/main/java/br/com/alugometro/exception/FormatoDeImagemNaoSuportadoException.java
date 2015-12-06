package br.com.alugometro.exception;

@SuppressWarnings("serial")
public class FormatoDeImagemNaoSuportadoException extends AbstractException {
	
	public FormatoDeImagemNaoSuportadoException() {
		this.mensagem = "Somente imagens são suportads";
	}
	
}
