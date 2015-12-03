package br.com.alugometro.dao;

import org.springframework.stereotype.Repository;

import br.com.alugometro.domain.Foto;

@Repository
public class FotoDAO extends AbstractDAO {

	public Foto encontrarPorId(Long idFoto) {
		return em.find(Foto.class, idFoto);
	}
}
