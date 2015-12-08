package br.com.alugometro.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.alugometro.domain.Cidade;
import br.com.alugometro.service.CidadeService;

@Controller
@RequestMapping("/cidades")
public class CidadeController {
	
	private CidadeService cidadeService;

	@Autowired
	public CidadeController(CidadeService cidadeService) {
		super();
		this.cidadeService = cidadeService;
	}
	
	private List<Cidade> comboCidade() {
        return cidadeService.listarTodos();
    }

	@ResponseBody
	@RequestMapping(path = "/rest/")
	public String listarCidades() {
		
		JSONArray cidades = new JSONArray();
		
		for (Cidade cidade : comboCidade()) {
			JSONObject userJSON = new JSONObject();
			userJSON.put("label", cidade.getNome());
			cidades.put(userJSON);
		}
		
		return cidades.toString();
	}
	
}
