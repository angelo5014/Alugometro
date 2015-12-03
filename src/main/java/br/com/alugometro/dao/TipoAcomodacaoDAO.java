package br.com.alugometro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.alugometro.domain.TipoAcomodacao;

@Repository
public class TipoAcomodacaoDAO extends AbstractDAO {

	public TipoAcomodacao encontrarPorId(Long idTipoAcomodacao) {
		return em.find(TipoAcomodacao.class, idTipoAcomodacao);
	}
	
	public List<TipoAcomodacao> listarTodos() {
		return em.createQuery("FROM TipoAcomodacao", TipoAcomodacao.class)
				.getResultList();
	}
	
}
