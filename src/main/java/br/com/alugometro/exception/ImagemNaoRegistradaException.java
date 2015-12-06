package br.com.alugometro.exception;

@SuppressWarnings("serial")
public class ImagemNaoRegistradaException extends AbstractException {
	
	public ImagemNaoRegistradaException() {
		this.mensagem = "A imagem não pode ser registrada por problemas de IO";
	}
	
}
