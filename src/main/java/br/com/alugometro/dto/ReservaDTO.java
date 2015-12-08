package br.com.alugometro.dto;

import java.math.BigDecimal;
import java.util.Date;

public class ReservaDTO {
	
	private Long idReserva;
	private Long idUsuario;
	private Long idAnuncio;
	private String tipoImovel;
	private String cidade;
	private String descricaoCapaAnuncio;
	private Date dataInicio;
	private Date dataFim;
	private BigDecimal valorDia;
	private BigDecimal valorTotal;
	private String situacao;
	
	public Long getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Long idReserva) {
		this.idReserva = idReserva;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getIdAnuncio() {
		return idAnuncio;
	}

	public void setIdAnuncio(Long idAnuncio) {
		this.idAnuncio = idAnuncio;
	}

	public String getDescricaoCapaAnuncio() {
		return descricaoCapaAnuncio;
	}

	public void setDescricaoCapaAnuncio(String descricaoCapaAnuncio) {
		this.descricaoCapaAnuncio = descricaoCapaAnuncio;
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

	public BigDecimal getValorDia() {
		return valorDia;
	}

	public void setValorDia(BigDecimal valorDia) {
		this.valorDia = valorDia;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	public String getTipoImovel() {
		return tipoImovel;
	}

	public void setTipoImovel(String tipoImovel) {
		this.tipoImovel = tipoImovel;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Override
	public boolean equals(Object obj){
		ReservaDTO obtido = (ReservaDTO) obj;
		boolean mesmoId = this.idReserva == obtido.getIdReserva();
		boolean mesmoUsuario = this.idUsuario == obtido.getIdUsuario();
		boolean mesmoAnuncio = this.idAnuncio == obtido.getIdAnuncio();
		boolean mesmaDataInicio = this.dataInicio.compareTo(obtido.getDataInicio()) == 0;
		boolean mesmaDataFim = this.dataFim.compareTo(obtido.getDataFim()) == 0;
		boolean mesmoValorDia = this.valorDia.intValue() == obtido.getValorDia().intValue();
		boolean mesmoValorTotal = this.valorTotal.intValue() == obtido.getValorTotal().intValue();
		boolean mesmaSituacao = this.situacao == obtido.getSituacao();
		
		return mesmoId && mesmoUsuario && mesmoAnuncio && mesmaDataInicio && mesmaDataFim && mesmoValorDia
				&& mesmoValorTotal && mesmaSituacao;
	}
}
