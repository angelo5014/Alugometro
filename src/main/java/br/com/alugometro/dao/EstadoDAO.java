package br.com.alugometro.dao;

import org.springframework.stereotype.Repository;

import br.com.alugometro.domain.Estado;

@Repository
public class EstadoDAO extends AbstractDAO {

	public Estado encontrarPorId(Long idEstado) {
		return em.find(Estado.class, idEstado);
	}
}
