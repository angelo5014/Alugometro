package br.com.alugometro.dto;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.web.multipart.MultipartFile;

public class AnuncioCadastroDTO {

	private Long idAnuncio;
	
	private Long idUsuario;
	
	private Long idTipoImovel;

	private Long idTipoAcomodacao;
	
	@NumberFormat
	private int numeroPessoas;
	
	private Long idCidade;

	@DateTimeFormat
	private Date dataInicio;
	
	@DateTimeFormat
	private Date dataFim;
	
	@NumberFormat
	private BigDecimal diaria;
	
	@NotBlank
	private String descricaoCapa;
	
	@NotBlank
	private String descricaoDetalhada;
	
	private MultipartFile fotoCapa;
	
	private String situacao;

	public Long getIdAnuncio() {
		return idAnuncio;
	}

	public void setIdAnuncio(Long idAnuncio) {
		this.idAnuncio = idAnuncio;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getIdTipoImovel() {
		return idTipoImovel;
	}

	public void setIdTipoImovel(Long idTipoImovel) {
		this.idTipoImovel = idTipoImovel;
	}

	public Long getIdTipoAcomodacao() {
		return idTipoAcomodacao;
	}

	public void setIdTipoAcomodacao(Long idTipoAcomodacao) {
		this.idTipoAcomodacao = idTipoAcomodacao;
	}

	public int getNumeroPessoas() {
		return numeroPessoas;
	}

	public void setNumeroPessoas(int numeroPessoas) {
		this.numeroPessoas = numeroPessoas;
	}

	public Long getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(Long idCidade) {
		this.idCidade = idCidade;
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

	public MultipartFile getFotoCapa() {
		return fotoCapa;
	}

	public void setFotoCapa(MultipartFile fotoCapa) {
		this.fotoCapa = fotoCapa;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
}
