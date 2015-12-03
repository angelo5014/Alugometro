package br.com.alugometro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.alugometro.domain.Estado;

@Repository
public class EstadoDAO extends AbstractDAO {

	public Estado encontrarPorId(Long idEstado) {
		return em.find(Estado.class, idEstado);
	}
	
	public List<Estado> listarTodos() {
		return em.createQuery("FROM Estado", Estado.class)
				.getResultList();
	}
	
}
