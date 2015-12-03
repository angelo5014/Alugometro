package br.com.alugometro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.alugometro.domain.Cidade;

@Repository
public class CidadeDAO extends AbstractDAO {

	public Cidade encontrarPorId(Long idCidade) {
		return em.find(Cidade.class, idCidade);
	}
	
	public List<Cidade> listarTodos() {
		return em.createQuery("FROM Cidade", Cidade.class)
				.getResultList();
	}
	
}
