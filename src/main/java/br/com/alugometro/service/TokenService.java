package br.com.alugometro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alugometro.dao.TokenDAO;
import br.com.alugometro.domain.Token;
import br.com.alugometro.domain.Token.SituacaoToken;
import br.com.alugometro.dto.TokenDTO;
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
	
}
