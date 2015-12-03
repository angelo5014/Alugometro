package br.com.alugometro.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tipo_Acomodacao")
public class TipoAcomodacao {

	@Id
	@Column(name = "Id_Tipo_Acomodacao")
	private Long idTipoAcomodacao;
	
	@Column(name = "Descricao", length = 50)
	@Basic(optional = false)
	private String descricao;

	public Long getIdTipoAcomodacao() {
		return idTipoAcomodacao;
	}

	public void setIdTipoAcomodacao(Long idTipoAcomodacao) {
		this.idTipoAcomodacao = idTipoAcomodacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
