package br.com.alugometro.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "Federacao")
public class Federacao {

	@Id
	@Column(name = "IdFederacao")
	private Long idFederacao;
	
	@Length(max = 300)
	@Column(name = "Nome")
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
