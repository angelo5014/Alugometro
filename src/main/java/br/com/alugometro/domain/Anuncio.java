package br.com.alugometro.domain;

import java.math.BigDecimal;
import java.util.Date;

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
@Table(name = "Anuncio")
@SequenceGenerator(name = Anuncio.SEQUENCE_NAME, sequenceName = Anuncio.SEQUENCE_NAME, allocationSize = 1)
public class Anuncio {
	
	public static final String SEQUENCE_NAME = "SEQ_Anuncio";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
	@Column(name = "Id_Anuncio")
	private Long idAnuncio;
	
	@ManyToOne
	@JoinColumn(name = "Id_Usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "Tipo_Imovel")
	@Basic(optional = false)
	private TipoImovel tipoImovel;
	
	@ManyToOne
	@JoinColumn(name = "Tipo_Acomodacao")
	@Basic(optional = false)
	private TipoAcomodacao tipoAcomodacao;
	
	@ManyToOne
	@JoinColumn(name = "Id_Cidade")
	private Cidade cidade;
	
	@Column(name = "Data_Inicio")
	@Basic(optional = false)
	private Date dataInicio;
	
	@Column(name = "Data_Fim")
	@Basic(optional = false)
	private Date dataFim;
	
	@Column(name = "Diaria")
	@Basic(optional = false)
	private BigDecimal diaria;
	
	@Column(name = "Descricao_Capa", length = 300)
	@Basic(optional = false)
	private String descricaoCapa;
	
	@Column(name = "Descricao_Detalhada", length = 1000)
	@Basic(optional = false)
	private String descricaoDetalhada;
	
	@ManyToOne
	@JoinColumn(name = "Foto_Capa")
	@Basic(optional = false)
	private Foto fotoCapa;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "Situacao", length = 1)
	private SituacaoAnuncio situacao;
	
	public static enum SituacaoAnuncio {
		INDISPONIVEL, DISPONIVEL
	}

	public Long getIdAnuncio() {
		return idAnuncio;
	}

	public void setIdAnuncio(Long idAnuncio) {
		this.idAnuncio = idAnuncio;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TipoImovel getTipoImovel() {
		return tipoImovel;
	}

	public void setTipoImovel(TipoImovel tipoImovel) {
		this.tipoImovel = tipoImovel;
	}

	public TipoAcomodacao getTipoAcomodacao() {
		return tipoAcomodacao;
	}

	public void setTipoAcomodacao(TipoAcomodacao tipoAcomodacao) {
		this.tipoAcomodacao = tipoAcomodacao;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public BigDecimal getDiaria() {
		return diaria;
	}

	public void setDiaria(BigDecimal diaria) {
		this.diaria = diaria;
	}

	public String getDescricaoCapa() {
		return descricaoCapa;
	}

	public void setDescricaoCapa(String descricaoCapa) {
		this.descricaoCapa = descricaoCapa;
	}

	public String getDescricaoDetalhada() {
		return descricaoDetalhada;
	}

	public void setDescricaoDetalhada(String descricaoDetalhada) {
		this.descricaoDetalhada = descricaoDetalhada;
	}

	public Foto getFotoCapa() {
		return fotoCapa;
	}

	public void setFotoCapa(Foto fotoCapa) {
		this.fotoCapa = fotoCapa;
	}

	public SituacaoAnuncio getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoAnuncio situacao) {
		this.situacao = situacao;
	}
	
}
