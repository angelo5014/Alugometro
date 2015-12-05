package br.com.alugometro.controller.reserva;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.alugometro.service.ReservaService;

@Controller
public class AbstractReservaController {

	protected ReservaService reservaService;
	
	@Autowired
	public AbstractReservaController(ReservaService reservaService){
		this.reservaService = reservaService;
	}
}
