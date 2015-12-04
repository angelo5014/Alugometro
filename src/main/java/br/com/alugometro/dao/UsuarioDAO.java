package br.com.alugometro.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.alugometro.domain.Usuario;
import br.com.alugometro.exception.AbstractException;
import br.com.alugometro.exception.MultiplosUsuariosEncontradosException;
import br.com.alugometro.exception.UsuarioNaoEncontradoException;

@Repository
public class UsuarioDAO extends AbstractDAO{

	public Usuario encontrarPorId(Long idUsuario) throws UsuarioNaoEncontradoException{
		Usuario usuario = this.em.find(Usuario.class, idUsuario);
		
		if(usuario != null){
			return usuario;
		}else{
			throw new UsuarioNaoEncontradoException();
		}
	}
	
	public Usuario encontrarPorEmail(String email) throws AbstractException{
		List<Usuario> usuarios = this.em.createQuery("FROM Usuario WHERE Email = :email")
								.setParameter("email", email)
								.getResultList();
		if(!usuarios.isEmpty()){
			if(usuarios.size() == 1){
				return usuarios.get(0);
			}else{
				throw new MultiplosUsuariosEncontradosException();
			}
		}else{
			throw new UsuarioNaoEncontradoException();
		}
	}
	
    @Transactional
    public Usuario salvar(Usuario usuario) {

        if (usuario.getIdUsuario() == null) {
            em.persist(usuario);
            return usuario;
        }

        return em.merge(usuario);
    }
}
