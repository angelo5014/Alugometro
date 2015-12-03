package br.com.alugometro.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "Federacao")
public class Federacao {

	public Federacao() {
	}
	
	public Federacao(Long idFederacao) {
		this.idFederacao = idFederacao;
	}
	
	@Id
	@Column(name = "Id_Federacao")
	private Long idFederacao;
	
	@Column(name = "Nome")
	@Length(max = 300)
	@Basic(optional = false)
	private String nome;

	public Long getIdFederacao() {
		return idFederacao;
	}

	public void setIdFederacao(Long idFederacao) {
		this.idFederacao = idFederacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
