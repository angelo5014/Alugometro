package br.com.alugometro.controller.reserva;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.alugometro.dto.ReservaSegurancaDTO;
import br.com.alugometro.service.ReservaService;

@Controller
@RequestMapping("/reserva")
public class ReservaCancelarController extends AbstractReservaController{

	@Autowired
	public ReservaCancelarController(ReservaService reservaService) {
		super(reservaService);
	}
	
	@RequestMapping(path = "/cancelar", method = RequestMethod.POST)
	public ModelAndView cancelarReserva(@ModelAttribute ReservaSegurancaDTO reservaSegurancaDTO) {
		//TODO adicionar cancelamento de reserva
		//reservaService.cancelarReserva(reservaSegurancaDTO);
		
		return new ModelAndView();
	}
	
}
