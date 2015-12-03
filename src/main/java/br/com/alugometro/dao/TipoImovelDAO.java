package br.com.alugometro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.alugometro.domain.TipoImovel;

@Repository
public class TipoImovelDAO extends AbstractDAO {

	public TipoImovel encontrarPorId(Long idTipoImovel) {
		return em.find(TipoImovel.class, idTipoImovel);
	}
	
	public List<TipoImovel> listarTodos() {
		return em.createQuery("FROM Tipo_Imovel", TipoImovel.class)
				.getResultList();
	}
	
}
