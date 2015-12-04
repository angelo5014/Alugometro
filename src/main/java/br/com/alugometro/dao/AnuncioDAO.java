package br.com.alugometro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.alugometro.domain.Anuncio;

@Repository
public class AnuncioDAO extends AbstractDAO {

	public Anuncio encontrarPorId(Long idAnuncio) {
		return em.find(Anuncio.class, idAnuncio);
	}
	
	public List<Anuncio> listarTodos() {
		return em.createQuery("FROM Anuncio", Anuncio.class)
				.getResultList();
	}
	
	public Anuncio salvar(Anuncio anuncio) {
		if(anuncio.getIdAnuncio() == null){
			em.persist(anuncio);
			return anuncio;
		}
		em.merge(anuncio);
		return anuncio;
	}
	
}
