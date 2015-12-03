package br.com.alugometro.dao;

import org.springframework.stereotype.Repository;

import br.com.alugometro.domain.Anuncio;

@Repository
public class AnuncioDAO extends AbstractDAO {

	public Anuncio encontrarPorId(Long idAnuncio) {
		return em.find(Anuncio.class, idAnuncio);
	}
	
}
