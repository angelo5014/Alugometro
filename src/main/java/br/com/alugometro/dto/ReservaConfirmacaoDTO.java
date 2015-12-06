package br.com.alugometro.dto;

import java.math.BigDecimal;
import java.util.Date;

import br.com.alugometro.domain.TipoAcomodacao;
import br.com.alugometro.domain.TipoImovel;

public class ReservaConfirmacaoDTO {
	
	private Long idUsuarioLocando;
	private Long idAnuncio;
	private String nomeLocador;
	private String local;
	private TipoImovel tipoImovel;
	private TipoAcomodacao tipoAcomodacao;
	private String dataInicio;
	private String dataFim;
	private BigDecimal diaria;
	private BigDecimal total;
	
	
	public Long getIdUsuarioLocando() {
		return idUsuarioLocando;
	}
	public void setIdUsuarioLocando(Long idUsuarioLocando) {
		this.idUsuarioLocando = idUsuarioLocando;
	}
	public Long getIdAnuncio() {
		return idAnuncio;
	}
	public void setIdAnuncio(Long idAnuncio) {
		this.idAnuncio = idAnuncio;
	}
	public String getNomeLocador() {
		return nomeLocador;
	}
	public void setNomeLocador(String nomeLocador) {
		this.nomeLocador = nomeLocador;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
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
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getDataFim() {
		return dataFim;
	}
	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}
	public BigDecimal getDiaria() {
		return diaria;
	}
	public void setDiaria(BigDecimal diaria) {
		this.diaria = diaria;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
}
