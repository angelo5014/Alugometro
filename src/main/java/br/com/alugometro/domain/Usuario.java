package br.com.alugometro.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "Usuario")
@SequenceGenerator(name = Usuario.SEQUENCE_NAME, sequenceName = Usuario.SEQUENCE_NAME, allocationSize = 1)
public class Usuario {

	public static final String SEQUENCE_NAME = "SEQ_Usuario";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
	@Column(name = "Id_Usuario")
	private Long idUsuario;

	@Column(name = "Nome")
	@Basic(optional = false)
	private String nome;
	
	@Column(name = "Sobrenome")
	@Basic(optional = false)
	private String sobrenome;
	
	@Column(name = "Email")
	@Basic(optional = false)
	private String email;
	
	@Column(name = "Senha")
	@Basic(optional = false)
	private String senha;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "Situacao")
	@Basic(optional = false)
	private SituacaoUsuario situacao;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "Permissao")
	@Basic(optional = false)
	private PermissaoUsuario permissao;
	
	public Usuario() {
	}
	
	public Usuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public SituacaoUsuario getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoUsuario situacao) {
		this.situacao = situacao;
	}

	public PermissaoUsuario getPermissao() {
		return permissao;
	}

	public void setPermissao(PermissaoUsuario permissao) {
		this.permissao = permissao;
	}

	public enum SituacaoUsuario{
		INATIVO, ATIVO;
	}
	
	public enum PermissaoUsuario{
		ROLE_USER
	}
	
}
