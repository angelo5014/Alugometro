package br.com.alugometro.dao;

import org.springframework.stereotype.Repository;

import br.com.alugometro.domain.TipoAcomodacao;

@Repository
public class TipoAcomodacaoDAO extends AbstractDAO {

	public TipoAcomodacao encontrarPorId(Long idTipoAcomodacao) {
		return em.find(TipoAcomodacao.class, idTipoAcomodacao);
	}
}
