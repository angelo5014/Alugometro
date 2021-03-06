package br.com.alugometro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.alugometro.domain.Federacao;

@Repository
public class FederacaoDAO extends AbstractDAO {

	public Federacao encontrarPorId(Long idFederacao) {
		return em.find(Federacao.class, idFederacao);
	}
	
	public List<Federacao> listarTodos() {
		return em.createQuery("FROM Federecao", Federacao.class)
				.getResultList();
	}
	
}
