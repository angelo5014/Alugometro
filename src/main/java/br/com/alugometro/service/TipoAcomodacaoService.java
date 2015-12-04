package br.com.alugometro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alugometro.dao.TipoAcomodacaoDAO;
import br.com.alugometro.domain.TipoAcomodacao;

@Service
public class TipoAcomodacaoService {

	private TipoAcomodacaoDAO tipoAcomodacaoDAO;

	@Autowired
	public TipoAcomodacaoService(TipoAcomodacaoDAO tipoAcomodacaoDAO) {
		this.tipoAcomodacaoDAO = tipoAcomodacaoDAO;
	}

	public List<TipoAcomodacao> listarTodos() {
		return tipoAcomodacaoDAO.listarTodos();
	}
}
