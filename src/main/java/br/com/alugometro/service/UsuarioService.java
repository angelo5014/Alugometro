package br.com.alugometro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alugometro.dao.UsuarioDAO;
import br.com.alugometro.domain.Usuario;
import br.com.alugometro.dto.UsuarioDTO;
import br.com.alugometro.exception.AbstractException;
import br.com.alugometro.exception.UsuarioNaoEncontradoException;
import br.com.alugometro.mapper.UsuarioMapper;

@Service
public class UsuarioService {

	private UsuarioDAO usuarioDAO;
	
	@Autowired
	public UsuarioService(UsuarioDAO usuarioDAO){
		this.usuarioDAO = usuarioDAO;
	}
	
	public UsuarioDTO buscarPorId(Long idUsuario) throws UsuarioNaoEncontradoException{
		return UsuarioMapper.paraDTO(usuarioDAO.buscarPorId(idUsuario));
	}
	
	public UsuarioDTO buscarPorEmail(String email) throws AbstractException{
		return UsuarioMapper.paraDTO(usuarioDAO.buscarPorEmail(email));
	}
	
	public UsuarioDTO salvar(UsuarioDTO usuarioDTO){
		Usuario usuario = UsuarioMapper.paraEntidade(usuarioDTO);
		return UsuarioMapper.paraDTO(usuarioDAO.salvar(usuario));
	}
}
