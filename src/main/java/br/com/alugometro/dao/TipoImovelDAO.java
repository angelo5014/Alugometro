package br.com.alugometro.dao;

import org.springframework.stereotype.Repository;

import br.com.alugometro.domain.TipoImovel;

@Repository
public class TipoImovelDAO extends AbstractDAO {

	public TipoImovel encontrarPorId(Long idTipoImovel) {
		return em.find(TipoImovel.class, idTipoImovel);
	}
}
