package br.com.alugometro.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Anuncio_Foto")
@SequenceGenerator(name = AnuncioFoto.SEQUENCE_NAME, sequenceName = AnuncioFoto.SEQUENCE_NAME, allocationSize = 1)
public class AnuncioFoto {
	
	public static final String SEQUENCE_NAME = "SEQ_Anuncio_Foto";
	
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
