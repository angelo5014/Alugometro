package br.com.alugometro.dao;


import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.alugometro.domain.AnuncioFoto;

@Repository
public class AnuncioFotoDAO extends AbstractDAO{

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
