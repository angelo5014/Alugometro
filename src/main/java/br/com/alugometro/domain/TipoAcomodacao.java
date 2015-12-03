package br.com.alugometro.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "TipoAcomodacao")
public class TipoAcomodacao {

	@Id
	@Column(name = "IdTipoAcomodacao")
	private Long tipoAcomodacao;
	
	@Column(name = "Descricao")
	@Length(max = 50)
	@Basic(optional = false)
	private String descricao;

	public Long getTipoAcomodacao() {
		return tipoAcomodacao;
	}

	public void setTipoAcomodacao(Long tipoAcomodacao) {
		this.tipoAcomodacao = tipoAcomodacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
