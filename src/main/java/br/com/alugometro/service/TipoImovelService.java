package br.com.alugometro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alugometro.dao.TipoImovelDAO;
import br.com.alugometro.domain.TipoImovel;

@Service
public class TipoImovelService {

	private TipoImovelDAO tipoImovelDAO;

	@Autowired
	public TipoImovelService(TipoImovelDAO tipoImovelDAO) {
		this.tipoImovelDAO = tipoImovelDAO;
	}
	
	public List<TipoImovel> listarTodos() {
		return tipoImovelDAO.listarTodos();
	}
	
}
