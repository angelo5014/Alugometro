package br.com.alugometro.dao;

import org.springframework.stereotype.Repository;

import br.com.alugometro.domain.Cidade;

@Repository
public class CidadeDAO extends AbstractDAO {

	public Cidade encontrarPorId(Long idCidade) {
		return em.find(Cidade.class, idCidade);
	}
	
}
