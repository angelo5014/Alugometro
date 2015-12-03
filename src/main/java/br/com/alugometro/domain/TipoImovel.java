package br.com.alugometro.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "Tipo_Imovel")
public class TipoImovel {
	
	@Id
	@Column(name = "Id_Tipo_Imovel")
	private Long idTipoImovel;
	
	@Column(name = "Descricao")
	@Length(max = 50)
	@Basic(optional = false)
	private String descricao;

	public Long getIdTipoImovel() {
		return idTipoImovel;
	}

	public void setIdTipoImovel(Long idTipoImovel) {
		this.idTipoImovel = idTipoImovel;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
