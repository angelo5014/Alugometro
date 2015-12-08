package br.com.alugometro.dao;

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
		return this.em.createQuery("FROM Token WHERE Token = :token", Token.class)
					.setParameter("token", token)
					.getSingleResult();
	}
}
