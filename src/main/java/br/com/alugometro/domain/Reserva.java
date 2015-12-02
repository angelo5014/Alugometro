package br.com.alugometro.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Reserva")
@SequenceGenerator(name = Reserva.SEQUENCE_NAME,sequenceName = Reserva.SEQUENCE_NAME, allocationSize = 1)
public class Reserva {
	
	public final static String SEQUENCE_NAME = "SEQ_reserva";
	
	@Id
	@Column(name = "IdReserva")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
	private Long idReserva;
	
	@ManyToOne
	@Column(name = "IdUsuario")
	@Basic(optional = false)
	private Usuario usuario;
	
	@ManyToOne
	@Column(name = "IdAnuncio")
	@Basic(optional = false)
	private Anuncio anuncio;
	
	@Column(name = "DataInicio")
	@Basic(optional = false)
	private Date dataInicio;
	
	@Column(name = "DataFim")
	@Basic(optional = false)
	private Date dataFim;
	
	@Column(name = "ValorDia")
	@Basic(optional = false)
	private BigDecimal valorDia;
	
	@Column(name = "ValorTotal")
	@Basic(optional = false)
	private BigDecimal valorTotal;
	
	@Column(name = "Situacao")
	@Basic(optional = false)
	private SituacaoReserva situacao;
	
	public enum SituacaoReserva{
		PENDENTE, PROCESSANDO, ENCERRADA, CANCELADA;
	}
	
}
