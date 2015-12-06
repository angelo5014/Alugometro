package br.com.alugometro.dto;

import br.com.alugometro.domain.AnuncioFoto;

public class AnuncioFotoDTO {

	private Long idAnuncioFoto;
	private Long idAnuncio;
	private Long idFoto;
	private String urlFoto;

	public AnuncioFotoDTO(AnuncioFoto anuncioFoto) {
		this.idAnuncioFoto = anuncioFoto.getIdAnuncioFoto();
		this.idAnuncio = anuncioFoto.getAnuncio().getIdAnuncio();
		this.idFoto = anuncioFoto.getFoto().getIdFoto();
		this.urlFoto = anuncioFoto.getFoto().getUrl();
	}

	public Long getIdAnuncioFoto() {
		return idAnuncioFoto;
	}

	public void setIdAnuncioFoto(Long idAnuncioFoto) {
		this.idAnuncioFoto = idAnuncioFoto;
	}

	public Long getIdAnuncio() {
		return idAnuncio;
	}

	public void setIdAnuncio(Long idAnuncio) {
		this.idAnuncio = idAnuncio;
	}

	public Long getIdFoto() {
		return idFoto;
	}

	public void setIdFoto(Long idFoto) {
		this.idFoto = idFoto;
	}

	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}
	
}
