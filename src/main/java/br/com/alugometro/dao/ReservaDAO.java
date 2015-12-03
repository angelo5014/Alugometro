package br.com.alugometro.dao;

import org.springframework.stereotype.Repository;

import br.com.alugometro.domain.Reserva;

@Repository
public class ReservaDAO extends AbstractDAO {

	public Reserva encontrarPorId(Long idReserva) {
		return em.find(Reserva.class, idReserva);
	}
}
