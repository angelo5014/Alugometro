package br.com.alugometro.mapper;

import br.com.alugometro.domain.Usuario;
import br.com.alugometro.dto.UsuarioDTO;

public class UsuarioMapper {

	public static UsuarioDTO paraDTO(Usuario entidade){
		UsuarioDTO dto = new UsuarioDTO();
		
		dto.setIdUsuario(entidade.getIdUsuario());
		dto.setNome(entidade.getNome());
		dto.setSobrenome(entidade.getSobrenome());
		dto.setEmail(entidade.getEmail());
		dto.setSenha(entidade.getSenha());
		dto.setSituacao(entidade.getSituacao());
		dto.setPermissao(entidade.getPermissao());
		
		return dto;
	}
	
	public static Usuario paraEntidade(UsuarioDTO dto){
		Usuario entidade = new Usuario();
		
		entidade.setIdUsuario(dto.getIdUsuario());
		entidade.setNome(dto.getNome());
		entidade.setSobrenome(dto.getSobrenome());
		entidade.setEmail(dto.getEmail());
		entidade.setSenha(dto.getSenha());
		entidade.setSituacao(dto.getSituacao());
		entidade.setPermissao(dto.getPermissao());
		
		return entidade;
	}
}
