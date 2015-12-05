package br.com.alugometro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.alugometro.domain.Reserva;

@Repository
public class ReservaDAO extends AbstractDAO {

	public Reserva buscarPorId(Long idReserva) {
		return em.find(Reserva.class, idReserva);
	}
	
	public List<Reserva> buscarPorIdUsuario(Long idUsuario){
		return em.createQuery("FROM Reserva WHERE Id_Usuario = :idUsuario", Reserva.class)
				.setParameter("idUsuario", idUsuario)
				.getResultList();
	}
	
	public Reserva salvar(Reserva entidade){
		if(entidade.getIdReserva() == null){
			em.persist(entidade);
			return entidade;
		}
		
		return em.merge(entidade);
	}
}
