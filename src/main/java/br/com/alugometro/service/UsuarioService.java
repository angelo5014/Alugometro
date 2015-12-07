package br.com.alugometro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import br.com.alugometro.dao.UsuarioDAO;
import br.com.alugometro.domain.Usuario;
import br.com.alugometro.domain.Usuario.PermissaoUsuario;
import br.com.alugometro.domain.Usuario.SituacaoUsuario;
import br.com.alugometro.dto.UsuarioDTO;
import br.com.alugometro.exception.AbstractException;
import br.com.alugometro.exception.UsuarioNaoEncontradoException;
import br.com.alugometro.mapper.UsuarioMapper;

@Service
public class UsuarioService {

	private UsuarioDAO usuarioDAO;
	private UsuarioSenhaService senhaService;
	
	@Autowired
	public UsuarioService(UsuarioDAO usuarioDAO, UsuarioSenhaService senhaService){
		this.usuarioDAO = usuarioDAO;
		this.senhaService = senhaService;
	}
	
	public Long obterIdDoUsuarioLogado() {
		User usuario = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	
		Usuario usuarioLogado = null;
		try {
			usuarioLogado = this.usuarioDAO.buscarPorEmail(usuario.getUsername());
		} catch (AbstractException e) {
			e.printStackTrace();
		}
		
		return usuarioLogado.getIdUsuario();
	}
	
	public UsuarioDTO buscarPorId(Long idUsuario) throws UsuarioNaoEncontradoException{
		return UsuarioMapper.paraDTO(usuarioDAO.buscarPorId(idUsuario));
	}
	
	public UsuarioDTO buscarPorEmail(String email) throws AbstractException{
		return UsuarioMapper.paraDTO(usuarioDAO.buscarPorEmail(email));
	}
	
	public UsuarioDTO salvar(UsuarioDTO usuarioDTO){
		String senhaCriptografada = senhaService.criptografarSenha(usuarioDTO.getSenha());
		
		usuarioDTO.setSenha(senhaCriptografada);
		usuarioDTO.setSituacao(SituacaoUsuario.ATIVO);
		usuarioDTO.setPermissao(PermissaoUsuario.ROLE_USER);
		
		Usuario usuario = UsuarioMapper.paraEntidade(usuarioDTO);
		
		return UsuarioMapper.paraDTO(usuarioDAO.salvar(usuario));
	}
}
