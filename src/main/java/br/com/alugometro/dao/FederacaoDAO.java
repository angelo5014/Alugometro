package br.com.alugometro.dao;

import org.springframework.stereotype.Repository;

import br.com.alugometro.domain.Federacao;

@Repository
public class FederacaoDAO extends AbstractDAO {

	public Federacao encontrarPorId(Long idFederacao) {
		return em.find(Federacao.class, idFederacao);
	}
}
