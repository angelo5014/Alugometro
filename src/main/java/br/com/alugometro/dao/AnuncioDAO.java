package br.com.alugometro.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

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
	
	@Transactional
	public int desativar(Long idAnuncio) {
		return em.createQuery("UPDATE Anuncio SET Id_Situacao_Anuncio=0 WHERE Id_Anuncio=:idAnuncio")
			.setParameter("idAnuncio", idAnuncio).executeUpdate();
	}
	
	public List<Anuncio> listarPorCidade(String cidade) {
		return em.createQuery("FROM Anuncio a WHERE lower(a.cidade.nome) LIKE :cidade AND a.situacao = 1", Anuncio.class)
				.setParameter("cidade", cidade.toLowerCase() + "%")
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

		sql.append(" AND a.situacao = 1");
		
		TypedQuery<Anuncio> query = em.createQuery(sql.toString(), Anuncio.class);

		Set<Map.Entry<String, Object>> set = parameters.entrySet();
		Iterator<Map.Entry<String, Object>> iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, Object> mentry = (Map.Entry<String, Object>) iterator.next();
			query.setParameter(mentry.getKey().toString(), mentry.getValue());
		}
		
		return query.getResultList();
	}
	
	@Transactional
	public Anuncio salvar(Anuncio anuncio) {
		if(anuncio.getIdAnuncio() == null){
			em.persist(anuncio);
			return anuncio;
		}
		em.merge(anuncio);
		return anuncio;
	}
	
}
