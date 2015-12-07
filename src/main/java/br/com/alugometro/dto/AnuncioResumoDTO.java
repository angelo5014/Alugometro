package br.com.alugometro.dto;

import br.com.alugometro.domain.Anuncio;

public class AnuncioResumoDTO {

	private Long idAnuncio;
	private Long idUsuario;
	private String tipoImovel;
	private String preco;
	private String fotoCapa;
	private String descricaoCapa;
	private String cidade;
	private String situacao;
	
	public AnuncioResumoDTO() {
		
	}
	
	public AnuncioResumoDTO(Anuncio anuncio) {
		this.idAnuncio = anuncio.getIdAnuncio();
		this.idUsuario = anuncio.getUsuario().getIdUsuario();
		this.tipoImovel = anuncio.getTipoImovel().getDescricao();
		this.preco = anuncio.getDiaria().toString();
		this.fotoCapa = anuncio.getFotoCapa().getUrl();
		this.descricaoCapa = anuncio.getDescricaoCapa();
		this.cidade = anuncio.getCidade().getNome();
		this.setSituacao(anuncio.getSituacao().toString());
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

	public String getTipoImovel() {
		return tipoImovel;
	}

	public void setTipoImovel(String tipoImovel) {
		this.tipoImovel = tipoImovel;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preço) {
		this.preco = preço;
	}

	public String getFotoCapa() {
		return fotoCapa;
	}

	public void setFotoCapa(String fotoCapa) {
		this.fotoCapa = fotoCapa;
	}

	public String getDescricaoCapa() {
		return descricaoCapa;
	}

	public void setDescricaoCapa(String descricaoCapa) {
		this.descricaoCapa = descricaoCapa;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
}
