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
@Table(name = "Anuncio_Foto")
@SequenceGenerator(name = AnuncioFoto.SEQUENCE_NAME, sequenceName = AnuncioFoto.SEQUENCE_NAME, allocationSize = 1)
public class AnuncioFoto {
	
	public static final String SEQUENCE_NAME = "SEQ_Anuncio_Foto";
	
	@Id
	@Column(name = "Id_Anuncio_Foto")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
	private Long idAnuncioFoto;
	
	@ManyToOne
	@JoinColumn(name = "Id_Anuncio")
	@Basic(optional = false)
	private Anuncio anuncio;
	
	@ManyToOne
	@JoinColumn(name = "Id_Foto")
	@Basic(optional = false)
	private Foto foto;

	public Long getIdAnuncioFoto() {
		return idAnuncioFoto;
	}

	public void setIdAnuncioFoto(Long idAnuncioFoto) {
		this.idAnuncioFoto = idAnuncioFoto;
	}

	public Anuncio getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}

	public Foto getFoto() {
		return foto;
	}

	public void setFoto(Foto foto) {
		this.foto = foto;
	}
	
}
