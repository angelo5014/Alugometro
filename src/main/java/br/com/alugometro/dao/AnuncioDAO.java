package br.com.alugometro.dao;

import java.util.List;

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
		return em.createQuery("FROM Anuncio a WHERE a.cidade.nome = :cidade", Anuncio.class)
				.setParameter("cidade", cidade)
				.getResultList();
	}
	
	// Exemplo de busca com varios parametros
	/*
	public List<Anuncio> listarPorCidade(String material, String servico) {
		StringBuilder sql = new StringBuilder("FROM Produto p WHERE 1=1");

		HashMap<String, Object> parameters = new HashMap<String, Object>();

		if (material != null) {
			sql.append(" AND p.material.descricao LIKE :material");
			parameters.put("material", material);
		}
		if (servico != null) {
			sql.append(" AND p.servico.descricao LIKE :servico");
			parameters.put("servico", servico);
		}

		TypedQuery<Produto> query = em.createQuery(sql.toString(), Produto.class);

		Set set = parameters.entrySet();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry mentry = (Map.Entry) iterator.next();
			query.setParameter(mentry.getKey().toString(), mentry.getValue() + "%");
		}
		
		return query.getResultList();
	}
	*/
	
	public Anuncio salvar(Anuncio anuncio) {
		if(anuncio.getIdAnuncio() == null){
			em.persist(anuncio);
			return anuncio;
		}
		em.merge(anuncio);
		return anuncio;
	}
	
}
