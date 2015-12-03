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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "Usuario")
@SequenceGenerator(name = Anuncio.SEQUENCE_NAME, sequenceName = Anuncio.SEQUENCE_NAME, allocationSize = 1)
public class Usuario {

	public static final String SEQUENCE_NAME = "SEQ_Usuario";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
	@Column(name = "IdUsuario")
	private Long idUsuario;

	//TODO : adicionar tabela de username prória
	@OneToOne
	@JoinColumn(name = "IdUser")
	private String user;
	
	@Column(name = "Email")
	@Basic(optional = false)
	@Length(max = 250)
	private String email;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "Situacao")
	private SituacaoUsuario situacao;
	
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public SituacaoUsuario getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoUsuario situacao) {
		this.situacao = situacao;
	}

	public enum SituacaoUsuario{
		INATIVO, ATIVO;
	}
	
}
