package br.com.alugometro.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.alugometro.domain.Token;

@Repository
public class TokenDAO extends AbstractDAO{
	
	@Transactional
	public void salvarTokenRecuperacaoSenha(Token token){
		this.em.persist(token);
	}
	
	public Token buscarToken(String token){
		List<Token> lista = this.em.createQuery("FROM Token WHERE token = :token")
					.setParameter("token", token)
					.getResultList();
		
		return lista.get(0);
	}
	
	@Transactional
	public void anularToken(Token token) {
		this.em.merge(token);
	}
}
