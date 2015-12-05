package br.com.alugometro.exception;

@SuppressWarnings("serial")
public class UsuarioNaoEncontradoException extends AbstractException{

	public UsuarioNaoEncontradoException(){
		this.mensagem = "Não foram encontrados registros para a pesquisa.";
	}
}
