package br.com.alugometro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alugometro.dao.TokenDAO;
import br.com.alugometro.domain.Token;
import br.com.alugometro.domain.Token.SituacaoToken;
import br.com.alugometro.dto.TokenDTO;
import br.com.alugometro.exception.TokenInvalidoException;
import br.com.alugometro.mapper.UsuarioMapper;

@Service
public class TokenService {

	@Autowired
	TokenDAO tokenDAO;
	
	public void salvarToken(TokenDTO dto){
		Token token = new Token();
		token.setUsuario(UsuarioMapper.paraEntidade(dto.getUsuario()));
		token.setToken(dto.getToken());
		token.setSituacao(SituacaoToken.ATIVO);
		
		this.tokenDAO.salvarTokenRecuperacaoSenha(token);
	}
	
	public void invalidarToken(TokenDTO dto) throws TokenInvalidoException{
		if(dto.getSituacao() != SituacaoToken.INATIVO){
			Token token = new Token();
			token.setIdToken(dto.getIdToken());
			token.setUsuario(UsuarioMapper.paraEntidade(dto.getUsuario()));
			token.setToken(dto.getToken());
			token.setSituacao(SituacaoToken.INATIVO);
			
			this.tokenDAO.anularToken(token);
		}else{
			throw new TokenInvalidoException();
		}
	}

	public TokenDTO buscarToken(String tokenUsuario) {
		Token token = this.tokenDAO.buscarToken(tokenUsuario);
		TokenDTO tokenDTO = new TokenDTO(token);
		
		return tokenDTO;
	}
	
}
