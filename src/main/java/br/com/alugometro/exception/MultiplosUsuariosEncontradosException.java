package br.com.alugometro.exception;

@SuppressWarnings("serial")
public class MultiplosUsuariosEncontradosException extends AbstractException{
	
	public MultiplosUsuariosEncontradosException(){
		this.mensagem = "Foram encontrados mais de um resultado para a pesquisa de retorno único.";
	}
}
