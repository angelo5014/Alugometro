package br.com.alugometro.exception;

public class UsuarioNaoEncontradoException extends AbstractException{

	public UsuarioNaoEncontradoException(){
		this.mensagem = "Não foram encontrados registros para a pesquisa.";
	}
}
