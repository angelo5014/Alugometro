package br.com.alugometro.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "Anuncio_Foto")
public class AnuncioFoto {
	
	@Id
	@Column(name = "Id_Anuncio_Foto")
	private Long idAnuncioFoto;
	
	@ManyToOne
	@JoinColumn(name = "Id_Anuncio")
	private Anuncio anuncio;
	
	@OneToMany
	@JoinColumn(name = "Id_Foto")
	private List<Foto> fotos;
	
}
