package br.com.alugometro.dao;

import java.util.List;

import javax.transaction.Transactional;

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
	
	@Transactional
	public void cancelar(Long idReserva){
		em.createQuery("UPDATE Reserva SET Id_Situacao_Reserva=3 "
				+ "WHERE Id_Reserva = :idReserva")
				.setParameter("idReserva", idReserva)
				.executeUpdate();
	}
	
	@Transactional
	public Reserva salvar(Reserva entidade){
		if(entidade.getIdReserva() == null){
			em.persist(entidade);
			return entidade;
		}
		
		return em.merge(entidade);
	}
	
	public List<Reserva> buscarReservaPorPeriodoESituacao(Reserva reserva){
		return em.createQuery("FROM Reserva WHERE Data_Inicio = :dataInicio AND Data_Fim = :dataFim AND Id_Situacao_Reserva != 4")
				  .setParameter("dataInicio", reserva.getDataInicio())
				  .setParameter("dataFim", reserva.getDataFim())
			   	  .getResultList();
	}
}
