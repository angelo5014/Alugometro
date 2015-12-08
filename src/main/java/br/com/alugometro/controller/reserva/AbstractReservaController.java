package br.com.alugometro.controller.reserva;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import br.com.alugometro.domain.Reserva.SituacaoReserva;
import br.com.alugometro.service.ReservaService;

@Controller
public class AbstractReservaController {

	protected ReservaService reservaService;
	
	@Autowired
	public AbstractReservaController(ReservaService reservaService){
		this.reservaService = reservaService;
	}
	
	@ModelAttribute("situacoes")
    public List<SituacaoReserva> comboSituacao() {
        return reservaService.listarSituacoes();
    }
	
}
