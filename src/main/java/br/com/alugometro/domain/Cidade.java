package br.com.alugometro.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Cidade")
@SequenceGenerator(name = Cidade.SEQUENCE_NAME, sequenceName = Cidade.SEQUENCE_NAME, allocationSize = 1)
public class Cidade {
	
	public static final String SEQUENCE_NAME = "SEQ_Cidade";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
	@Column(name = "Id_Cidade")
	private Long idCidade;
	
	@Column(name = "Nome", length = 300)
	@Basic(optional = false)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "Id_Estado")
	private Estado estado;

	public Long getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(Long idCidade) {
		this.idCidade = idCidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
}
