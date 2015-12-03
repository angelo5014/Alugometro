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
@Table(name = "Foto")
@SequenceGenerator(name = Foto.SEQUENCE_NAME, sequenceName = Foto.SEQUENCE_NAME, allocationSize = 1)
public class Foto {
	
	public static final String SEQUENCE_NAME = "SEQ_Foto";
	
	@Id
	@Column(name = "Id_Foto")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
	private Long idFoto;
	
	@Column(name = "Url")
	@Basic(optional = false)
	private String url;
	
	@ManyToOne
	@JoinColumn(name = "Id_Anuncio")
	private Anuncio anuncio;

	public Long getIdFoto() {
		return idFoto;
	}

	public void setIdFoto(Long idFoto) {
		this.idFoto = idFoto;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Anuncio getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}
	
}
