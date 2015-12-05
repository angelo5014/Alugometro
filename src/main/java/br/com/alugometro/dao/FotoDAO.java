package br.com.alugometro.dao;

import org.springframework.stereotype.Repository;

import br.com.alugometro.domain.Foto;

@Repository
public class FotoDAO extends AbstractDAO {

	public Foto encontrarPorId(Long idFoto) {
		return em.find(Foto.class, idFoto);
	}
	
	public Foto salvar(Foto foto) {
		if(foto.getIdFoto() == null){
			em.persist(foto);
			return foto;
		}
		em.merge(foto);
		return foto;
	}
	
}
