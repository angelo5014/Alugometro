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
@Table(name = "Reserva")
@SequenceGenerator(name = Reserva.SEQUENCE_NAME,sequenceName = Reserva.SEQUENCE_NAME, allocationSize = 1)
public class Reserva {
	
	public final static String SEQUENCE_NAME = "SEQ_reserva";
	
	@Id
	@Column(name = "Id_Reserva")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
	private Long idReserva;
	
	@ManyToOne
	@JoinColumn(name = "Id_Usuario")
	@Basic(optional = false)
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "Id_Anuncio")
	@Basic(optional = false)
	private Anuncio anuncio;
	
	@Column(name = "Data_Inicio")
	@Basic(optional = false)
	private Date dataInicio;
	
	@Column(name = "Data_Fim")
	@Basic(optional = false)
	private Date dataFim;
	
	@Column(name = "Valor_Diaria")
	@Basic(optional = false)
	private BigDecimal valorDia;
	
	@Column(name = "Valor_Total")
	@Basic(optional = false)
	private BigDecimal valorTotal;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "Id_Situacao_Reserva")
	@Basic(optional = false)
	private SituacaoReserva situacao;
	
	public enum SituacaoReserva {
		PENDENTE, PROCESSANDO, ENCERRADA, CANCELADA;
	}
	
	public Long getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Long idReserva) {
		this.idReserva = idReserva;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Anuncio getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
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

	public SituacaoReserva getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoReserva situacao) {
		this.situacao = situacao;
	}
	
	@Override
	public boolean equals(Object obj){
		Reserva obtido = (Reserva) obj;
		boolean mesmoId = this.idReserva == obtido.getIdReserva();
		boolean mesmoUsuario = this.usuario.getIdUsuario() == obtido.getUsuario().getIdUsuario();
		boolean mesmoAnuncio = this.anuncio.getIdAnuncio() == obtido.getAnuncio().getIdAnuncio();
		boolean mesmaDataInicio = this.dataInicio.compareTo(obtido.getDataInicio()) == 0;
		boolean mesmaDataFim = this.dataFim.compareTo(obtido.getDataFim()) == 0;
		boolean mesmoValorDia = this.valorDia.intValue() == obtido.getValorDia().intValue();
		boolean mesmoValorTotal = this.valorTotal.intValue() == obtido.getValorTotal().intValue();
		boolean mesmaSituacao = this.situacao == obtido.getSituacao();
		
		return mesmoId && mesmoUsuario && mesmoAnuncio && mesmaDataInicio && mesmaDataFim && mesmoValorDia
				&& mesmoValorTotal && mesmaSituacao;
	}
}
