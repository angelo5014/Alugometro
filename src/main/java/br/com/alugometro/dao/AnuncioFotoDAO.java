package br.com.alugometro.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.alugometro.domain.AnuncioFoto;

@Repository
public class AnuncioFotoDAO extends AbstractDAO {

	public List<AnuncioFoto> encontrarPorIdAnuncio(Long idAnuncio) {
		return em.createQuery("FROM AnuncioFoto a WHERE a.anuncio.idAnuncio = :idAnuncio", AnuncioFoto.class)
				.setParameter("idAnuncio", idAnuncio)
				.getResultList();
	}
	
	@Transactional
	public AnuncioFoto salvar(AnuncioFoto anuncioFoto) {
		if(anuncioFoto.getIdAnuncioFoto() == null){
			em.persist(anuncioFoto);
			return anuncioFoto;
		}
		em.merge(anuncioFoto);
		return anuncioFoto;
	}
	
}
