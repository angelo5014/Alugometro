package br.com.alugometro.dto;

import br.com.alugometro.domain.Token;
import br.com.alugometro.domain.Token.SituacaoToken;
import br.com.alugometro.mapper.UsuarioMapper;

public class TokenDTO {
	
	private Long idToken;
	private UsuarioDTO usuario;
	private String token;
	private SituacaoToken situacao;
	
	public TokenDTO(){
		
	}

	public TokenDTO(Token entidade) {
		this.idToken = entidade.getIdToken();
		this.usuario = UsuarioMapper.paraDTO(entidade.getUsuario());
		this.token = entidade.getToken();
		this.situacao = entidade.getSituacao();
	}
	
	public Long getIdToken() {
		return idToken;
	}
	public void setIdToken(Long idToken) {
		this.idToken = idToken;
	}
	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	public SituacaoToken getSituacao() {
		return situacao;
	}
	public void setSituacao(SituacaoToken situacao) {
		this.situacao = situacao;
	}
}
