package br.com.alugometro.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import br.com.alugometro.domain.Usuario.PermissaoUsuario;
import br.com.alugometro.domain.Usuario.SituacaoUsuario;

public class UsuarioDTO {
	
	private Long idUsuario;
	
	@NotNull
	@NotBlank
	@Length(max = 200)
	private String nome;
	
	@NotNull
	@NotBlank
	@Length(max = 300)
	private String sobrenome;
	
	@NotNull
	@NotBlank
	@Length(max = 250)
	@Email
	private String email;
	
	@NotNull
	@NotBlank
	@Length(max = 32)
	private String senha;
	
	@NotNull
	@NotBlank
	private SituacaoUsuario situacao;
	
	private PermissaoUsuario permissao;

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
	
	public boolean estaAtivo(){
		return this.situacao == SituacaoUsuario.ATIVO;
	}
	
	@Override
	public boolean equals(Object obj){
		UsuarioDTO objetoRecebido = (UsuarioDTO) obj;
		boolean idIgual = this.idUsuario == objetoRecebido.getIdUsuario();
		boolean nomeIgual = this.nome.equals(objetoRecebido.getNome());
		boolean sobrenomeIgual = this.sobrenome.equals(objetoRecebido.getSobrenome());
		boolean emailIgual = this.email.equals(objetoRecebido.getEmail());
		boolean senhaIgual = this.senha.equals(objetoRecebido.getSenha());
		boolean situacaoIgual = this.situacao == objetoRecebido.getSituacao();
		boolean permissaoIgual = this.permissao == objetoRecebido.getPermissao();
		
		
		return idIgual && nomeIgual && sobrenomeIgual && emailIgual && senhaIgual && situacaoIgual && permissaoIgual; 
	}
}
