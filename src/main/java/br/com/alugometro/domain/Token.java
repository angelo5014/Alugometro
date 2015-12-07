package br.com.alugometro.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Token")
@SequenceGenerator(name = Token.SEQUENCE_NAME, sequenceName = Token.SEQUENCE_NAME, allocationSize = 1)
public class Token {
	
	public static final String SEQUENCE_NAME = "SEQ_Token";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
	@Column(name = "Id_Token")
	private Long idToken;
	
	@ManyToOne
	@JoinColumn(name = "Id_Usuario")
	@Basic(optional = false)
	private Usuario usuario;
	
	@Column(name = "Token")
	@Basic(optional = false)
	private String token;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "Situacao_Token", length = 1)
	private SituacaoToken situacao;
	
	public static enum SituacaoToken {
		INATIVO, ATIVO
	}

	public Long getIdToken() {
		return idToken;
	}

	public void setIdToken(Long idToken) {
		this.idToken = idToken;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
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
