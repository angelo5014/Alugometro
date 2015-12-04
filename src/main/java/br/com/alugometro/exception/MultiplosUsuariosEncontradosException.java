package br.com.alugometro.exception;

public class MultiplosUsuariosEncontradosException extends AbstractException{
	
	public MultiplosUsuariosEncontradosException(){
		this.mensagem = "Foram encontrados mais de um resultado para a pesquisa de retorno único.";
	}
}
