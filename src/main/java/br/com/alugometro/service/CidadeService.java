package br.com.alugometro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alugometro.dao.CidadeDAO;
import br.com.alugometro.domain.Cidade;

@Service
public class CidadeService {

	private CidadeDAO cidadeDAO;

	@Autowired
	public CidadeService(CidadeDAO cidadeDAO) {
		this.cidadeDAO = cidadeDAO;
	}
	
	public List<Cidade> listarTodos() {
		return cidadeDAO.listarTodos();
	}
	
}
