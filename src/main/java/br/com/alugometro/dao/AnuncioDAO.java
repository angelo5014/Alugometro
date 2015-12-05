package br.com.alugometro.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.alugometro.domain.Anuncio;

@Repository
public class AnuncioDAO extends AbstractDAO {

	public Anuncio buscarPorId(Long idAnuncio) {
		return em.find(Anuncio.class, idAnuncio);
	}
	
	public List<Anuncio> listarTodos() {
		return em.createQuery("FROM Anuncio", Anuncio.class)
				.getResultList();
	}
	
	public List<Anuncio> listarPorCidade(String cidade) {
		return em.createQuery("FROM Anuncio a WHERE a.cidade.nome LIKE :cidade", Anuncio.class)
				.setParameter("cidade", cidade + "%")
				.getResultList();
	}
	
	public List<Anuncio> listarPorPrecoETipoImovelETipoAcomodacaoECidade(
				BigDecimal precoMenor, BigDecimal precoMaior, Long idTipoImovel, Long idTipoAcomodacao, Long idCidade) {
		
		StringBuilder sql = new StringBuilder("FROM Anuncio a WHERE 1=1");

		HashMap<String, Object> parameters = new HashMap<String, Object>();

		if (precoMenor != null && precoMaior != null) {
			sql.append(" AND a.diaria BETWEEN :precoMenor AND :precoMaior");
			parameters.put("precoMenor", precoMenor);
			parameters.put("precoMaior", precoMaior);
		}
		if (idTipoImovel != null) {
			sql.append(" AND a.tipoImovel.idTipoImovel = :idTipoImovel");
			parameters.put("idTipoImovel", idTipoImovel);
		}
		if (idTipoAcomodacao != null) {
			sql.append(" AND a.tipoAcomodacao.idTipoAcomodacao = :idTipoAcomodacao");
			parameters.put("idTipoAcomodacao", idTipoAcomodacao);
		}
		if (idCidade != null) {
			sql.append(" AND a.cidade.idCidade = :idCidade");
			parameters.put("idCidade", idCidade);
		}

		TypedQuery<Anuncio> query = em.createQuery(sql.toString(), Anuncio.class);

		Set set = parameters.entrySet();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry mentry = (Map.Entry) iterator.next();
			query.setParameter(mentry.getKey().toString(), mentry.getValue());
		}
		
		return query.getResultList();
	}
	
	public Anuncio salvar(Anuncio anuncio) {
		if(anuncio.getIdAnuncio() == null){
			em.persist(anuncio);
			return anuncio;
		}
		em.merge(anuncio);
		return anuncio;
	}
	
}
