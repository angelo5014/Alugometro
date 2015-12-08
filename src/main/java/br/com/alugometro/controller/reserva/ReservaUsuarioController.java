package br.com.alugometro.controller.reserva;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.alugometro.domain.Reserva.SituacaoReserva;
import br.com.alugometro.dto.ReservaDTO;
import br.com.alugometro.service.ReservaService;

@Controller
@RequestMapping("/reserva")
public class ReservaUsuarioController extends AbstractReservaController {

	@Autowired
	public ReservaUsuarioController(ReservaService reservaService) {
		super(reservaService);
	}
	
	@RequestMapping(path = "/usuario", method = RequestMethod.POST)
	public ModelAndView listarReservasDoUsuario(@ModelAttribute("email") String email) {
		
		List<ReservaDTO> reservas = new ArrayList<>();
			reservas = reservaService.buscarPorEmailUsuario(email);
		return new ModelAndView("reserva/listar", "reservas", reservas);
	}
	
	@RequestMapping(path = "/listarReservasPorBusca", method=RequestMethod.GET)
	public ModelAndView listarReservasPorBusca (
			@RequestParam("dataInicio") String dataInicio,
			@RequestParam("dataFim") String dataFim,
			@RequestParam("situacao") SituacaoReserva situacaoReserva) throws ParseException {
		
		return new ModelAndView("reserva/listar", "reservas", reservaService.buscarPorDataESituacao(dataInicio, 
				dataFim, situacaoReserva));
	}
	
	@RequestMapping(path = "/usuario/{id}", method = RequestMethod.GET)
	public ModelAndView listarReservasDoUsuario(@PathVariable("id") Long idUsuario){
		List<ReservaDTO> reservas = new ArrayList<>();
		reservas = reservaService.buscarPorUsuario(idUsuario);
		return new ModelAndView("reserva/listar", "reservas", reservas);
	}
	
}
